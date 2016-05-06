package com.sh.demorecycleview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;

import com.sh.demorecycleview.R;
import com.sh.demorecycleview.models.AndroidVersion;

/**
 * Created by SonH on 2016-05-05.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements ItemTouchHelperAdapter {
    private ArrayList<AndroidVersion> mAndroid;
    private Context mContext;

    public DataAdapter(ArrayList<AndroidVersion> mAndroid, Context mContext) {
        this.mAndroid = mAndroid;
        this.mContext = mContext;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_android.setText(mAndroid.get(position).getAndroid_version_name());
        Picasso.with(mContext).load(mAndroid.get(position).getAndroid_img_url()).resize(200, 100).into(holder.imv_android);
    }

    @Override
    public int getItemCount() {
        return mAndroid.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mAndroid, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mAndroid, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public boolean onItemDismiss(int position) {
        mAndroid.remove(position);
        notifyItemRemoved(position);
        return true;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_android;
        private ImageView imv_android;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_android = (TextView) itemView.findViewById(R.id.tv_android);
            imv_android = (ImageView) itemView.findViewById(R.id.img_android);
        }
    }
}
