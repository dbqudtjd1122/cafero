package com.android.userapp_tabandfragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class tab_frgment1 extends Fragment {

    private View view = null;

    public tab_frgment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_frgment1, container, false);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);






//        ListView생성
//        Adapter생성
//        ListView 와 Adapter 연결
//
//        ListView생성
//        ListView listView = (ListView) view.findViewById(R.id.list_view);
//
//        //출력 데이터 생성
//        List<String> list = new ArrayList<>();
//        list.add("Item1");
//        list.add("Item2");
//        list.add("Item3");
//        list.add("Item4");
//        list.add("Item5");
//        list.add("Item6");
//        list.add("Item7");
//        list.add("Item8");
//        list.add("Item1");
//        list.add("Item2");
//        list.add("Item3");
//        list.add("Item4");
//        list.add("Item5");
//        list.add("Item6");
//        list.add("Item7");
//        list.add("Item8");
//
//
//        Adapter생성
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
//
//        ListView 와 Adapter 연결
//        listView.setAdapter(adapter);

    }
}
