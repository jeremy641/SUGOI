// Generated by data binding compiler. Do not edit!
package com.droideve.apps.sugoi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

public abstract class V2FragmentProfileSignupBinding extends ViewDataBinding {
  @NonNull
  public final ImageView authBg;

  @NonNull
  public final ImageView btnBack;

  @NonNull
  public final MaterialRippleLayout btnSignup;

  @NonNull
  public final LinearLayout changePasswordLayout;

  @NonNull
  public final MaterialRippleLayout connect;

  @NonNull
  public final TextView createAccountBtn;

  @NonNull
  public final TextInputEditText emailSignup;

  @NonNull
  public final TextView forgetPassword;

  @NonNull
  public final FrameLayout framePhoto;

  @NonNull
  public final TextInputEditText fullNameSignup;

  @NonNull
  public final TextView haveAccountBtn;

  @NonNull
  public final TextInputEditText login;

  @NonNull
  public final LinearLayout loginLayout;

  @NonNull
  public final TextInputEditText loginSignup;

  @NonNull
  public final TextInputEditText password;

  @NonNull
  public final TextInputEditText passwordSignup;

  @NonNull
  public final LinearLayout signupLayout;

  @NonNull
  public final LinearLayout signupLayout1;

  @NonNull
  public final ImageView takePicture;

  @NonNull
  public final LinearLayout toolbar;

  @NonNull
  public final TextView toolbarSubtitle;

  @NonNull
  public final TextView toolbarTitle;

  @NonNull
  public final CircularImageView userimage;

  protected V2FragmentProfileSignupBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView authBg, ImageView btnBack, MaterialRippleLayout btnSignup,
      LinearLayout changePasswordLayout, MaterialRippleLayout connect, TextView createAccountBtn,
      TextInputEditText emailSignup, TextView forgetPassword, FrameLayout framePhoto,
      TextInputEditText fullNameSignup, TextView haveAccountBtn, TextInputEditText login,
      LinearLayout loginLayout, TextInputEditText loginSignup, TextInputEditText password,
      TextInputEditText passwordSignup, LinearLayout signupLayout, LinearLayout signupLayout1,
      ImageView takePicture, LinearLayout toolbar, TextView toolbarSubtitle, TextView toolbarTitle,
      CircularImageView userimage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.authBg = authBg;
    this.btnBack = btnBack;
    this.btnSignup = btnSignup;
    this.changePasswordLayout = changePasswordLayout;
    this.connect = connect;
    this.createAccountBtn = createAccountBtn;
    this.emailSignup = emailSignup;
    this.forgetPassword = forgetPassword;
    this.framePhoto = framePhoto;
    this.fullNameSignup = fullNameSignup;
    this.haveAccountBtn = haveAccountBtn;
    this.login = login;
    this.loginLayout = loginLayout;
    this.loginSignup = loginSignup;
    this.password = password;
    this.passwordSignup = passwordSignup;
    this.signupLayout = signupLayout;
    this.signupLayout1 = signupLayout1;
    this.takePicture = takePicture;
    this.toolbar = toolbar;
    this.toolbarSubtitle = toolbarSubtitle;
    this.toolbarTitle = toolbarTitle;
    this.userimage = userimage;
  }

  @NonNull
  public static V2FragmentProfileSignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.v2_fragment_profile_signup, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static V2FragmentProfileSignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<V2FragmentProfileSignupBinding>inflateInternal(inflater, R.layout.v2_fragment_profile_signup, root, attachToRoot, component);
  }

  @NonNull
  public static V2FragmentProfileSignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.v2_fragment_profile_signup, null, false, component)
   */
  @NonNull
  @Deprecated
  public static V2FragmentProfileSignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<V2FragmentProfileSignupBinding>inflateInternal(inflater, R.layout.v2_fragment_profile_signup, null, false, component);
  }

  public static V2FragmentProfileSignupBinding bind(@NonNull View view) {
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
  public static V2FragmentProfileSignupBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (V2FragmentProfileSignupBinding)bind(component, view, R.layout.v2_fragment_profile_signup);
  }
}
