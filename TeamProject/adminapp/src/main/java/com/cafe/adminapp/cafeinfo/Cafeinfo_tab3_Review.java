package com.cafe.adminapp.cafeinfo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cafe.adminapp.R;
import com.cafe.common.CommonActvity;
import com.cafe.common.HttpReviewInsert;
import com.cafe.common.Model.ModelCafeReview;
import com.cafe.common.Model.ModelCafeinfo;

import java.util.List;

public class Cafeinfo_tab3_Review extends CommonActvity {

    private RatingBar rb_grade;
    private TextView tv_review_nickname;
    private EditText edit_review;
    private Button btn_review_finsh;
    private ModelCafeinfo cafeinfo;
    private ModelCafeReview cafeReview = new ModelCafeReview();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafeinfo_tab3_review);

        rb_grade = (RatingBar) findViewById(R.id.rb_grade);
        tv_review_nickname = (TextView) findViewById(R.id.tv_review_nickname);
        edit_review = (EditText) findViewById(R.id.edit_review);
        btn_review_finsh = (Button) findViewById(R.id.btn_review_finsh);

        SharedPreferences pref = getSharedPreferences("Setting", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        tv_review_nickname.setText(pref.getString("nickname_Set", "").toString());

        Intent intent = getIntent();
        cafeinfo = new ModelCafeinfo();
        cafeinfo = (ModelCafeinfo) intent.getSerializableExtra("cafeinfo");

        btn_review_finsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cafeReview.setCafeno(cafeinfo.getCafeno());
                cafeReview.setGrade(rb_grade.getRating());
                cafeReview.setUsernickname(tv_review_nickname.getText().toString());
                cafeReview.setContent(edit_review.getText().toString());

                new HttpReview().execute(cafeReview);
            }
        });
    }

    // Http List DB 가져오기
    public class HttpReview extends AsyncTask<Object, Integer, ModelCafeReview> {

        private ProgressDialog waitDlg = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // ProgressDialog 보이기
            // 서버 요청 완료후 Mating dialog를 보여주도록 한다.
            waitDlg = new ProgressDialog(getApplicationContext());
            waitDlg.setMessage(" List 불러오는 중");
            waitDlg.show();
        }

        @Override
        protected ModelCafeReview doInBackground(Object... params) {

            new HttpReviewInsert().reviewinsert(params[0]);

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(ModelCafeReview s) {
            super.onPostExecute(s);

            // Progressbar 감추기 : 서버 요청 완료수 Maiting dialog를 제거한다.
            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }
        }
    }
}
