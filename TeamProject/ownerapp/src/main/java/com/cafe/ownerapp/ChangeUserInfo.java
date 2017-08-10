package com.cafe.ownerapp;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.cafe.ownerapp.Http.HttpRequest;
import com.cafe.ownerapp.Model.ModelUser;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;

public class ChangeUserInfo extends AppCompatActivity {


    private EditText edtEmail, edtPasswd, edtAddr, edtNickname, edtUserphone;
    private RadioButton rdbMan, rdbWoman;
    private RadioGroup rdbGroup;
    private Button btnOk;
    private CheckBox checkEmail;
    private String sexstr,emailstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_user_info);


        edtPasswd = (EditText) findViewById(R.id.edt_change_pw);
        edtAddr = (EditText) findViewById(R.id.edt_change_addr);
        edtNickname = (EditText) findViewById(R.id.edt_change_nickname);
        edtUserphone = (EditText) findViewById(R.id.edt_change_userphone);

        rdbMan = (RadioButton) findViewById(R.id.rbtn_man);
        rdbWoman = (RadioButton) findViewById(R.id.rbtn_woman);
        rdbGroup = (RadioGroup) findViewById(R.id.rdb_group);

        checkEmail = (CheckBox) findViewById(R.id.check_email);

        btnOk = (Button) findViewById(R.id.btn_change_complete);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(rdbMan.isChecked() == true){sexstr = "남자";} else {sexstr = "여자";}
                    if(checkEmail.isChecked() == true){emailstr = "1";} else {emailstr = "0";}

                // AsyncTask 호출

                String passwd = edtPasswd.getText().toString();
                String addr = edtAddr.getText().toString();
                String nickname = edtNickname.getText().toString();
                String userphone = edtUserphone.getText().toString();
                String selectEmail = emailstr.toString();
                String sex = sexstr.toString();

                new HttpLogin().execute(selectEmail,passwd,userphone,nickname,sex,addr); // execute 인자는 HttpLogin의 첫번째 String 인자에 들어감
            }
        });

    }

    public class HttpLogin extends AsyncTask<String, Integer, String> {// 첫 param 인자 = ID, PW 가운데 인자는 현재 진행률 = Integer 결과 Id,PW String

        ProgressDialog waitDlg = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //ProgressDialog 보이기
            //서버에 요청 동안 Waiting dialog를 보여주도록 한다
            waitDlg = new ProgressDialog(ChangeUserInfo.this);
            waitDlg.setMessage("기다리삼");
            waitDlg.show();
        }

        @Override
        protected String doInBackground(String... params) {
             //  0번째 방 = id
            String selectEmail = params[0];   //  1번쨰 방 = pw
            String passwd = params[1];
            String userphone = params[2];
            String nickname = params[3];
            String sex = params[4];
            String addr = params[5];

            String result = changeuserinfo(selectEmail,passwd,userphone,nickname,sex,addr);
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
//                Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                // fail
//                Toast.makeText(getApplicationContext(),"로그인 실패",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public String changeuserinfo(String selectEmail, String passwd, String sex, String addr, String nickname, String userphone ){
        String weburl = "http://192.168.0.54:8080/user/updateUserInfo";

        HttpRequest request = null;
        String response = null;

        try {
            // ModelUser를 json으로 변환
            ModelUser obj = new ModelUser(passwd,addr,nickname,sex,userphone,selectEmail);
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
