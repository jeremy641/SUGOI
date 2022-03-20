// Generated code from Butter Knife. Do not modify!
package com.droideve.apps.sugoi.booking.views.activities;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.droideve.apps.sugoi.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BookingDetailActivity_ViewBinding implements Unbinder {
  private BookingDetailActivity target;

  @UiThread
  public BookingDetailActivity_ViewBinding(BookingDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BookingDetailActivity_ViewBinding(BookingDetailActivity target, View source) {
    this.target = target;

    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbarDescription = Utils.findRequiredViewAsType(source, R.id.toolbar_subtitle, "field 'toolbarDescription'", TextView.class);
    target.order_id = Utils.findRequiredViewAsType(source, R.id.booking_id, "field 'order_id'", TextView.class);
    target.delivery_on = Utils.findRequiredViewAsType(source, R.id.delivery_on, "field 'delivery_on'", TextView.class);
    target.services = Utils.findRequiredViewAsType(source, R.id.services, "field 'services'", TextView.class);
    target.item_wrapper = Utils.findRequiredViewAsType(source, R.id.items_wrapper, "field 'item_wrapper'", LinearLayout.class);
    target.store_name = Utils.findRequiredViewAsType(source, R.id.store_name, "field 'store_name'", TextView.class);
    target.owner_address = Utils.findRequiredViewAsType(source, R.id.owner_address, "field 'owner_address'", TextView.class);
    target.contact_btn_owner = Utils.findRequiredViewAsType(source, R.id.contact_btn_owner, "field 'contact_btn_owner'", AppCompatButton.class);
    target.detail_btn_owner = Utils.findRequiredViewAsType(source, R.id.detail_btn_owner, "field 'detail_btn_owner'", AppCompatButton.class);
    target.order_status = Utils.findRequiredViewAsType(source, R.id.order_status, "field 'order_status'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BookingDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbarTitle = null;
    target.toolbarDescription = null;
    target.order_id = null;
    target.delivery_on = null;
    target.services = null;
    target.item_wrapper = null;
    target.store_name = null;
    target.owner_address = null;
    target.contact_btn_owner = null;
    target.detail_btn_owner = null;
    target.order_status = null;
  }
}
