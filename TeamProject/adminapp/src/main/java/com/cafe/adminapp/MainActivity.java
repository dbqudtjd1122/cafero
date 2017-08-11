package com.cafe.adminapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cafe.adminapp.cafeinfo.FragmentListActivity;
import com.cafe.adminapp.userinfo.Userinfo;
import com.cafe.common.CommonActvity;

public class MainActivity extends CommonActvity
        implements NavigationView.OnNavigationItemSelectedListener {

    private View hView;
    private TextView nickname, level;
    private ImageView headerimg;
    private Button logout;
    private int REQUEST_CODE = 2004;

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

        hView = navigationView.getHeaderView(0);
        headerimg = (ImageView) hView.findViewById(R.id.headerimg);
        nickname = (TextView) hView.findViewById(R.id.nickname);
        level = (TextView) hView.findViewById(R.id.level);
        logout = (Button) hView.findViewById(R.id.logout);

        SharedPreferences pref = getSharedPreferences("Setting", Context.MODE_PRIVATE);
        String strnickname = pref.getString("nickname_Set", "");

        if (strnickname == "" || strnickname == null) {
            headerimg.setVisibility(View.VISIBLE);
        } else {
            headerimg.setVisibility(View.GONE);
            nickname.setText(isnickname);
            level.setText(islevel);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (headerimg.getVisibility() == View.GONE) {
                    onDestroy();
                } else {
                }
            }
        });

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

        //NavigationView navigationView = (NavigationView) findViewById(R.id.activity_main_drawer);

        if (item.getItemId() == R.id.menulogin) {
            // MenuItem aa;
            // aa = (MenuItem) findViewById(R.id.menulogin);
            // aa.setVisible(true);
            item.setVisible(false);



            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
        if (id == R.id.nav_camera) {
            // Handle the* camera action
            Toast.makeText(getApplicationContext(), "카메라", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.userinfo) {
            Intent userinfo = new Intent(MainActivity.this, Userinfo.class);
            startActivity(userinfo);

        } else if (id == R.id.menulogout){

        }
            return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String strnickname = data.getStringExtra("nickname_Set");
                String strlevel = data.getStringExtra("level_Set");

                nickname.setText(strnickname);
                level.setText("Lv." + strlevel);
                headerimg.setVisibility(View.GONE);

                Toast.makeText(getApplicationContext(), nickname.getText().toString() + " 환영합니다.", Toast.LENGTH_SHORT).show();
            }
            // 리턴값이 없을때
            else {
            }
        }
    }

    // 메인 레이아웃 클릭 이벤트
    public void layoutClick(View view) {

        Intent intent2 = new Intent(MainActivity.this, FragmentListActivity.class);
        switch (view.getId()) {
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

    // 로그아웃
    @Override
    protected void onDestroy() {
        // 공유 프레퍼런스 값이 변경되었을때 호출되는 등록된 리스너 해제
        // pref.unregisterOnSharedPreferenceChangeListener(new PrefChangeListener());
        super.onDestroy();

        SharedPreferences pref = getSharedPreferences("Setting", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("nickname_Set");
        editor.remove("level_Set");

        nickname.setText("");
        level.setText("");
        editor.clear();
        editor.commit();

        headerimg.setVisibility(View.VISIBLE);
    }
}
