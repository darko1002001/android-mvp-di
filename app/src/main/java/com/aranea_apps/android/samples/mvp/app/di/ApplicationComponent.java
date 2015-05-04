package com.aranea_apps.android.samples.mvp.app.di;

import com.aranea_apps.android.samples.mvp.app.App;
import com.aranea_apps.android.samples.mvp.base.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
  modules = ApplicationModule.class
)
public interface ApplicationComponent {
  void inject(App application);

  void inject(BaseActivity baseActivity);
}