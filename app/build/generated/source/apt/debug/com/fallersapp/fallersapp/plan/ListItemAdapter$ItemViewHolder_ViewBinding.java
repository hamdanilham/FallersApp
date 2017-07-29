// Generated code from Butter Knife. Do not modify!
package com.fallersapp.fallersapp.plan;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fallersapp.fallersapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListItemAdapter$ItemViewHolder_ViewBinding implements Unbinder {
  private ListItemAdapter.ItemViewHolder target;

  @UiThread
  public ListItemAdapter$ItemViewHolder_ViewBinding(ListItemAdapter.ItemViewHolder target,
      View source) {
    this.target = target;

    target.barang = Utils.findRequiredViewAsType(source, R.id.barang, "field 'barang'", TextView.class);
    target.hapus = Utils.findRequiredViewAsType(source, R.id.hapus, "field 'hapus'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListItemAdapter.ItemViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.barang = null;
    target.hapus = null;
  }
}
