package com.cafe.adminapp.cafeinfo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cafe.adminapp.R;
import com.cafe.common.HttpCafeinfo;
import com.cafe.adminapp.adapter.ArrayAdapterEx;
import com.cafe.common.Model.ModelCafeinfo;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class tabFragment1 extends CafeinfoFragment {

    private View view = null;

    private ArrayAdapterEx adapterEx;
    private List<ModelCafeinfo> cafelist;
    private ModelCafeinfo cafeinfo = new ModelCafeinfo();

    public tabFragment1() {
    }
    @Override
    public void recall() {
        super.recall();
        new tabFragment1.Httplist().execute(cafeinfo, getOrderKind());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 출력 데이터 생성
        // ListView 생성
        // Adapter 생성
        // ListView와 Adapter 연결

        // 출력 데이터 생성

        // ListView 생성
        ListView listView= (ListView) view.findViewById(R.id.fraglist1);

        // 출력 데이터 생성
        cafelist = new ArrayList<>();

        // Adapter 생성
        adapterEx = new ArrayAdapterEx(getContext(), R.layout.activity_list_item, R.id.cafe_name, cafelist);

        cafeinfo.setCafebigtype("카페");

        // ListView와 Adapter 연결
        listView.setAdapter(adapterEx);
        new tabFragment1.Httplist().execute(cafeinfo, "review_count");


    }
    // Arrays List Adapter 연결
    class OnItemHandler implements ListView.OnItemClickListener, ListView.OnItemLongClickListener, ListView.OnItemSelectedListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //String msg = "Adapter Item Count : " + mAdapter.getCount() + "\n";
            //msg += "ListView Item Count : " + parent.getCount();
            //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

            ModelCafeinfo s = (ModelCafeinfo) parent.getItemAtPosition(position);
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
    }

    // Http List DB 가져오기
    public class Httplist extends AsyncTask<Object, Integer, List<ModelCafeinfo>> {

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
        protected List<ModelCafeinfo> doInBackground(Object... params) {


            try {
                cafelist = new HttpCafeinfo().itemlist((ModelCafeinfo)params[0] , (String)params[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return cafelist;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(List<ModelCafeinfo> modelCafeinfos) {

            super.onPostExecute(modelCafeinfos);

            // 1.
            cafelist = modelCafeinfos;
            adapterEx.clear();
            adapterEx.addAll(cafelist);
            adapterEx.notifyDataSetChanged();

            // Progressbar 감추기 : 서버 요청 완료수 Maiting dialog를 제거한다.
            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }
            super.onPostExecute(modelCafeinfos);
        }
    }


}
