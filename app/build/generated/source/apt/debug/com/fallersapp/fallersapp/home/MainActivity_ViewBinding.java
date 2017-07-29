// Generated code from Butter Knife. Do not modify!
package com.fallersapp.fallersapp.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.GridView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.fallersapp.fallersapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.sliderLayout = Utils.findRequiredViewAsType(source, R.id.slider, "field 'sliderLayout'", SliderLayout.class);
    target.pagerIndicator = Utils.findRequiredViewAsType(source, R.id.custom_indicator, "field 'pagerIndicator'", PagerIndicator.class);
    target.gridMenu = Utils.findRequiredViewAsType(source, R.id.gridMenu, "field 'gridMenu'", GridView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.sliderLayout = null;
    target.pagerIndicator = null;
    target.gridMenu = null;
  }
}
