package com.cafe.userapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.cafe.userapp.Http.ModelCafeMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class tab_frgment1 extends Fragment {

    private View view = null;
    private boolean calling = false;
    AdapterCustom adapter = null;

    public tab_frgment1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_frgment1, container, false);


        GridView lv = (GridView) view.findViewById(R.id.gridView);

        // 데이터 생성
        List<ModelItem> list = new ArrayList<>();

        // 어댑터 객체 생성
        adapter = new AdapterCustom(getActivity(), R.layout.list_item, R.id.dataItem01, list);
        adapter.setInitData(0, 10);

        // 리스뷰와 어댑터 연결
        lv.setAdapter(adapter);

        // item click listener
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                ModelItem s = (ModelItem) parent.getItemAtPosition(position);
//                Toast.makeText(getActivity(), s.getDataItem01() + " clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        // item long click listener
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView parent, View v, int posotion, long id) {
                return true;
            }
        });

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                // Sample calculation to determine if the last item is fully visible.
                final int lastItem = firstVisibleItem + visibleItemCount;
                if (lastItem == totalItemCount) {
                    if (!calling) {
                        calling = true;
                        //to avoid multiple calls for last item
                        new HttpMenu().execute(adapter.getCount(), adapter.getCount() + 10);
                    }
                }
            }
        });

        return view;

    }


    public class HttpMenu extends AsyncTask<Integer, Integer, List<ModelItem>> {
        private ProgressDialog waitDlg = null;

//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//            //서버에 요청 동안 Wating dialog를 보여주도록 한다.
//            waitDlg = new ProgressDialog(getActivity());
//            waitDlg.setMessage(" 버전 확인 중");
//            waitDlg.show();
//        }

        @Override
        protected List<ModelItem> doInBackground(Integer... params) {

            List<ModelItem> list = adapter.makeData(params[0], params[1]);
            return list;
        }

        @Override
        protected void onPostExecute(List<ModelItem> result) {
            super.onPostExecute(result);

            //서버 요청 완료 후 Waiting dialog를 제거한다.
            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }

            calling = false;

            adapter.addAll(result);
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
