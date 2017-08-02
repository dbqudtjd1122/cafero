package com.cafe.userapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import static android.R.transition.fade;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnTouchListener, CompoundButton.OnCheckedChangeListener{

    private ViewFlipper vflipper = null;
    private float xATDown;
    private float xATUp;
    private ImageButton imageButton;
//    ArrayAdapterEx mAdapter = null;
//    ArrayList<wirte> mData = null;
//    private ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageButton = (ImageButton) findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),review.class);
                startActivity(intent);
            }
        });




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






        vflipper = (ViewFlipper) findViewById(R.id.viewflipper);
        vflipper.setOnTouchListener(this);

        vflipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
        vflipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
        vflipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
        vflipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));

        vflipper.setFlipInterval(3000);

        vflipper.startFlipping();

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


    @Override
    public boolean onTouch(View v, MotionEvent event) {
//        Animation showln= AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
//        Animation showout= AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);


        if(v !=vflipper) {
            return false;
        }
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            xATDown=event.getX(); // 터치 시작지점 X좌표 저장
        }
        else if(event.getAction()==MotionEvent.ACTION_UP){
            xATUp=event.getX(); // 터치 끝난지점에 X좌표 저장
            if (xATUp < xATDown){
                Animation showln= AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

                vflipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
                vflipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));

                vflipper.showNext();  // 다음 view 보여줌
            }else if(xATUp > xATDown){
                Animation showout= AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

                vflipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
                vflipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
                vflipper.showPrevious();   // 직전 view 보여줌
            }
        }
        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
