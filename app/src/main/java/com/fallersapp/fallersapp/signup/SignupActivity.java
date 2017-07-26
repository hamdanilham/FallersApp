package com.fallersapp.fallersapp.signup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.base.BaseActivity;
import com.fallersapp.fallersapp.home.MainActivity;
import com.fallersapp.fallersapp.login.LoginActivity;
import com.fallersapp.fallersapp.plan.PlanActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends BaseActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    public void onBackPressed() {
        super.finish();
    }

    @BindView(R.id.btn_signup_btn)
    Button buttonSignup;
    @BindView(R.id.et_email_signup)
    EditText EditTextEmailSignup;
    @BindView(R.id.et_password_signup)
    EditText EditTextPasswordSignup;
    @BindView(R.id.et_username_signup)
    EditText EditTextUsernameSignup;
    @BindView(R.id.et_repassword_signup)
    EditText EditTextRepasswordSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        setToolbar(true);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                }
            }
        };

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, PlanActivity.class);
                startActivity(intent);
                signUp();
            }
        });

//        textToolbarTitle.setText("Register");

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    protected void signUp() {
        String email = EditTextEmailSignup.getText().toString();
        String username = EditTextUsernameSignup.getText().toString();
        String password= EditTextPasswordSignup.getText().toString();
        String repassword = EditTextRepasswordSignup.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(username) || TextUtils.isEmpty(repassword)) {
            Toast.makeText(SignupActivity.this, "Fields is Empty.", Toast.LENGTH_LONG).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(SignupActivity.this, "Sign In Problem", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    @Override
    protected int getToolbarTitle(){
        return R.string.title_signup;
    }
}
