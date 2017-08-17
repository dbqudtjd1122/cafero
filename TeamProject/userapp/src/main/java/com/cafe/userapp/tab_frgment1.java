package com.cafe.userapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
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
    private TextView menutype, dataItem01, detai1, dataItem02, dataItem03, dataItem04, detai2;
    private review review;
    private ModelCafeMenu cafeMenu = new ModelCafeMenu();


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

        new HttpRequestAsyncTask().execute();

        return view;

    }

    public class HttpRequestAsyncTask extends AsyncTask<Integer, Integer, Integer> {

        ProgressDialog waitDlg = null;

        @Override
        protected Integer doInBackground(Integer... params) {
            Integer version = null;
            try {
                version = request();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return version;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            waitDlg = new ProgressDialog(getContext());
            waitDlg.setMessage("버전확인중");
            waitDlg.show();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }

//            menutype = (TextView) review1.findViewById(R.id.menutype);
//            dataItem01 = (TextView) review1.findViewById(R.id.dataItem01);
//            dataItem02 = (TextView) review1.findViewById(R.id.dataItem02);
//            dataItem03 = (TextView) review1.findViewById(R.id.dataItem03);
//            dataItem04 = (TextView) review1.findViewById(R.id.dataItem04);
//            detai1 = (TextView) review1.findViewById(R.id.detai1);
//            detai2 = (TextView) review1.findViewById(R.id.detai2);
            menutype = (TextView) view.findViewById(R.id.menutype);
            dataItem01 = (TextView) view.findViewById(R.id.dataItem01);
            dataItem02 = (TextView) view.findViewById(R.id.dataItem02);
            dataItem03 = (TextView) view.findViewById(R.id.dataItem03);
            dataItem04 = (TextView) view.findViewById(R.id.dataItem04);
            detai1 = (TextView) view.findViewById(R.id.detai1);
            detai2 = (TextView) view.findViewById(R.id.detai2);

            //integer에 결과가 담겨옴
            menutype.setText(String.valueOf(integer));
            dataItem01.setText(String.valueOf(integer));
            dataItem02.setText(String.valueOf(integer));
            dataItem03.setText(String.valueOf(integer));
            dataItem04.setText(String.valueOf(integer));
            detai1.setText(String.valueOf(integer));
            detai2.setText(String.valueOf(integer));
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Integer integer) {
            super.onCancelled(integer);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();

            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }
        }
    }

    private Integer request() throws IOException {

        BufferedReader rd = null;
        HttpURLConnection HttpConn = null;
        InputStream in = null;
        Integer result = null;

        //서버주소
        String weburl = "http://192.168.0.239:8080/menu/cafenomenu";

        URL url = null;

        try {
            url = new URL(weburl);
            HttpConn = (HttpURLConnection) url.openConnection();
            HttpConn.setConnectTimeout(1000);
            HttpConn.setReadTimeout(1000);
            HttpConn.setRequestMethod("GET");
            HttpConn.setRequestProperty("charset", "utf-8");
            HttpConn.connect();

            int responseCode = HttpConn.getResponseCode();

            if (responseCode < 200 || responseCode >= 300) {
                //오류
                Log.d("request", HttpConn.getResponseMessage());
                return -1;
            }

            in = HttpConn.getInputStream();
            rd = new BufferedReader(new InputStreamReader(in));
            StringBuffer bf = new StringBuffer();

            String line = "";
            for (; (line = rd.readLine()) != null; ) {
                bf.append(line);
            }

            result = Integer.valueOf(bf.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            result = -1;
        } finally {

            if (rd != null) rd.close();
            if (in != null) in.close();

            HttpConn.disconnect();
        }
        return result;
    }


    ////////////////////////////////////////////////////////////////////////////////////////
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

