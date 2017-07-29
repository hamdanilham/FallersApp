// Generated code from Butter Knife. Do not modify!
package com.fallersapp.fallersapp.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fallersapp.fallersapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target, View source) {
    this.target = target;

    target.mTextSignup = Utils.findRequiredViewAsType(source, R.id.text_sign_up, "field 'mTextSignup'", TextView.class);
    target.mButtonLogin = Utils.findRequiredViewAsType(source, R.id.btn_login, "field 'mButtonLogin'", Button.class);
    target.mEmailSignIn = Utils.findRequiredViewAsType(source, R.id.et_email_login, "field 'mEmailSignIn'", EditText.class);
    target.mPasswordSignIn = Utils.findRequiredViewAsType(source, R.id.et_password_login, "field 'mPasswordSignIn'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextSignup = null;
    target.mButtonLogin = null;
    target.mEmailSignIn = null;
    target.mPasswordSignIn = null;
  }
}
