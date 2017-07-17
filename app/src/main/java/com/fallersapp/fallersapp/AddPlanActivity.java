package com.fallersapp.fallersapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fallersapp.fallersapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hamda on 13/07/2017.
 */

public class AddPlanActivity extends BaseActivity{

    @BindView(R.id.btn_add)
    Button buttonAdd;

    @BindView(R.id.et_location)
    EditText textLocation;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_add_plan);
        ButterKnife.bind(this);
        setToolbar(true);

        textLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddPlanActivity.this, PickLocation.class);
                startActivity(intent);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddPlanActivity.this, PickLocation.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.finish();
    }

    @Override
    protected int getToolbarTitle(){
        return R.string.title_add_plan;
    }

}
