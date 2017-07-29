// Generated code from Butter Knife. Do not modify!
package com.fallersapp.fallersapp.history;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fallersapp.fallersapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HistoryActivity_ViewBinding implements Unbinder {
  private HistoryActivity target;

  @UiThread
  public HistoryActivity_ViewBinding(HistoryActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HistoryActivity_ViewBinding(HistoryActivity target, View source) {
    this.target = target;

    target.recyclerViewHistory = Utils.findRequiredViewAsType(source, R.id.rv_list_history, "field 'recyclerViewHistory'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HistoryActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerViewHistory = null;
  }
}
