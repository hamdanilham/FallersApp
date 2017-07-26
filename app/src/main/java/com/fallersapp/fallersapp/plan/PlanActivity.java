package com.fallersapp.fallersapp.plan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.base.BaseActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hamda on 11/07/2017.
 */

public class PlanActivity extends BaseActivity{

    @BindView(R.id.btn_add_plan)
    Button buttonAddPlan;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_plan);
        ButterKnife.bind(this);
        setToolbar(true);

        buttonAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanActivity.this, AddPlanActivity.class);
                startActivity(intent);
//                FirebaseAuth.getInstance().signOut();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.finish();
    }

    @Override
    protected int getToolbarTitle(){
        return R.string.title_plan;
    }
}
