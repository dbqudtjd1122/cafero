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

    public ArrayList<ModelCafe> mData = null;

    public ArrayAdapterEx(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<ModelCafe> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public void delete(Integer index){
        mData.remove(index);
        notifyDataSetChanged();
    }
    public  void clear(){
        mData.clear();
        notifyDataSetChanged();
    }

    class ViewHolder{
        ImageView brandimage;
        RatingBar star;
        TextView brandname;
        TextView review_count;
        TextView star_count;

    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemLayout = super.getView(position, convertView, parent);
        ViewHolder viewHolder = (ViewHolder) itemLayout.getTag();

        if(viewHolder == null){
            viewHolder = new ViewHolder();
            viewHolder.brandimage= (ImageView) itemLayout.findViewById(R.id.brandimage);
            viewHolder.star= (RatingBar) itemLayout.findViewById(R.id.star);
            viewHolder.brandname= (TextView) itemLayout.findViewById(R.id.brandname);
            viewHolder.review_count= (TextView) itemLayout.findViewById(R.id.reviewcount);
            viewHolder.star_count= (TextView) itemLayout.findViewById(R.id.starcount);
            itemLayout.setTag(viewHolder);
        }
        // viewHolder.brandimage.setImageResource(getItem(position).getBrand_image());
        viewHolder.star.setRating(getItem(position).getStar());
        viewHolder.brandname.setText(getItem(position).getBrand());
        viewHolder.review_count.setText(getItem(position).getReview_count());
        viewHolder.star_count.setText(getItem(position).getStar_count());

        return itemLayout;
    }
}
