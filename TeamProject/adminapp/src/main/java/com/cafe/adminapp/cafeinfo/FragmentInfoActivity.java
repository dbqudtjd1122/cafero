package com.cafe.adminapp.cafeinfo;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cafe.adminapp.R;
import com.cafe.common.CommonActvity;
import com.cafe.common.Model.ModelCafeinfo;


public class FragmentInfoActivity extends CommonActvity{

    public ModelCafeinfo cafeinfo = new ModelCafeinfo();
    private TextView tv_avg_grade, tv_review_count, tv_like_count;
    private RatingBar rb_avg_grade;
    public String strnickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafeinfo_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        cafeinfo = new ModelCafeinfo();
        cafeinfo = (ModelCafeinfo) intent.getSerializableExtra("cafeinfo");

        SharedPreferences pref = getSharedPreferences("Setting", Context.MODE_PRIVATE);
        strnickname = pref.getString("nickname_Set", "");

        // TabLayout 초기화
        TabLayout tabLayout = (TabLayout) findViewById(R.id.cafeinfotab_layout);
        tabLayout.setBackgroundColor(Color.parseColor("#bfdfe0"));
        tabLayout.setTabTextColors(ColorStateList.valueOf(Color.BLACK));

        tabLayout.addTab( tabLayout.newTab().setText("메뉴") );
        tabLayout.addTab( tabLayout.newTab().setText("정보") );
        tabLayout.addTab( tabLayout.newTab().setText("리뷰") );

        setTitle(cafeinfo.getCafename().toString());
        tv_avg_grade = (TextView) findViewById(R.id.tv_avg_grade);
        tv_review_count = (TextView) findViewById(R.id.tv_review_count);
        tv_like_count = (TextView) findViewById(R.id.tv_like_count);
        rb_avg_grade = (RatingBar) findViewById(R.id.rb_avg_grade);

        String avg = String.format("%.1f", cafeinfo.getAvg_grade());
        float avg2 = Float.parseFloat(avg);
        tv_avg_grade.setText(avg);
        tv_review_count.setText(cafeinfo.getReview_count().toString());
        tv_like_count.setText(cafeinfo.getLike_count().toString());
        rb_avg_grade.setRating(avg2);



        final Fragment fragmentManager = getSupportFragmentManager().findFragmentById(R.id.expanded_menu);

        // ViewPager 초기화
        final ViewPager viewPager = (ViewPager) findViewById(R.id.cafeinfo_view_pager);

        // PagerAdater 생성
        InfoTabPagerAdapter pagerAdapter = new InfoTabPagerAdapter( getSupportFragmentManager(), tabLayout.getTabCount() );

        // PagerAdapter와 ViewPager 연결 : Fragment와 ViewPager 연결
        viewPager.setAdapter( pagerAdapter );

        // ViewPager의 OnPageChangeListener 리스너 설정 : TabLayout과 ViewPager
        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabLayout ));

        // Tab을 양쪽 2칸까지 정보를 유지한다.
        viewPager.setOffscreenPageLimit(2);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // TabSelectedListener 설정 : 화면에서 tab을 클릭할때
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem( tab.getPosition() );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public ModelCafeinfo cafeinfodata(){
        return cafeinfo;
    }
}
