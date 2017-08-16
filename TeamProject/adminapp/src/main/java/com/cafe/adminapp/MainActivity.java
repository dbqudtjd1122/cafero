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

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.cafe.adminapp.cafelist.FragmentListActivity;
import com.cafe.adminapp.userinfo.Userinfo;
import com.cafe.common.CommonActvity;

public class MainActivity extends CommonActvity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener {

    private View hView;
    private TextView nickname, level;
    private ImageView headerimg;
    private int REQUEST_CODE = 2004;
    private String strnickname = "";
    private EditText edit_cafe_name, edit_cafe_addr;
    private Button btn_cafe_name, btn_cafe_addr;

    private MenuItem menulogin, menulogout;
    private float xATDown, xATUp;
    private ViewFlipper vflipper = null;

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
        edit_cafe_name = (EditText) findViewById(R.id.edit_cafe_name);
        edit_cafe_addr = (EditText) findViewById(R.id.edit_cafe_addr);
        btn_cafe_name = (Button) findViewById(R.id.btn_cafe_name);
        btn_cafe_addr = (Button) findViewById(R.id.btn_cafe_addr);


        SharedPreferences pref = getSharedPreferences("Setting", Context.MODE_PRIVATE);
        strnickname = pref.getString("nickname_Set", "");


        // 로그인정보가 없는경우
        if (strnickname == "" || strnickname == null) {
            headerimg.setVisibility(View.VISIBLE);
        // 로그인정보가 있는경우
        } else {
            headerimg.setVisibility(View.GONE);
            nickname.setText(isnickname);
            level.setText(islevel);
        }

        // 뷰플리퍼 자동 넘김 (광고 배너)
        vflipper = (ViewFlipper) findViewById(R.id.viewflipper);
        vflipper.setOnTouchListener(this);
        vflipper.setAutoStart(true);
        // vflipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
        vflipper.setFlipInterval(1000);
        vflipper.startFlipping();

        btn_cafe_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_cafe_name.getText().toString();
                Intent intent3 = new Intent(MainActivity.this, NameSearchList.class);
                intent3.putExtra("name", name);
                startActivity(intent3);
            }
        });
        btn_cafe_addr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr = edit_cafe_addr.getText().toString();
                Intent intent4 = new Intent(MainActivity.this, AddrSearchList.class);
                intent4.putExtra("addr", addr);
                startActivity(intent4);
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

        /*MenuItem item = menu.add(0, 1, 0, "로그인");
        menu.add(0, 2, 0, "공지사항");
        menu.add(0, 3, 0, "이벤트");*/

        /*menulogin = menu.getItem(1);
        menulogout = menu.getItem(6);
        // menulogout = (MenuItem) this.findViewById(R.id.menulogout);

        // 로그인정보가 없는경우
        if (strnickname == "" || strnickname == null) {
            menulogin.setVisible(true);
            menulogout.setVisible(false);
            //menulogin.findItem(R.id.menulogin).setVisible(true);
            //menulogout.findItem(R.id.menulogout).setVisible(false);
            // 로그인정보가 있는경우
        } else {
            menulogin.setVisible(false);
            menulogout.setVisible(true);
            //menulogin.findItem(R.id.menulogin).setVisible(false);
            // menulogout.findItem(R.id.menulogout).setVisible(true);
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


        if (item.getItemId() == R.id.menulogin) {
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


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Animation showln= AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation showout= AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        if(v !=vflipper) {
            return false;
        }
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            xATDown=event.getX(); // 터치 시작지점 X좌표 저장
        }
        else if(event.getAction()==MotionEvent.ACTION_UP){
            xATUp=event.getX(); // 터치 끝난지점에 X좌표 저장
            if (xATUp < xATDown){
                vflipper.setInAnimation(showout);
                vflipper.showNext();  // 다음 view 보여줌
            }else if(xATUp > xATDown){
                vflipper.setInAnimation(showln);
                vflipper.showPrevious();   // 직전 view 보여줌
            }
        }
        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
