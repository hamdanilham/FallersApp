package com.fallersapp.fallersapp.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.base.BaseActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.ButterKnife;

/**
 * Created by hamda on 26/07/2017.
 */

public class ProfileActivity extends BaseActivity {
    TextView id = (TextView) findViewById(R.id.textView3);
    Button mButtonAddFamily = (Button) findViewById(R.id.btn_add_family);
    EditText mEtIdFamily = (EditText) findViewById(R.id.editText2);
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    String idFamily;
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_detail_profile);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        setToolbar(true);
        id.setText(mAuth.getCurrentUser().getUid().substring(0, 6));

        mButtonAddFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idFamily = mEtIdFamily.getText().toString();
                addFamily(idFamily);
            }
        });
    }

    protected void addFamily(String idFamily) {

    }

    @Override
    public void onBackPressed() {
        super.finish();
    }

    @Override
    protected int getToolbarTitle(){
        return R.string.title_profile;
    }
}
