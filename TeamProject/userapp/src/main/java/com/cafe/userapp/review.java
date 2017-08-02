package com.cafe.userapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;


public class review extends AppCompatActivity {

    ArrayAdapterEx mAdapter = null;
    ArrayList<wirte> mData = null;
    private ListView mListView;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        ratingBar = (RatingBar) findViewById(R.id.rtb_review);

        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("menu").setIndicator("메뉴");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("imformation").setIndicator("정보");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("reivew").setIndicator("리뷰");
        tab3.setContent(R.id.tab3);
        tabHost.addTab(tab3);

        tabHost.setCurrentTab(0);


        mListView = (ListView) findViewById(R.id.reviewlistview);

        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            wirte data = new wirte();
            data.setReview("들어가랏!!!");
            data.setStar("0점");
            mData.add(data);
        }


        mAdapter = new ArrayAdapterEx(this, R.layout.reviewlistview, R.id.write, mData);
        mListView.setAdapter(mAdapter);

    }

    public void onclick(View view) {
        final wirte addData = new wirte();
        switch (view.getId()) {
            case R.id.btn:
                EditText edt_review = (EditText) findViewById(R.id.edt_review);
                final RatingBar rtb_review = (RatingBar) findViewById(R.id.rtb_review);

                rtb_review.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        
                    }
                });

//                wirte addData = new wirte();
                addData.setReview(edt_review.getText().toString());


                mAdapter.insert(addData, 0);

                Toast.makeText(getApplicationContext(), "리뷰완료!!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
