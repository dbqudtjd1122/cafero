package com.cafe.userapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // xml파일에서 TabHost 가져오기
        TabHost host = (TabHost) findViewById(android.R.id.tabhost);
        host.setup();

        // TabHost 생성
        TabHost.TabSpec tab1 = null;
        TabHost.TabSpec tab2 = null;
        TabHost.TabSpec tab3 = null;

        tab1 = host.newTabSpec("빙 수");
        tab1.setContent(R.id.listView);
        tab1.setIndicator("빙 수");
        host.addTab(tab1);

        tab2 = host.newTabSpec("스페셜 티");
        tab2.setContent(R.id.listView);
        tab2.setIndicator("스페셜 티");
        host.addTab(tab2);

        tab3 = host.newTabSpec("버블 티");
        tab3.setContent(R.id.listView);
        tab3.setIndicator("버블 티");
        host.addTab(tab3);




    }
}
