// Generated code from Butter Knife. Do not modify!
package com.droideve.apps.sugoi.booking.views.activities;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.droideve.apps.sugoi.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ServiceOptionsActivity_ViewBinding implements Unbinder {
  private ServiceOptionsActivity target;

  @UiThread
  public ServiceOptionsActivity_ViewBinding(ServiceOptionsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ServiceOptionsActivity_ViewBinding(ServiceOptionsActivity target, View source) {
    this.target = target;

    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbarDescription = Utils.findRequiredViewAsType(source, R.id.toolbar_subtitle, "field 'toolbarDescription'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ServiceOptionsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbarTitle = null;
    target.toolbarDescription = null;
  }
}
