package com.cafe.userapp;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-04.
 */

public class ArrayAdapterEx extends ArrayAdapter<write> {

    ArrayList<write> mData = null;

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @NonNull write[] objects) {
        super(context, resource, objects);
    }

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull write[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @NonNull List<write> objects) {
        super(context, resource, objects);
    }

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<write> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    private class ViewHolder {
        TextView reviewTv;
        RatingBar ratingTv;
        TextView dayTv;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemLayout = super.getView(position, convertView, parent);
        ViewHolder viewHolder = (ViewHolder) itemLayout.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            viewHolder.reviewTv = (TextView) itemLayout.findViewById(R.id.write);
            viewHolder.ratingTv = (RatingBar) itemLayout.findViewById(R.id.starTv);
            viewHolder.dayTv = (TextView) itemLayout.findViewById(R.id.dayTv);
            itemLayout.setTag(viewHolder);
        }
        viewHolder.reviewTv.setText(getItem(position).getReview());
        viewHolder.ratingTv.setRating(getItem(position).getStar());
        viewHolder.dayTv.setText((CharSequence) getItem(position).getDay());


        return itemLayout;
    }
}