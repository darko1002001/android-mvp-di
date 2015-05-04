package com.aranea_apps.android.samples.mvp.modules.login;

public interface LoginInteractor {
  void login(String username, String password, LoginCallback loginCallback);
}
