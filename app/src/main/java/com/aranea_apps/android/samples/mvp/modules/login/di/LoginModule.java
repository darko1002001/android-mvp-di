package com.aranea_apps.android.samples.mvp.modules.login.di;

import com.aranea_apps.android.samples.mvp.app.di.PerActivity;
import com.aranea_apps.android.samples.mvp.modules.login.LoginInteractor;
import com.aranea_apps.android.samples.mvp.modules.login.LoginInteractorImpl;
import com.aranea_apps.android.samples.mvp.modules.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

  @Provides
  @PerActivity
  LoginPresenter provideLoginPresenter(LoginInteractor loginInteractor) {
    return new LoginPresenter(loginInteractor);
  }

  @Provides
  @PerActivity
  LoginInteractor provideLoginInteractor() {
    return new LoginInteractorImpl();
  }

}
