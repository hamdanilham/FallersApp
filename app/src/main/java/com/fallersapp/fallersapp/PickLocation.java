package com.fallersapp.fallersapp;

import android.os.Bundle;

import com.fallersapp.fallersapp.base.BaseActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

import butterknife.ButterKnife;

/**
 * Created by hamda on 17/07/2017.
 */

public class PickLocation extends BaseActivity {
    MapView mapView;
    GoogleMap map;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_pick_location);
        ButterKnife.bind(this);
        setToolbar(true);
    }

    @Override
    public void onBackPressed() {
        super.finish();
    }

    @Override
    protected int getToolbarTitle(){
        return R.string.title_pick_loc;
    }
}
