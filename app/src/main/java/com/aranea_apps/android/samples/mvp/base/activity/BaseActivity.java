package com.aranea_apps.android.samples.mvp.base.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aranea_apps.android.samples.mvp.app.di.ActivityModule;
import com.aranea_apps.android.samples.mvp.app.App;
import com.aranea_apps.android.samples.mvp.app.di.ApplicationComponent;

public class BaseActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.getApplicationComponent().inject(this);
  }

  /**
   * Get the Main Application component for dependency injection.
   */
  protected ApplicationComponent getApplicationComponent() {
    return ((App)getApplication()).component();
  }

  /**
   * Get an Activity module for dependency injection.
   *
   */
  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }
}
