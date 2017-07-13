package com.fallersapp.fallersapp.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fallersapp.fallersapp.R;

import butterknife.BindView;

/**
 * Created by hamda on 11/07/2017.
 */

class MainAdapter extends android.support.v7.widget.RecyclerView.Adapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_home, parent, false);
        return new HomeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HomeViewHolder  viewHolder = (HomeViewHolder) holder;

        viewHolder.tv_title.setText("Home");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_title)
        TextView tv_title;

        public HomeViewHolder(View itemView) {
            super(itemView);
        }
    }
}
