package com.aranea_apps.android.samples.mvp.modules.login.di;

import com.aranea_apps.android.samples.mvp.app.di.ActivityComponent;
import com.aranea_apps.android.samples.mvp.app.di.ActivityModule;
import com.aranea_apps.android.samples.mvp.app.di.ApplicationComponent;
import com.aranea_apps.android.samples.mvp.app.di.PerActivity;
import com.aranea_apps.android.samples.mvp.modules.login.LoginActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, LoginModule.class})
public interface LoginComponent extends ActivityComponent {
  void inject(LoginActivity loginActivity);
}
