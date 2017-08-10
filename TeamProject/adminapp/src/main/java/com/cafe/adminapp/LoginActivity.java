package com.cafe.adminapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cafe.adminapp.cafeinfo.FragmentListActivity;
import com.cafe.common.Http.HttpRequest;
import com.cafe.common.Model.ModelCafeinfo;
import com.cafe.common.Model.ModelUser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText editID, editPW;
    private Button btnLogin, Signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        // 좌측 메뉴 로그인
        editID = (EditText) findViewById(R.id.editID);
        editPW = (EditText) findViewById(R.id.editPW);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        Signup = (Button) findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // AysncTask 호출
                String id = editID.getText().toString();
                String pw = editPW.getText().toString();
                new HttpLogin().execute(id, pw);
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    // Http 로그인 확인
    public class HttpLogin extends AsyncTask<String, Integer, ModelUser> {

        private ProgressDialog waitDlg = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // ProgressDialog 보이기
            // 서버 요청 완료후 Mating dialog를 보여주도록 한다.
            waitDlg = new ProgressDialog(LoginActivity.this);
            waitDlg.setMessage(" ID / PW 확인 중");
            waitDlg.show();
        }

        @Override
        protected ModelUser doInBackground(String... params) {

            String id = params[0];
            String pw = params[1];

            ModelUser result = login(id, pw);

            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(ModelUser modelUser) {
            super.onPostExecute(modelUser);

            // Progressbar 감추기 : 서버 요청 완료수 Maiting dialog를 제거한다.
            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("email" , modelUser.getEmail().toString());
            intent.putExtra("nickname" , modelUser.getUsernickname().toString());
            intent.putExtra("level" , modelUser.getUserlevel().toString());
            startActivity(intent);

        }
    }

    public ModelUser login(String id, String pw) {
        String weburl = "http://192.168.0.52:8080/team/login";

        HttpRequest request = null;
        JSONObject response = null;
        ModelUser user = null;


        try {

            request = new HttpRequest(weburl).addHeader("charset", "utf-8");
            request.addParameter("email", id);
            request.addParameter("passwd", pw);

            int httpCode = request.post();

            if (httpCode == HttpURLConnection.HTTP_OK) {

                response = request.getJSONObjectResponse();
            } else {
                // error
            }
            String jsonInString = response.toString();
            user = new Gson().fromJson(jsonInString, ModelUser.class);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }
        return user;

    }
}