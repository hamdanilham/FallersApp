// Generated code from Butter Knife. Do not modify!
package com.fallersapp.fallersapp.signup;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fallersapp.fallersapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignupActivity_ViewBinding implements Unbinder {
  private SignupActivity target;

  @UiThread
  public SignupActivity_ViewBinding(SignupActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SignupActivity_ViewBinding(SignupActivity target, View source) {
    this.target = target;

    target.buttonSignup = Utils.findRequiredViewAsType(source, R.id.btn_signup_btn, "field 'buttonSignup'", Button.class);
    target.EditTextEmailSignup = Utils.findRequiredViewAsType(source, R.id.et_email_signup, "field 'EditTextEmailSignup'", EditText.class);
    target.EditTextPasswordSignup = Utils.findRequiredViewAsType(source, R.id.et_password_signup, "field 'EditTextPasswordSignup'", EditText.class);
    target.EditTextUsernameSignup = Utils.findRequiredViewAsType(source, R.id.et_username_signup, "field 'EditTextUsernameSignup'", EditText.class);
    target.EditTextRepasswordSignup = Utils.findRequiredViewAsType(source, R.id.et_repassword_signup, "field 'EditTextRepasswordSignup'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignupActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.buttonSignup = null;
    target.EditTextEmailSignup = null;
    target.EditTextPasswordSignup = null;
    target.EditTextUsernameSignup = null;
    target.EditTextRepasswordSignup = null;
  }
}
