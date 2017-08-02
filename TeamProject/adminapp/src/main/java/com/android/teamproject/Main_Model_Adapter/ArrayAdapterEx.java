package com.android.teamproject.Main_Model_Adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.teamproject.R;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterEx extends android.widget.ArrayAdapter<ModelCafe> {

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<ModelCafe> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    class ViewHolder{
        TextView cafe_name;
        RatingBar star;
        TextView review_count;
        TextView star_count;
        // ImageView brandimage;

    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemLayout = super.getView(position, convertView, parent);
        ViewHolder viewHolder = (ViewHolder) itemLayout.getTag();

        if(viewHolder == null){
            viewHolder = new ViewHolder();
            // viewHolder.brandimage= (ImageView) itemLayout.findViewById(R.id.brandimage);
            viewHolder.star= (RatingBar) itemLayout.findViewById(R.id.star);
            viewHolder.cafe_name= (TextView) itemLayout.findViewById(R.id.cafe_name);
            viewHolder.review_count= (TextView) itemLayout.findViewById(R.id.review_count);
            viewHolder.star_count= (TextView) itemLayout.findViewById(R.id.star_count);
            itemLayout.setTag(viewHolder);
        }
        // viewHolder.brandimage.setImageResource(getItem(position).getBrand_image());
        viewHolder.star.setRating(getItem(position).getStar());
        viewHolder.cafe_name.setText(getItem(position).getCafe_name());
        viewHolder.review_count.setText("리뷰"+getItem(position).getReview_count()+"개".toString() );
        viewHolder.star_count.setText("즐겨찾기"+getItem(position).getStar_count()+"명".toString()  );

        return itemLayout;
    }
}
