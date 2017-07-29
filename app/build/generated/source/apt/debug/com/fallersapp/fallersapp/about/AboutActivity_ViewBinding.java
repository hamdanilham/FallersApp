// Generated code from Butter Knife. Do not modify!
package com.fallersapp.fallersapp.about;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fallersapp.fallersapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AboutActivity_ViewBinding implements Unbinder {
  private AboutActivity target;

  @UiThread
  public AboutActivity_ViewBinding(AboutActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AboutActivity_ViewBinding(AboutActivity target, View source) {
    this.target = target;

    target.textViewTerm = Utils.findRequiredViewAsType(source, R.id.term, "field 'textViewTerm'", TextView.class);
    target.textViewPrivacy = Utils.findRequiredViewAsType(source, R.id.privacy, "field 'textViewPrivacy'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AboutActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewTerm = null;
    target.textViewPrivacy = null;
  }
}
