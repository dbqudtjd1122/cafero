package com.android.teamproject.Adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.teamproject.Model.ModelCafeinfo;
import com.android.teamproject.R;

import java.util.List;

public class ArrayAdapterEx extends android.widget.ArrayAdapter<ModelCafeinfo> {

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<ModelCafeinfo> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    class ViewHolder{
        TextView cafename;
        RatingBar avg_grade;
        TextView review_count;
        TextView like_count;
        // ImageView brandimage;

    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemLayout = super.getView(position, convertView, parent);
        ViewHolder viewHolder = (ViewHolder) itemLayout.getTag();

        if(viewHolder == null){
            viewHolder = new ViewHolder();
            // viewHolder.brandimage= (ImageView) itemLayout.findViewById(R.id.brandimage);
            viewHolder.avg_grade= (RatingBar) itemLayout.findViewById(R.id.star);
            viewHolder.cafename= (TextView) itemLayout.findViewById(R.id.cafe_name);
            viewHolder.review_count= (TextView) itemLayout.findViewById(R.id.review_count);
            viewHolder.like_count= (TextView) itemLayout.findViewById(R.id.star_count);
            itemLayout.setTag(viewHolder);
        }
        // viewHolder.brandimage.setImageResource(getItem(position).getBrand_image());
        viewHolder.avg_grade.setRating(getItem(position).getAvg_grade());
        viewHolder.cafename.setText(getItem(position).getCafename());
        viewHolder.review_count.setText("리뷰"+getItem(position).getReview_count()+"개".toString() );
        viewHolder.like_count.setText("즐겨찾기"+getItem(position).getLike_count()+"명".toString()  );


        return itemLayout;
    }
}
