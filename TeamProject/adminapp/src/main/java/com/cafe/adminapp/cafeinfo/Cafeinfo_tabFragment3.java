package com.cafe.adminapp.cafeinfo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

import com.cafe.adminapp.R;
import com.cafe.adminapp.adapter.CafeReview_Adapter;
import com.cafe.common.Model.ModelCafeReview;
import com.cafe.common.Model.ModelCafeinfo;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;


public class Cafeinfo_tabFragment3 extends CafeinfoFragment  {

    private View view = null;

    private CafeReview_Adapter adapter;
    private List<ModelCafeReview> review;
    private ModelCafeReview cafeReview = new ModelCafeReview();
    private String nickname ;
    private Button btn_review;
    public ModelCafeinfo cafeinfo = new ModelCafeinfo();
    public Integer REQUEST_CODE = 8573;


    public Cafeinfo_tabFragment3() {
    }

    @Override
    public void recall() {
        super.recall();
        new HttpReviewList().execute(cafeinfo.getCafeno());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cafeinfo_tab_fragment_3, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 액티비티에서 cafeinfo 모델값 받아오기
        cafeinfo = ((FragmentInfoActivity) getActivity()).cafeinfo;

        ListView review_list = (ListView) view.findViewById(R.id.review_list);
        review = new ArrayList<>();

        adapter = new CafeReview_Adapter(getContext(), R.layout.activity_cafereview_item, R.id.tv_nickname, review);

        review_list.setAdapter(adapter);
        new HttpReviewList().execute(cafeinfo.getCafeno());

        nickname = ((FragmentInfoActivity) getActivity()).strnickname.toString();
        btn_review = (Button) view.findViewById(R.id.btn_review);
        btn_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nickname == "" || nickname ==null){
                    Toast.makeText(getContext(), "로그인 해주세요.", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getActivity(), Cafeinfo_tab3_Review.class);
                    intent.putExtra("cafeinfo", cafeinfo);
                    getActivity().startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });
    }

    // Http List DB 가져오기
    public class HttpReviewList extends AsyncTask<Integer, Integer, List<ModelCafeReview>> {

        private ProgressDialog waitDlg = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // ProgressDialog 보이기
            // 서버 요청 완료후 Mating dialog를 보여주도록 한다.
            waitDlg = new ProgressDialog(getContext());
            waitDlg.setMessage(" List 불러오는 중");
            waitDlg.show();
        }

        @Override
        protected List<ModelCafeReview> doInBackground(Integer... params) {

            review = new com.cafe.common.HttpReviewList().reviewlist(params[0]);

            return review;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(List<ModelCafeReview> s) {
            super.onPostExecute(s);

            // 1.
            adapter.clear();
            adapter.addAll(review);
            adapter.notifyDataSetChanged();

            // Progressbar 감추기 : 서버 요청 완료수 Maiting dialog를 제거한다.
            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }
        }

    }
}
