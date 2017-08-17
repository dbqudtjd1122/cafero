package com.cafe.adminapp.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cafe.common.Model.ModelCafeinfo;
import com.cafe.adminapp.R;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterEx extends android.widget.ArrayAdapter<ModelCafeinfo> {

    public ArrayList<ModelCafeinfo> Data = null;

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<ModelCafeinfo> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    class ViewHolder {
        TextView cafename;
        RatingBar avg_grade;
        TextView review_count;
        TextView like_count;
        ImageView brandImg;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemLayout = super.getView(position, convertView, parent);
        ViewHolder viewHolder = (ViewHolder) itemLayout.getTag();

        ModelCafeinfo cafeinfo = getItem(position);

        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            viewHolder.brandImg = (ImageView) itemLayout.findViewById(R.id.brandimage);
            viewHolder.avg_grade = (RatingBar) itemLayout.findViewById(R.id.star);
            viewHolder.cafename = (TextView) itemLayout.findViewById(R.id.cafe_name);
            viewHolder.review_count = (TextView) itemLayout.findViewById(R.id.review_count);
            viewHolder.like_count = (TextView) itemLayout.findViewById(R.id.star_count);
            
            itemLayout.setTag(viewHolder);
        }
        if (cafeinfo.getBrand().equals("이디야")) {
            viewHolder.brandImg.setImageResource(R.drawable.ediya);
        } else if (cafeinfo.getBrand().equals("스타벅스")) {
            viewHolder.brandImg.setImageResource(R.drawable.starbucks);
        } else if (cafeinfo.getBrand().equals("할리스")) {
            viewHolder.brandImg.setImageResource(R.drawable.hallis);
        }
        viewHolder.avg_grade.setRating(getItem(position).getAvg_grade());
        viewHolder.cafename.setText(getItem(position).getCafename());
        viewHolder.review_count.setText("리뷰" + getItem(position).getReview_count() + "개".toString());
        viewHolder.like_count.setText("즐겨찾기" + getItem(position).getLike_count() + "명".toString());

        return itemLayout;
        }
}
