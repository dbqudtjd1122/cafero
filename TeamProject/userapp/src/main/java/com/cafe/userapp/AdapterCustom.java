package com.cafe.userapp;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterCustom extends ArrayAdapter<ModelItem> {

    public Context context = null;
    private ViewHolder holder = null;
    private LayoutInflater inflater = null;

    private class ViewHolder {
        private ImageView mIcon;
        private TextView mText01;
        private TextView mText02;
        private TextView mText03;
        private TextView mText04;
        private TextView menutype;
        private TextView detail1;
        private TextView detail2;

    }

    public AdapterCustom(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<ModelItem> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.i("getView", "started");

        View itemLayout = super.getView(position, convertView, parent);

        ViewHolder viewHolder = (ViewHolder) itemLayout.getTag();

        if (viewHolder == null) {
            // find a widget
            viewHolder = new ViewHolder();
//            viewHolder.mIcon = (ImageView) itemLayout.findViewById(R.id.iconItem);
            viewHolder.mText01 = (TextView) itemLayout.findViewById(R.id.dataItem01);
            viewHolder.mText02 = (TextView) itemLayout.findViewById(R.id.dataItem02);
            viewHolder.mText03 = (TextView) itemLayout.findViewById(R.id.dataItem03);
            viewHolder.mText04 = (TextView) itemLayout.findViewById(R.id.dataItem04);
            viewHolder.menutype = (TextView) itemLayout.findViewById(R.id.menutype);
            viewHolder.detail1 = (TextView) itemLayout.findViewById(R.id.detai1);
            viewHolder.detail2 = (TextView) itemLayout.findViewById(R.id.detai2);
            //viewHolder.mText03 = (TextView )itemLayout.findViewById(R.id.dataItem03);

            itemLayout.setTag(viewHolder);
        }

//        viewHolder.mIcon.setImageDrawable(this.getItem(position).getIconItem());
        viewHolder.menutype.setText(this.getItem(position).getMenutype());
        viewHolder.mText01.setText(this.getItem(position).getDataItem01());
        viewHolder.mText02.setText(this.getItem(position).getDataItem02());
        viewHolder.mText03.setText(this.getItem(position).getDataItem03());
        viewHolder.mText04.setText(this.getItem(position).getDataItem04());
        viewHolder.detail1.setText(this.getItem(position).getDetail1());
        viewHolder.detail2.setText(this.getItem(position).getDetail2());

        return itemLayout;
    }

    /**
     * @return
     */
    public void setInitData(int start, int end) {

        List<ModelItem> list = makeData(start, end);
        this.addAll(list);
    }

    public List<ModelItem> makeData(int start, int end) {

        if (end > 9) end = 9;

        List<ModelItem> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {

            ModelItem item = new ModelItem();
//            item.setIconItem(context.getResources().getDrawable(getDrawableImage(i)));
            item.setMenutype("라떼");
            item.setDataItem01("아메리카노");//+ String.format("%3d", i)
//            item.setDataItem02(getRandString());
            item.setDataItem02("1900 원");
            item.setDataItem03("라떼");// + String.format("%3d", i)
            item.setDataItem04("2900 원");
            item.setDetail1("개맛");
            item.setDetail2("존맛");
            list.add(item);
        }

        return list;
    }

//    private int getDrawableImage(int count) {
//        switch (count % 6) {
//            case 0:
//                return R.drawable.iceamericano;
//            case 1:
//                return R.drawable.capuchino;
//            case 2:
//                return R.drawable.frappuccino;
//            case 3:
//                return R.drawable.espresso;
//            case 4:
//                return R.drawable.nogcharalatte;
//            case 5:
//                return R.drawable.icetea;
//            default:
//                return -1;
//        }
//    }


    private String getRandString() {
        String str = "";

        for (int i = 1; i <= (int) (Math.random() * 10000); i++) {
            //char ch = (char) ((Math.random() * 11172) + 0xAC00);
            str += String.valueOf((char) ((Math.random() * 26) + 97));
        }

        return str;
    }


    public void add(int index, ModelItem data) {

        this.add(data);
        notifyDataSetChanged();
    }


    public void delete(int index) {

        this.delete(index);
        notifyDataSetChanged();

    }

    public void clear() {

        this.clear();
        notifyDataSetChanged();

    }
}


