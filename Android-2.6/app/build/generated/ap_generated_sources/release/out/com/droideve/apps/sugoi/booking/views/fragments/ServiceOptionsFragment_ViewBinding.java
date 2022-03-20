// Generated code from Butter Knife. Do not modify!
package com.droideve.apps.sugoi.booking.views.fragments;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.droideve.apps.sugoi.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ServiceOptionsFragment_ViewBinding implements Unbinder {
  private ServiceOptionsFragment target;

  private View view7f0a0179;

  @UiThread
  public ServiceOptionsFragment_ViewBinding(final ServiceOptionsFragment target, View source) {
    this.target = target;

    View view;
    target.frame_content = Utils.findRequiredViewAsType(source, R.id.frame_content, "field 'frame_content'", LinearLayout.class);
    target.layout_custom_order = Utils.findRequiredViewAsType(source, R.id.layout_custom_order, "field 'layout_custom_order'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_custom_order, "field 'btnCustomOrder' and method 'submit'");
    target.btnCustomOrder = Utils.castView(view, R.id.btn_custom_order, "field 'btnCustomOrder'", AppCompatButton.class);
    view7f0a0179 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit(p0);
      }
    });
    target.product_value = Utils.findRequiredViewAsType(source, R.id.product_value, "field 'product_value'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ServiceOptionsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.frame_content = null;
    target.layout_custom_order = null;
    target.btnCustomOrder = null;
    target.product_value = null;

    view7f0a0179.setOnClickListener(null);
    view7f0a0179 = null;
  }
}
