package com.fallersapp.fallersapp.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hamda on 28/07/2017.
 */

public class BaseRecycleviewAdapter<T> extends RecyclerView.Adapter{
    protected Context mContext;
    protected List<T> mListData;

    public BaseRecycleviewAdapter(Context context, List<T> listData) {
        this.mListData = listData;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return (null != mListData ? mListData.size() : 0);
    }
}
