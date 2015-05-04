package com.aranea_apps.android.samples.mvp.modules.login;

public interface LoginView {
  void startProgress();

  void stopProgress();

  void startMainActivity();

  void loginError();
}
