// Generated code from Butter Knife. Do not modify!
package com.fallersapp.fallersapp.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fallersapp.fallersapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainAdapter$HomeViewHolder_ViewBinding implements Unbinder {
  private MainAdapter.HomeViewHolder target;

  @UiThread
  public MainAdapter$HomeViewHolder_ViewBinding(MainAdapter.HomeViewHolder target, View source) {
    this.target = target;

    target.tv_title = Utils.findRequiredViewAsType(source, R.id.text_title, "field 'tv_title'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainAdapter.HomeViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_title = null;
  }
}
