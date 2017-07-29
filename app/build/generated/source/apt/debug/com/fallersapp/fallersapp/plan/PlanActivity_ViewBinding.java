// Generated code from Butter Knife. Do not modify!
package com.fallersapp.fallersapp.plan;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fallersapp.fallersapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlanActivity_ViewBinding implements Unbinder {
  private PlanActivity target;

  @UiThread
  public PlanActivity_ViewBinding(PlanActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PlanActivity_ViewBinding(PlanActivity target, View source) {
    this.target = target;

    target.buttonAddPlan = Utils.findRequiredViewAsType(source, R.id.btn_add_plan, "field 'buttonAddPlan'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlanActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.buttonAddPlan = null;
  }
}
