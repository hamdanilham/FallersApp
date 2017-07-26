package com.fallersapp.fallersapp.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fallersapp.fallersapp.R;
import com.fallersapp.fallersapp.home.MainActivity;
import com.fallersapp.fallersapp.plan.PlanActivity;
import com.fallersapp.fallersapp.signup.SignupActivity;
//import com.fallersapp.fallersapp.home.MainActivity;
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.text_sign_up)
    TextView mTextSignup;
    @BindView(R.id.btn_login)
    Button mButtonLogin;
    @BindView(R.id.et_email_login)
    EditText mEmailSignIn;
    @BindView(R.id.et_password_login)
    EditText mPasswordSignIn;
//    @BindView(R.id.google_sign_in)
//    Button buttonGoogleSignIn;
//
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

//    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
//
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("adaw");
//        myRef.setValue("helloworld");
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        };

        mTextSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),SignupActivity.class);
                startActivity(intent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
//                startSignIn();
            }
        });

//        buttonGoogleSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                googleSign();
//            }
//        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startSignIn() {
        String email = mEmailSignIn.getText().toString();
        String password = mPasswordSignIn.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(LoginActivity.this, "Fields is Empty", Toast.LENGTH_LONG).show();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Sign In Problem", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }


}
