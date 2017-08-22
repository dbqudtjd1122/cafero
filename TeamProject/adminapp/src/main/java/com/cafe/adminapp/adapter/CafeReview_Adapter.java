package com.cafe.adminapp.adapter;


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

import com.cafe.adminapp.R;
import com.cafe.common.CommonActvity;
import com.cafe.common.Model.ModelCafeReview;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CafeReview_Adapter extends ArrayAdapter<ModelCafeReview>{


    public CafeReview_Adapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<ModelCafeReview> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    class ViewHolder {
        TextView tv_nickname;
        TextView tv_datetime;
        RatingBar rb_review;
        TextView tv_review;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemLayout = super.getView(position, convertView, parent);
        ViewHolder viewHolder = (ViewHolder) itemLayout.getTag();

        ModelCafeReview cafeReview = getItem(position);

        if(viewHolder == null){
            viewHolder = new ViewHolder();
            viewHolder.tv_nickname = (TextView) itemLayout.findViewById(R.id.tv_nickname);
            viewHolder.tv_datetime = (TextView) itemLayout.findViewById(R.id.tv_datetime);
            viewHolder.rb_review = (RatingBar) itemLayout.findViewById(R.id.rb_review);
            viewHolder.tv_review = (TextView) itemLayout.findViewById(R.id.tv_review);

            itemLayout.setTag(viewHolder);
        }

        viewHolder.tv_nickname.setText(getItem(position).getUsernickname().toString());


        SimpleDateFormat data= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // E 요일 HH 시간 mm 분 ss 초
        String datetime = data.format(getItem(position).getRegdate().getTime());
        viewHolder.tv_datetime.setText(datetime);

        String avg = String.format("%.1f", getItem(position).getGrade());
        float avg2 = Float.parseFloat(avg);
        viewHolder.rb_review.setRating(avg2);
        viewHolder.tv_review.setText(getItem(position).getContent());

        return itemLayout;
    }
}
