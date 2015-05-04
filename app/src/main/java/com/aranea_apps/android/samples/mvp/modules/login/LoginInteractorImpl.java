package com.aranea_apps.android.samples.mvp.modules.login;

import android.os.Handler;

public class LoginInteractorImpl implements LoginInteractor {
  @Override
  public void login(String username, String password, final LoginCallback loginCallback) {
    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        loginCallback.error();
      }
    }, 2000);
  }
}
