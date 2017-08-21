package com.cafe.adminapp.cafeinfo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.cafe.adminapp.R;
import com.cafe.adminapp.adapter.ArrayAdapterEx;
import com.cafe.adminapp.cafeinfo.ExpandableMenu.ExpandAdapter;
import com.cafe.adminapp.cafeinfo.ExpandableMenu.GroupData;
import com.cafe.common.HttpCafeMenuList;
import com.cafe.common.Model.ModelCafeMenu;
import com.cafe.common.Model.ModelCafeinfo;

import java.util.ArrayList;
import java.util.List;


public class Cafeinfo_tabFragment1 extends CafeinfoFragment{

    private View view = null;
    private ExpandableListView ExpandableListView;
    private ExpandAdapter adapter;
    private ArrayList<GroupData> groupListDatas = new ArrayList<GroupData>();
    private ArrayList<ArrayList<ModelCafeMenu>> childListDatas = new ArrayList<ArrayList<ModelCafeMenu>>();
    private ModelCafeinfo cafeinfo = new ModelCafeinfo();
    private List<ModelCafeMenu> menulist = new ArrayList<>();
    private ProgressDialog waitDlg = null;

    private ArrayAdapterEx adapterEx;

    public Cafeinfo_tabFragment1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cafeinfo_tab_fragment_1, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 액티비티에서 모델값 가져오기
        cafeinfo = ((FragmentInfoActivity) getActivity()).cafeinfo;



        ExpandableListView = (android.widget.ExpandableListView) view.findViewById(R.id.expanded_menu);
        new Cafeinfo_tabFragment1.HttpMenulist().execute( cafeinfo.getBrand().toString() );

        setData2();
        adapter = new ExpandAdapter(getActivity(), groupListDatas, childListDatas);
        ExpandableListView.setAdapter(adapter);

        // Group / Child 체크 이벤트
        /*ExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Toast.makeText(getActivity(), "Group_Clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        ExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(getActivity(), "Child_Clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });*/
    }
    private void setData2(){
        int sizeList = 0;
        groupListDatas.add(new GroupData("커피"));
        childListDatas.add(new ArrayList<ModelCafeMenu>());
        childListDatas.get(sizeList).add(new ModelCafeMenu("아메리카노", 4000, "맛있쪙"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("카페라떼", 5000, "맛없쪙"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("바닐라라떼", 6000, "맛있쪙"));
        groupListDatas.add(new GroupData("빙수"));
        childListDatas.add(new ArrayList<ModelCafeMenu>());
        sizeList++;
        childListDatas.get(sizeList).add(new ModelCafeMenu("팥빙수", 8000, "달아"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("딸기빙수", 9000, "맛있쪙"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("초코빙수", 8500, "달아달아"));
        groupListDatas.add(new GroupData("스무디"));
        childListDatas.add(new ArrayList<ModelCafeMenu>());
        sizeList++;
        childListDatas.get(sizeList).add(new ModelCafeMenu("초코스무디", 6000, "달아"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("녹차스무디", 7000, "???"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("딸기스무디", 8000, "달아달아"));
    }

    private void setData(List<ModelCafeMenu> menu){


        int sizeList = 0;
        groupListDatas.add(new GroupData(menu.get(0).getMenucd().toString()));
        childListDatas.add(new ArrayList<ModelCafeMenu>());
        childListDatas.get(sizeList).add(new ModelCafeMenu("아메리카노", 4000, "맛있쪙"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("카페라떼", 5000, "맛없쪙"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("바닐라라떼", 6000, "맛있쪙"));

        groupListDatas.add(new GroupData("빙수"));
        childListDatas.add(new ArrayList<ModelCafeMenu>());
        sizeList++;
        childListDatas.get(sizeList).add(new ModelCafeMenu("팥빙수", 8000, "달아"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("딸기빙수", 9000, "맛있쪙"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("초코빙수", 8500, "달아달아"));

        groupListDatas.add(new GroupData("스무디"));
        childListDatas.add(new ArrayList<ModelCafeMenu>());
        sizeList++;
        childListDatas.get(sizeList).add(new ModelCafeMenu("초코스무디", 6000, "달아"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("녹차스무디", 7000, "???"));
        childListDatas.get(sizeList).add(new ModelCafeMenu("딸기스무디", 8000, "달아달아"));
    }
    // Http Menu DB 가져오기
    public class HttpMenulist extends AsyncTask<String, Integer, List<String>> {

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
        protected List<String> doInBackground(String... params) {
            List<String> menucd = null;
            try {
                menucd = new HttpCafeMenuList().Menulist(params[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return menucd;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(List<String> menucd) {


            new Cafeinfo_tabFragment1.HttpMenulist2().execute(menucd, cafeinfo.getBrand().toString());

            super.onPostExecute(menucd);
        }
    }

    // ======================================================================================
    // ======================================================================================



    public class HttpMenulist2 extends AsyncTask<Object, Integer, List<ModelCafeMenu>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected List<ModelCafeMenu> doInBackground(Object... params) {
            List<String> menucd = (List<String>) params[0];
            String brand = (String) params[1];
            for(int i=0; i<=menucd.size(); i++) {
                menulist = new HttpCafeMenuList().Menulist2(menucd.get(i), brand);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(List<ModelCafeMenu> menulist) {

            // Progressbar 감추기 : 서버 요청 완료수 Maiting dialog를 제거한다.
            if (waitDlg != null) {
                waitDlg.dismiss();
                waitDlg = null;
            }

            setData(menulist);

            super.onPostExecute(menulist);
        }
    }
}
