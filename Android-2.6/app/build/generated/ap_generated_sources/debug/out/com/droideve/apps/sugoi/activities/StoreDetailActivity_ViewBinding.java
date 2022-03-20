// Generated code from Butter Knife. Do not modify!
package com.droideve.apps.sugoi.activities;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.droideve.apps.sugoi.R;
import com.google.android.gms.ads.AdView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StoreDetailActivity_ViewBinding implements Unbinder {
  private StoreDetailActivity target;

  private View view7f0a0178;

  @UiThread
  public StoreDetailActivity_ViewBinding(StoreDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StoreDetailActivity_ViewBinding(final StoreDetailActivity target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.app_bar, "field 'toolbar'", Toolbar.class);
    target.badge_category = Utils.findRequiredViewAsType(source, R.id.badge_category, "field 'badge_category'", TextView.class);
    target.badge_closed = Utils.findRequiredViewAsType(source, R.id.badge_closed, "field 'badge_closed'", TextView.class);
    target.badge_open = Utils.findRequiredViewAsType(source, R.id.badge_open, "field 'badge_open'", TextView.class);
    target.image = Utils.findRequiredViewAsType(source, R.id.image, "field 'image'", ImageView.class);
    target.scrollView = Utils.findRequiredViewAsType(source, R.id.scroll_view, "field 'scrollView'", NestedScrollView.class);
    target.opening_time_container = Utils.findRequiredViewAsType(source, R.id.opening_time_container, "field 'opening_time_container'", LinearLayout.class);
    target.opening_time_content = Utils.findRequiredViewAsType(source, R.id.opening_time_content, "field 'opening_time_content'", TextView.class);
    target.opening_time_label = Utils.findRequiredViewAsType(source, R.id.opening_time_label, "field 'opening_time_label'", TextView.class);
    target.images_layout = Utils.findRequiredViewAsType(source, R.id.images_layout, "field 'images_layout'", RelativeLayout.class);
    target.nbrPictures = Utils.findRequiredViewAsType(source, R.id.nbrPictures, "field 'nbrPictures'", TextView.class);
    target.review_layout = Utils.findRequiredViewAsType(source, R.id.review_layout, "field 'review_layout'", RelativeLayout.class);
    target.review_rate = Utils.findRequiredViewAsType(source, R.id.review_rate, "field 'review_rate'", TextView.class);
    target.review_comment = Utils.findRequiredViewAsType(source, R.id.review_comment, "field 'review_comment'", TextView.class);
    target.distanceLayout = Utils.findRequiredViewAsType(source, R.id.distance_layout, "field 'distanceLayout'", RelativeLayout.class);
    target.distance_title = Utils.findRequiredViewAsType(source, R.id.distance_title, "field 'distance_title'", TextView.class);
    target.distanceValue = Utils.findRequiredViewAsType(source, R.id.distanceValue, "field 'distanceValue'", TextView.class);
    target.adsLayout = Utils.findRequiredViewAsType(source, R.id.adsLayout, "field 'adsLayout'", LinearLayout.class);
    target.mAdView = Utils.findRequiredViewAsType(source, R.id.adView, "field 'mAdView'", AdView.class);
    target.btn_chat_customer = Utils.findRequiredViewAsType(source, R.id.btn_chat, "field 'btn_chat_customer'", ImageButton.class);
    target.btn_share = Utils.findRequiredViewAsType(source, R.id.btn_share, "field 'btn_share'", ImageButton.class);
    target.phoneBtn = Utils.findRequiredViewAsType(source, R.id.btn_phone, "field 'phoneBtn'", ImageButton.class);
    target.description_content = Utils.findRequiredViewAsType(source, R.id.description_content, "field 'description_content'", TextView.class);
    target.header_title = Utils.findRequiredViewAsType(source, R.id.header_title, "field 'header_title'", TextView.class);
    target.header_subtitle = Utils.findRequiredViewAsType(source, R.id.header_subtitle, "field 'header_subtitle'", TextView.class);
    target.progressMapLL = Utils.findRequiredViewAsType(source, R.id.progressMapLL, "field 'progressMapLL'", LinearLayout.class);
    target.btnWebsite = Utils.findRequiredViewAsType(source, R.id.websiteBtn, "field 'btnWebsite'", ImageButton.class);
    view = Utils.findRequiredView(source, R.id.btn_custom_book, "field 'btn_custom_book' and method 'onOrderClick'");
    target.btn_custom_book = Utils.castView(view, R.id.btn_custom_book, "field 'btn_custom_book'", AppCompatButton.class);
    view7f0a0178 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onOrderClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    StoreDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.badge_category = null;
    target.badge_closed = null;
    target.badge_open = null;
    target.image = null;
    target.scrollView = null;
    target.opening_time_container = null;
    target.opening_time_content = null;
    target.opening_time_label = null;
    target.images_layout = null;
    target.nbrPictures = null;
    target.review_layout = null;
    target.review_rate = null;
    target.review_comment = null;
    target.distanceLayout = null;
    target.distance_title = null;
    target.distanceValue = null;
    target.adsLayout = null;
    target.mAdView = null;
    target.btn_chat_customer = null;
    target.btn_share = null;
    target.phoneBtn = null;
    target.description_content = null;
    target.header_title = null;
    target.header_subtitle = null;
    target.progressMapLL = null;
    target.btnWebsite = null;
    target.btn_custom_book = null;

    view7f0a0178.setOnClickListener(null);
    view7f0a0178 = null;
  }
}
