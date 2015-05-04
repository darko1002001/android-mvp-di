package com.aranea_apps.android.samples.mvp.app;

import android.app.Application;

import com.aranea_apps.android.samples.mvp.app.di.ApplicationComponent;
import com.aranea_apps.android.samples.mvp.app.di.ApplicationModule;
import com.aranea_apps.android.samples.mvp.app.di.DaggerApplicationComponent;

public class App extends Application {

  private ApplicationComponent component;

  @Override
  public void onCreate() {
    super.onCreate();

    component = DaggerApplicationComponent.builder()
      .applicationModule(new ApplicationModule(this))
      .build();
    component().inject(this);
  }

  public ApplicationComponent component() {
    return component;
  }


}
