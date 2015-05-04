package com.aranea_apps.android.samples.mvp.modules.login;


import android.support.annotation.NonNull;

import com.aranea_apps.android.samples.mvp.domain.User;

import javax.inject.Inject;

public class LoginPresenter implements LoginCallback {

  private LoginView loginView;
  private LoginInteractor loginInteractor;

  @Inject
  public LoginPresenter(LoginInteractor loginInteractor) {
    this.loginInteractor = loginInteractor;
  }

  public void setLoginView(@NonNull LoginView loginView) {
    this.loginView = loginView;
  }

  public boolean isValid(String username, String password) {
    if (username == null || username.length() == 0) {
      usernameNotValid();
      return false;
    }
    if (password == null || password.length() == 0) {
      passwordNotValid();
      return false;
    }
    return true;
  }

  private void passwordNotValid() {
    error();
  }

  private void usernameNotValid() {
    error();
  }

  public void loginClicked(String username, String password) {
    if (isValid(username, password)) {
      loginView.startProgress();
      loginInteractor.login(username, password, this);
    }
  }

  @Override
  public void success(User user) {
    loginView.stopProgress();
    loginView.startMainActivity();
  }

  @Override
  public void error() {
    loginView.loginError();
  }
}
