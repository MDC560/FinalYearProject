// Generated by data binding compiler. Do not edit!
package com.example.finalproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.finalproject.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMedsBinding extends ViewDataBinding {
  @NonNull
  public final Button button2;

  @NonNull
  public final Button button3;

  @NonNull
  public final EditText editTextTextMultiLine;

  @NonNull
  public final EditText editTextTextPersonName11;

  @NonNull
  public final EditText editTextTextPersonName13;

  @NonNull
  public final EditText editTextTextPersonName8;

  protected ActivityMedsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button button2, Button button3, EditText editTextTextMultiLine,
      EditText editTextTextPersonName11, EditText editTextTextPersonName13,
      EditText editTextTextPersonName8) {
    super(_bindingComponent, _root, _localFieldCount);
    this.button2 = button2;
    this.button3 = button3;
    this.editTextTextMultiLine = editTextTextMultiLine;
    this.editTextTextPersonName11 = editTextTextPersonName11;
    this.editTextTextPersonName13 = editTextTextPersonName13;
    this.editTextTextPersonName8 = editTextTextPersonName8;
  }

  @NonNull
  public static ActivityMedsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_meds, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMedsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMedsBinding>inflateInternal(inflater, R.layout.activity_meds, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMedsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_meds, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMedsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMedsBinding>inflateInternal(inflater, R.layout.activity_meds, null, false, component);
  }

  public static ActivityMedsBinding bind(@NonNull View view) {
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
  public static ActivityMedsBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMedsBinding)bind(component, view, R.layout.activity_meds);
  }
}
