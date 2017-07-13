package com.fallersapp.fallersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fallersapp.fallersapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        setToolbar(true);

//        textToolbarTitle.setText("Register");

    }

    @Override
    public void onBackPressed() {
        super.finish();
    }

    @Override
    protected int getToolbarTitle(){
        return R.string.title_signup;
    }
}
