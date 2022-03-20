// Generated by data binding compiler. Do not edit!
package com.droideve.apps.sugoi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.droideve.apps.sugoi.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class V2FragmentCustomSearchBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSearchLayout;

  @NonNull
  public final NestedScrollView nestedContent;

  protected V2FragmentCustomSearchBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Button btnSearchLayout, NestedScrollView nestedContent) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSearchLayout = btnSearchLayout;
    this.nestedContent = nestedContent;
  }

  @NonNull
  public static V2FragmentCustomSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.v2_fragment_custom_search, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static V2FragmentCustomSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<V2FragmentCustomSearchBinding>inflateInternal(inflater, R.layout.v2_fragment_custom_search, root, attachToRoot, component);
  }

  @NonNull
  public static V2FragmentCustomSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.v2_fragment_custom_search, null, false, component)
   */
  @NonNull
  @Deprecated
  public static V2FragmentCustomSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<V2FragmentCustomSearchBinding>inflateInternal(inflater, R.layout.v2_fragment_custom_search, null, false, component);
  }

  public static V2FragmentCustomSearchBinding bind(@NonNull View view) {
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
  public static V2FragmentCustomSearchBinding bind(@NonNull View view, @Nullable Object component) {
    return (V2FragmentCustomSearchBinding)bind(component, view, R.layout.v2_fragment_custom_search);
  }
}