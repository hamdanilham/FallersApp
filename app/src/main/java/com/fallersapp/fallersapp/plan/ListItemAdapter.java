package com.fallersapp.fallersapp.plan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.base.BaseRecycleviewAdapter;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hamda on 28/07/2017.
 */

public class ListItemAdapter extends BaseRecycleviewAdapter<ListItem> {

    AddPlanActivity addPlanActivity;

    OnClickInAdapter onClickInAdapter;

    public ListItemAdapter(Context context, List data) {
        super (context, data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_barang, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;

        ListItem itemBarang = mListData.get(position);
        viewHolder.barang.setText(itemBarang.getBarang());
        viewHolder.hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickInAdapter = (OnClickInAdapter) mContext;
                onClickInAdapter.onClickInAdapter(position);
            }
        });
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.barang)
        TextView barang;

        @BindView(R.id.hapus)
        ImageView hapus;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnClickInAdapter {
        public void onClickInAdapter(int content);
    }
}
