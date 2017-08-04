package com.cafe.ownerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
public class ConfirmUser extends AppCompatActivity {

    private int conNum;
    Button btn_Confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_user);

        Intent intent = getIntent();
        conNum = intent.getExtras().getInt("conNum");


        btn_Confirm = (Button) findViewById(R.id.btn_confirm_ok);

        btn_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (conNum == 1){
                    Intent intent = new Intent(getApplicationContext(),ChangePw.class);
                    startActivity(intent);
                }
                else if (conNum == 2) {
                    Intent intent = new Intent(getApplicationContext(),ChangeUserInfo.class);
                    startActivity(intent);
                }
                else if (conNum == 3) {
                    Intent intent = new Intent(getApplicationContext(),DeleteUser.class);
                    startActivity(intent);
                }
            }
        });


    }
}