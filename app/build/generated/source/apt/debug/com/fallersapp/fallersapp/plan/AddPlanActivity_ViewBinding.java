// Generated code from Butter Knife. Do not modify!
package com.fallersapp.fallersapp.plan;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fallersapp.fallersapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddPlanActivity_ViewBinding implements Unbinder {
  private AddPlanActivity target;

  @UiThread
  public AddPlanActivity_ViewBinding(AddPlanActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddPlanActivity_ViewBinding(AddPlanActivity target, View source) {
    this.target = target;

    target.buttonAdd = Utils.findRequiredViewAsType(source, R.id.btn_add, "field 'buttonAdd'", Button.class);
    target.textLocation = Utils.findRequiredViewAsType(source, R.id.et_location, "field 'textLocation'", EditText.class);
    target.recyclerViewPlan = Utils.findRequiredViewAsType(source, R.id.rv_list_plan, "field 'recyclerViewPlan'", RecyclerView.class);
    target.editTextListItem = Utils.findRequiredViewAsType(source, R.id.et_list_item, "field 'editTextListItem'", EditText.class);
    target.editTextDepTime = Utils.findRequiredViewAsType(source, R.id.et_dep_time, "field 'editTextDepTime'", EditText.class);
    target.editTextArrTime = Utils.findRequiredViewAsType(source, R.id.et_arr_time, "field 'editTextArrTime'", EditText.class);
    target.imageViewEnter = Utils.findRequiredViewAsType(source, R.id.enter, "field 'imageViewEnter'", ImageView.class);
    target.spinnerFamily = Utils.findRequiredViewAsType(source, R.id.spinner_family, "field 'spinnerFamily'", Spinner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddPlanActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.buttonAdd = null;
    target.textLocation = null;
    target.recyclerViewPlan = null;
    target.editTextListItem = null;
    target.editTextDepTime = null;
    target.editTextArrTime = null;
    target.imageViewEnter = null;
    target.spinnerFamily = null;
  }
}
