package com.cafe.ownerapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cafe.ownerapp.Http.HttpRequest;
import com.cafe.ownerapp.Model.ModelUser;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;

public class ChangePw extends AppCompatActivity {

    private EditText edt_first, edt_second;
    private Button btn_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_pw);

        edt_first = (EditText) findViewById(R.id.edt_changepw_first);
        edt_second = (EditText) findViewById(R.id.edt_changepw_second);

        btn_ok = (Button) findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String passwd = edt_first.getText().toString();
                String passwd2 = edt_second.getText().toString();

                    if (passwd.equals(passwd2)) {
                        new HttpChangePw().execute(passwd); // execute 인자는 HttpLogin의 첫번째 String 인자에 들어감
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "비밀번호를 정확하게 입력해주3", Toast.LENGTH_SHORT);
                        toast.show();
                    }

            }

        });

    }
    public class HttpChangePw extends AsyncTask<String, Integer, String> {// 첫 param 인자 = ID, PW 가운데 인자는 현재 진행률 = Integer 결과 Id,PW String

        ProgressDialog waitDlg = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //ProgressDialog 보이기
            //서버에 요청 동안 Waiting dialog를 보여주도록 한다
            waitDlg = new ProgressDialog(ChangePw.this);
            waitDlg.setMessage("기다리삼");
            waitDlg.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String passwd = params[0];   //  0번째 방 = id

            String result = changepw(passwd);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //ProgressDialog 감추기 : 서버 요청 완료 후 Waiting dialog 감추기
            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }

            // 받은 결과 출력
            if (s.equals("1")){
                //success
                Toast.makeText(getApplicationContext(),"변경 성공",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                // fail
                Toast.makeText(getApplicationContext(),"변경 실패",Toast.LENGTH_SHORT).show();
            }
        }

    }

    public String changepw(String passwd){
        String weburl = "http://192.168.0.54:8080/user/updatePasswd";

        HttpRequest request = null;
        String response = null;

        try {
            // ModelUser를 json으로 변환
            ModelUser obj = new ModelUser(passwd);
            String data = new Gson().toJson(obj); // java object to JSON

            request = new HttpRequest(weburl)
                    .addHeader("charset","utf-8")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json");

            int httpCode = request.post(data);

            if (httpCode == HttpURLConnection.HTTP_OK){
                response = request.getStringResponse();

            }else{
                //error
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }
        return response;
    }
}