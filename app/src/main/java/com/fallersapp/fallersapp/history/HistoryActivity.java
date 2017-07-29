package com.fallersapp.fallersapp.history;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.base.BaseActivity;
import com.fallersapp.fallersapp.plan.ListItem;
import com.fallersapp.fallersapp.plan.ListItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hamda on 26/07/2017.
 */

public class HistoryActivity extends BaseActivity {
    @BindView(R.id.rv_list_history)
    RecyclerView recyclerViewHistory;

    List<ListHistory> listHistoryList = new ArrayList<>();
    List<ListHistory> listItemHistory;
    ListHistoryAdapter listHistoryAdapter;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        setToolbar(true);

        //recycle view
        listHistoryAdapter = new ListHistoryAdapter(this, listHistoryList);
        recyclerViewHistory.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewHistory.setAdapter(listHistoryAdapter);

        listItemHistory = new ArrayList<>();
        listItemHistory.add(new ListHistory("Main", "Bandung", "09-08-2017"));
        listItemHistory.add(new ListHistory("Main", "Bandung", "09-08-2017"));

        listHistoryList.addAll(listItemHistory);
        listHistoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.finish();
    }

    @Override
    protected int getToolbarTitle(){
        return R.string.title_history;
    }
}
