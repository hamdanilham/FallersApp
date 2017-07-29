// Generated code from Butter Knife. Do not modify!
package com.fallersapp.fallersapp.history;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fallersapp.fallersapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListHistoryAdapter$ItemViewHolder_ViewBinding implements Unbinder {
  private ListHistoryAdapter.ItemViewHolder target;

  @UiThread
  public ListHistoryAdapter$ItemViewHolder_ViewBinding(ListHistoryAdapter.ItemViewHolder target,
      View source) {
    this.target = target;

    target.judul = Utils.findRequiredViewAsType(source, R.id.judul, "field 'judul'", TextView.class);
    target.waktu = Utils.findRequiredViewAsType(source, R.id.waktu, "field 'waktu'", TextView.class);
    target.tujuan = Utils.findRequiredViewAsType(source, R.id.tujuan, "field 'tujuan'", TextView.class);
    target.linearLayoutHistory = Utils.findRequiredViewAsType(source, R.id.linearHistory, "field 'linearLayoutHistory'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListHistoryAdapter.ItemViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.judul = null;
    target.waktu = null;
    target.tujuan = null;
    target.linearLayoutHistory = null;
  }
}
