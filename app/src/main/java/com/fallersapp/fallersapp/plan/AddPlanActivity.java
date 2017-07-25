package com.fallersapp.fallersapp.plan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fallersapp.fallersapp.plan.PickLocation;
import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.base.BaseActivity;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

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

    @BindView(R.id.rv_list_plan)
    RecyclerView recyclerViewPlan;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_add_plan);
        ButterKnife.bind(this);
        setToolbar(true);

        //recycle view
        recyclerViewPlan.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerViewPlan.setLayoutManager(mLinearLayoutManager);

        mAdapter = new PlanAdapter();
        recyclerViewPlan.setAdapter(mAdapter);

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
