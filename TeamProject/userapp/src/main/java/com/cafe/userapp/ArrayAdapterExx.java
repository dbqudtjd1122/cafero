package com.cafe.userapp;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-02.
 */

public class ArrayAdapterEx extends ArrayAdapter<wirte> {

    ArrayList<wirte> mData = null;

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @NonNull wirte[] objects) {
        super(context, resource, objects);
    }

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull wirte[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @NonNull List<wirte> objects) {
        super(context, resource, objects);
    }

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<wirte> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    private class ViewHolder {
        TextView reviewTv;
        TextView ratingTv;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemLayout = super.getView(position, convertView, parent);
        ViewHolder viewHolder = (ViewHolder) itemLayout.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            viewHolder.reviewTv = (TextView) itemLayout.findViewById(R.id.write);
            viewHolder.ratingTv = (TextView) itemLayout.findViewById(R.id.starTv);
            itemLayout.setTag(viewHolder);
        }
        viewHolder.reviewTv.setText(getItem(position).getReview());
        viewHolder.ratingTv.setText(getItem(position).getStar());

        return itemLayout;
    }
}
