// Generated by data binding compiler. Do not edit!
package com.droideve.apps.sugoi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.droideve.apps.sugoi.R;
import com.github.siyamed.shapeimageview.RoundedImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class V2StoreGalleryHorizontalBinding extends ViewDataBinding {
  @NonNull
  public final RoundedImageView image;

  @NonNull
  public final FrameLayout main;

  @NonNull
  public final TextView seeMore;

  @NonNull
  public final LinearLayout seeMoreLayout;

  protected V2StoreGalleryHorizontalBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RoundedImageView image, FrameLayout main, TextView seeMore,
      LinearLayout seeMoreLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.image = image;
    this.main = main;
    this.seeMore = seeMore;
    this.seeMoreLayout = seeMoreLayout;
  }

  @NonNull
  public static V2StoreGalleryHorizontalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.v2_store_gallery_horizontal, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static V2StoreGalleryHorizontalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<V2StoreGalleryHorizontalBinding>inflateInternal(inflater, R.layout.v2_store_gallery_horizontal, root, attachToRoot, component);
  }

  @NonNull
  public static V2StoreGalleryHorizontalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.v2_store_gallery_horizontal, null, false, component)
   */
  @NonNull
  @Deprecated
  public static V2StoreGalleryHorizontalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<V2StoreGalleryHorizontalBinding>inflateInternal(inflater, R.layout.v2_store_gallery_horizontal, null, false, component);
  }

  public static V2StoreGalleryHorizontalBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static V2StoreGalleryHorizontalBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (V2StoreGalleryHorizontalBinding)bind(component, view, R.layout.v2_store_gallery_horizontal);
  }
}