package com.android.teamproject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.android.teamproject.Http.HttpRequest;
import com.android.teamproject.Main_Model_Adapter.ArrayAdapterEx;
import com.android.teamproject.Main_Model_Adapter.ModelCafe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<ModelCafe> cafelist;
    private ArrayAdapterEx adapterEx;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // xml파일에서 TabHost 가져오기
        TabHost host = (TabHost) findViewById(android.R.id.tabhost);
        host.setup();

        // TabHost 생성
        TabHost.TabSpec tab1 = null;
        TabHost.TabSpec tab2 = null;
        TabHost.TabSpec tab3 = null;

        tab1 = host.newTabSpec("빙 수");
        tab1.setContent(R.id.listView);
        tab1.setIndicator("빙 수");
        host.addTab(tab1);

        tab2 = host.newTabSpec("스페셜 티");
        tab2.setContent(R.id.listView);
        tab2.setIndicator("스페셜 티");
        host.addTab(tab2);

        tab3 = host.newTabSpec("버블 티");
        tab3.setContent(R.id.listView);
        tab3.setIndicator("버블 티");
        host.addTab(tab3);

        new ListActivity.HttpLogin().execute();
        cafelist = new ArrayList<>();
        for(int i=0; i<=cafelist.size(); i++){
            ModelCafe cafe = new ModelCafe();
            cafe.setCafe_name(cafelist.get(i).getCafe_name());
            cafe.setStar(cafelist.get(i).getStar());
            cafe.setStar_count(cafelist.get(i).getStar_count());
            cafe.setReview_count(cafelist.get(i).getReview_count());

            cafelist.add((ModelCafe) cafelist);
        }

        adapterEx = new ArrayAdapterEx(this, R.layout.activity_list_item, R.id.brandname, cafelist);

        listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(new OnItemHandler());
        listView.setOnItemLongClickListener(new OnItemHandler());
        listView.setOnItemSelectedListener(new OnItemHandler());

        listView.setAdapter(adapterEx);
    }

    class OnItemHandler implements ListView.OnItemClickListener, ListView.OnItemLongClickListener, ListView.OnItemSelectedListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //String msg = "Adapter Item Count : " + mAdapter.getCount() + "\n";
            //msg += "ListView Item Count : " + parent.getCount();
            //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

            ModelCafe s = (ModelCafe) parent.getItemAtPosition(position);


        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            return false;
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

        // Http List DB 가져오기
    public class HttpLogin extends AsyncTask<String, Integer, List<ModelCafe>> {

        private ProgressDialog waitDlg = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // ProgressDialog 보이기
            // 서버 요청 완료후 Mating dialog를 보여주도록 한다.
            waitDlg = new ProgressDialog(ListActivity.this);
            waitDlg.setMessage(" List 불러오는 중");
            waitDlg.show();
        }

        @Override
        protected List<ModelCafe> doInBackground(String... params) {

            cafelist = itemlist();

            return cafelist;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(List<ModelCafe> s) {
            super.onPostExecute(s);

            // Progressbar 감추기 : 서버 요청 완료수 Maiting dialog를 제거한다.
            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }
        }
    }

    public List<ModelCafe> itemlist() {
        String weburl = "http://192.168.0.52:8080/team/getcafelist";

        HttpRequest request = null;
        JSONArray response = null;

        try {
            request = new HttpRequest(weburl).addHeader("charset", "utf-8")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json");
            int httpCode = request.get();

            if (httpCode == HttpURLConnection.HTTP_OK) { // HttpURLConnection.HTTP_OK == 200
                try {
                    response = request.getJSONArrayResponse(); // 서버값이 리턴된다
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
            }

            JSONObject json = (JSONObject) response.get(1);

            // JSONArray를 List<ModelCafe> 객체로 변환
            String jsonInString = response.toString();
            cafelist = new Gson().fromJson(jsonInString, new TypeToken<List<ModelCafe>>() {
            }.getType());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {

            request.close();
        }
        return cafelist;
    }
}
