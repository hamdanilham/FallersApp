package com.fallersapp.fallersapp.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.fallersapp.fallersapp.R;

import butterknife.ButterKnife;

/**
 * Created by hamda on 13/07/2017.
 */

public class BaseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setToolbar() {
        setToolbar(false);
    }

    protected void setToolbar(Boolean isHaveArrow){
        Toolbar toolbar = ButterKnife.findById(this, getToolbarId());
        TextView textToolbarTitle = ButterKnife.findById(this, R.id.text_toolbar_title);

        setSupportActionBar(toolbar);
        textToolbarTitle.setText(getToolbarTitle());
        setTitle("");

        if(isHaveArrow){
            toolbar.setNavigationIcon(R.drawable.ic_chevron_left);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
    }

    protected
    @IdRes
    int getToolbarId() {
        return R.id.widget_toolbar;
    }

    protected
    @StringRes
    int getToolbarTitle() {
        return R.string.app_name;
    }
}
