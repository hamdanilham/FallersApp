package com.fallersapp.fallersapp.history;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.base.BaseRecycleviewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ziterz on 7/29/2017.
 */

public class ListHistoryAdapter extends BaseRecycleviewAdapter<ListHistory>{
    public ListHistoryAdapter(Context context, List data) {
        super (context, data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_history, parent, false);
        return new ListHistoryAdapter.ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListHistoryAdapter.ItemViewHolder viewHolder = (ListHistoryAdapter.ItemViewHolder) holder;

        ListHistory listHistory = mListData.get(position);
        viewHolder.judul.setText(listHistory.getJudul());
        viewHolder.waktu.setText(listHistory.getWaktu());
        viewHolder.tujuan.setText(listHistory.getTujuan());

        viewHolder.linearLayoutHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, DetailHistoryActivity.class));
            }
        });
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.judul)
        TextView judul;

        @BindView(R.id.waktu)
        TextView waktu;

        @BindView(R.id.tujuan)
        TextView tujuan;

        @BindView(R.id.linearHistory)
        LinearLayout linearLayoutHistory;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
