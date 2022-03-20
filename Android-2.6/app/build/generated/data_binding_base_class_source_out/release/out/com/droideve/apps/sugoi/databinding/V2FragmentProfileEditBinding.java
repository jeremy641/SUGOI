// Generated by data binding compiler. Do not edit!
package com.droideve.apps.sugoi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.balysv.materialripple.MaterialRippleLayout;
import com.droideve.apps.sugoi.R;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class V2FragmentProfileEditBinding extends ViewDataBinding {
  @NonNull
  public final ImageView authBg;

  @NonNull
  public final LinearLayout changePasswordLayout;

  @NonNull
  public final TextInputEditText email;

  @NonNull
  public final FrameLayout framePhoto;

  @NonNull
  public final TextInputEditText fullName;

  @NonNull
  public final TextInputEditText login;

  @NonNull
  public final MaterialRippleLayout saveBtn;

  @NonNull
  public final ImageView takePicture;

  @NonNull
  public final CircularImageView userimage;

  protected V2FragmentProfileEditBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView authBg, LinearLayout changePasswordLayout, TextInputEditText email,
      FrameLayout framePhoto, TextInputEditText fullName, TextInputEditText login,
      MaterialRippleLayout saveBtn, ImageView takePicture, CircularImageView userimage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.authBg = authBg;
    this.changePasswordLayout = changePasswordLayout;
    this.email = email;
    this.framePhoto = framePhoto;
    this.fullName = fullName;
    this.login = login;
    this.saveBtn = saveBtn;
    this.takePicture = takePicture;
    this.userimage = userimage;
  }

  @NonNull
  public static V2FragmentProfileEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.v2_fragment_profile_edit, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static V2FragmentProfileEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<V2FragmentProfileEditBinding>inflateInternal(inflater, R.layout.v2_fragment_profile_edit, root, attachToRoot, component);
  }

  @NonNull
  public static V2FragmentProfileEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.v2_fragment_profile_edit, null, false, component)
   */
  @NonNull
  @Deprecated
  public static V2FragmentProfileEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<V2FragmentProfileEditBinding>inflateInternal(inflater, R.layout.v2_fragment_profile_edit, null, false, component);
  }

  public static V2FragmentProfileEditBinding bind(@NonNull View view) {
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
  public static V2FragmentProfileEditBinding bind(@NonNull View view, @Nullable Object component) {
    return (V2FragmentProfileEditBinding)bind(component, view, R.layout.v2_fragment_profile_edit);
  }
}