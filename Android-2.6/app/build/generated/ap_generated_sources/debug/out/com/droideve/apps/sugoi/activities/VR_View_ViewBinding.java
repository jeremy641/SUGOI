// Generated code from Butter Knife. Do not modify!
package com.droideve.apps.sugoi.activities;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.droideve.apps.sugoi.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VR_View_ViewBinding implements Unbinder {
  private VR_View target;

  @UiThread
  public VR_View_ViewBinding(VR_View target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public VR_View_ViewBinding(VR_View target, View source) {
    this.target = target;

    target.APP_TITLE_VIEW = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'APP_TITLE_VIEW'", TextView.class);
    target.APP_DESC_VIEW = Utils.findRequiredViewAsType(source, R.id.toolbar_subtitle, "field 'APP_DESC_VIEW'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.app_bar, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VR_View target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.APP_TITLE_VIEW = null;
    target.APP_DESC_VIEW = null;
    target.toolbar = null;
  }
}
