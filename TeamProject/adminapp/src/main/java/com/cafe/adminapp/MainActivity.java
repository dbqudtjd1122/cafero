package com.cafe.adminapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.transition.Visibility;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.cafe.adminapp.cafeinfo.FragmentListActivity;
import com.cafe.common.Model.ModelUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private View hView;
    private TextView nickname, level;
    private ImageView headerimg;
    private SharedPreferences pref = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        setTitle("카페路로");

        // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        // fab.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View view) {
        //         Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                 .setAction("Action", null).show();
        //     }
        // });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        hView =  navigationView.getHeaderView(0);
        headerimg = (ImageView) hView.findViewById(R.id.headerimg);
        nickname = (TextView)hView.findViewById(R.id.nickname);
        level = (TextView) hView.findViewById(R.id.level);


        Intent mainintent = getIntent();
        String stremail =  mainintent.getStringExtra("email".toString());
        String strnickname =  mainintent.getStringExtra("nickname".toString());
        String strlevel = mainintent.getStringExtra("level".toString());

        // 1. 공유 프레퍼런스 객체를 얻어온다. /data/data/패키지명/shared_prefs/Setting.xml
        pref = getSharedPreferences("Setting", Context.MODE_PRIVATE);

        // 2. 공유 프레퍼런스를 이용하여 로그인 on/off 설정값을 얻어온다.
        int isheaderimg = pref.getInt("headerimg_Set", View.GONE);
        String isnickname = pref.getString("nickname_Set", nickname.getText().toString());
        String islevel = pref.getString("level_Set", level.getText().toString());

        // 3. 현재 사운드 설정값을 체크 박스에 반영한다.
        headerimg.setVisibility(View.GONE);
        nickname.setText(isnickname);
        level.setText(islevel);

        if(strnickname !=null && strlevel !=null ){
            HeaderLogin(strnickname, strlevel);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.activity_main_drawer, menu);

        MenuItem item = menu.add(0, 1, 0, "로그인");
        menu.add(0, 2, 0, "공지사항");
        menu.add(0, 3, 0, "이벤트");

        /*if(headerimg.getVisibility() == View.GONE){
            item.setVisible(false);
        }
        else {
            item.setVisible(true);
        }*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*switch (item.getItemId()){
            case show:
                break;
        }*/

        if(item.getItemId() == R.id.login){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if (id == R.id.nav_camera) {
            // Handle the camera action
            Toast.makeText(getApplicationContext(), "카메라", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        return true;
    }

    public void layoutClick(View view) {

        Intent intent2 = new Intent(MainActivity.this, FragmentListActivity.class);
        switch (view.getId()){
            case R.id.linear1:
                startActivity(intent2);
                break;
            case R.id.linear2:
                startActivity(intent2);
                break;
            case R.id.linear3:
                startActivity(intent2);
                break;
        }
    }
    public void HeaderLogin(String strnickname, String strlevel){

        headerimg.setVisibility(View.GONE);
        nickname.setText(strnickname);
        level.setText("Lv."+strlevel);

        SharedPreferences.Editor prefEditor = pref.edit();
        prefEditor.putInt("headerimg_Set", headerimg.getVisibility());
        prefEditor.putString("nickname_Set", nickname.getText().toString());
        prefEditor.putString("level_Set", level.getText().toString());
        prefEditor.apply();
    }

    @Override
    protected void onDestroy() {
        // 공유 프레퍼런스 값이 변경되었을때 호출되는 등록된 리스너 해제
        // pref.unregisterOnSharedPreferenceChangeListener(new PrefChangeListener());
        super.onDestroy();
    }
}
