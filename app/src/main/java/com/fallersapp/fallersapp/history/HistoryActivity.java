package com.fallersapp.fallersapp.history;

import android.os.Bundle;

import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by hamda on 26/07/2017.
 */

public class HistoryActivity extends BaseActivity {
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        setToolbar(true);
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
