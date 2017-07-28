package com.fallersapp.fallersapp.about;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hamda on 26/07/2017.
 */

public class AboutActivity extends BaseActivity {

    @BindView(R.id.term)
    TextView textViewTerm;

    @BindView(R.id.privacy)
    TextView textViewPrivacy;

    Intent intent;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        setToolbar(true);

        textViewTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), TosActivity.class);
                startActivity(intent);
            }
        });

        textViewPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), PrivacyActivity.class);
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
        return R.string.title_about;
    }
}
