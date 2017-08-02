package com.cafe.userapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cafe.userapp.Http.HttpRequest;

import java.io.IOException;
import java.net.HttpURLConnection;

public class LoginActivity extends AppCompatActivity {

    EditText editID, editPW;
    Button btnLogin, button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        // 좌측 메뉴 로그인
        editID = (EditText) findViewById(R.id.editID);
        editPW = (EditText) findViewById(R.id.editPW);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        button = (Button) findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // AysncTask 호출
                String id = editID.getText().toString();
                String pw = editPW.getText().toString();
                new HttpLogin().execute(id, pw);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    // Http 로그인 확인
    public class HttpLogin extends AsyncTask<String, Integer, String>{

        private ProgressDialog waitDlg = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // ProgressDialog 보이기
            // 서버 요청 완료후 Mating dialog를 보여주도록 한다.
            waitDlg = new ProgressDialog(getApplicationContext());
            waitDlg.setMessage(" ID / PW 확인 중");
            waitDlg.show();
        }

        @Override
        protected String doInBackground(String... params) {

            String id = params[0];
            String pw = params[1];

            String result = login(id, pw);

            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            // Progressbar 감추기 : 서버 요청 완료수 Maiting dialog를 제거한다.
            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }
            if (s.equals("1")) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        }
    }
    public String login(String id, String pw){
        String weburl = "http://192.168.0.52:8080/team/login";

        HttpRequest request = null;
        String response = "";

        try {
            request = new HttpRequest(weburl).addHeader("charset", "utf-8");
            request.addParameter("email", id);
            request.addParameter("pw", pw);
            int httpCode = request.post();

            if(httpCode == HttpURLConnection.HTTP_OK){
                response = request.getStringResponse();
            }
            else {
                // error
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }
        return response;
    }
}
