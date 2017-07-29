// Generated code from Butter Knife. Do not modify!
package com.fallersapp.fallersapp.plan;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fallersapp.fallersapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PickLocation_ViewBinding implements Unbinder {
  private PickLocation target;

  @UiThread
  public PickLocation_ViewBinding(PickLocation target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PickLocation_ViewBinding(PickLocation target, View source) {
    this.target = target;

    target.place_att = Utils.findRequiredViewAsType(source, R.id.place_attribution, "field 'place_att'", TextView.class);
    target.place_details = Utils.findRequiredViewAsType(source, R.id.place_details, "field 'place_details'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PickLocation target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.place_att = null;
    target.place_details = null;
  }
}
