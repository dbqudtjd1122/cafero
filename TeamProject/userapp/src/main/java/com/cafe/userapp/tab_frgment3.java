package com.cafe.userapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cafe.userapp.Http.HttpRequest;
import com.cafe.userapp.Http.ModelCafeReview;
import com.google.gson.Gson;

import android.content.SharedPreferences;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


/**
 * A placeholder fragment containing a simple view.
 */
public class tab_frgment3 extends Fragment {


    private ArrayAdapterEx mAdapter = null;
    private ArrayList<write> mData = null;
    private ListView mListView;
    private Button btn;
    private EditText edt_review;
    private RatingBar rtb_review;
    private TextView text;
    private float aaa;
    private ModelCafeReview modelReview;
    private SharedPreferences mPref = null;

    public tab_frgment3() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.tab_frgment3, container, false);

        mListView = (ListView) fragment.findViewById(R.id.reviewlistview);
        btn = (Button) fragment.findViewById(R.id.btn);
        edt_review = (EditText) fragment.findViewById(R.id.edt_review);
        rtb_review = (RatingBar) fragment.findViewById(R.id.rtb_review);
        text = (TextView) fragment.findViewById(R.id.text);
        edt_review.setPrivateImeOptions("defaultInputmode=korea;");


        mData = new ArrayList<>();


        mAdapter = new ArrayAdapterEx(getContext(), R.layout.reviewlistview, R.id.write, mData);
        mListView.setAdapter(mAdapter);

        rtb_review.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                aaa = rating;


            }
        });

        Calendar cal = Calendar.getInstance();


        DateFormat day1 = DateFormat.getDateInstance(DateFormat.FULL, Locale.KOREAN);


        day1.setTimeZone(cal.getTimeZone());

        final String day = day1.format(cal.getTime());


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                write addData = new write();
                addData.setReview(edt_review.getText().toString());
                addData.setDay(day);

                String content = edt_review.getText().toString();
                Float star = rtb_review.getRating();
                String grade = String.valueOf(star);


                edt_review.setText("");

                addData.setStar(aaa);
                rtb_review.setRating(0);


                mAdapter.insert(addData, 0);

                Toast.makeText(getContext(), "리뷰완료!", Toast.LENGTH_SHORT).show();


                new HttpReview().execute(content, grade);

            }
        });

        return fragment;
    }


    //Http리뷰확인
    public class HttpReview extends AsyncTask<String, Integer, String> {

        private ProgressDialog waitDlg = null;


        @Override
        protected String doInBackground(String... params) {
            String content = params[0];

            Double grade = Double.valueOf(params[1]);


            String result = review(content, grade);

            return result;
        }


//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            //ProgressDialog 보이기
//
//            waitDlg = new ProgressDialog(getActivity());
//            waitDlg.setMessage("감사합니다");
//            waitDlg.show();
//
//        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }

//            if (s.equals("1")) //success
//            Toast.makeText(getContext(), "성공", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getActivity(), tab_frgment3.class);
//            startActivity(intent);
//            finish();
        }

        private void finish() {
            finish();
        }


        public String review(String content, Double grade) {
            String weburl = "http://192.168.0.44:8080/review/insertReview";

            HttpRequest request = null;
            String response = null;

            int httpCode = 0;
            try {
                // ModelPerson을 json으로 변환
                ModelCafeReview obj = new ModelCafeReview(content, grade);
                String data = new Gson().toJson(obj);

                request = new HttpRequest(weburl).addHeader("charset", "utf-8")
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Accept", "application/json");
                httpCode = request.post(data);

                if (httpCode == HttpURLConnection.HTTP_OK) { // HttpURLConnection.HTTP_OK == 200
                    try {
                        response = request.getStringResponse(); // 서버값이 리턴된다
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                request.close();
            }
            return response;
        }
    }
}


