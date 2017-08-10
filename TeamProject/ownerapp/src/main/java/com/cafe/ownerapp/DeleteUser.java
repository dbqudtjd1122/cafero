package com.cafe.ownerapp;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.cafe.ownerapp.Http.HttpRequest;
import com.cafe.ownerapp.Model.ModelUser;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;

public class DeleteUser extends AppCompatActivity {

    private CheckBox ck_deluser;
    private Button btn_delete_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_user);

        ck_deluser = (CheckBox) findViewById(R.id.ck_del_user);
        btn_delete_ok = (Button) findViewById(R.id.btn_delete_ok);

        btn_delete_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ck_deluser.isChecked() == true){
                    Toast toast = Toast.makeText(getApplicationContext(),"탈퇴 완료",Toast.LENGTH_SHORT);
                    toast.show();
                    new HttpDeleteUser().execute();
                }
                else {

                }
            }
        });

    }

    public class HttpDeleteUser extends AsyncTask<String, Integer, String> {// 첫 param 인자 = ID, PW 가운데 인자는 현재 진행률 = Integer 결과 Id,PW String

        ProgressDialog waitDlg = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //ProgressDialog 보이기
            //서버에 요청 동안 Waiting dialog를 보여주도록 한다
            waitDlg = new ProgressDialog(DeleteUser.this);
            waitDlg.setMessage("기다리삼");
            waitDlg.show();
        }

        @Override
        protected String doInBackground(String... params) {

            String selectEmail = params[0];   //  1번쨰 방 = pw

            //String result = changeuserinfo();
            return selectEmail;
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
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
            else {

            }
        }
    }

    public String deleteuser(){
        String weburl = "http://192.168.0.54:8080/user/deleteUser";

        HttpRequest request = null;
        String response = null;

        try {
            // ModelUser를 json으로 변환
            ModelUser obj = new ModelUser();
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
