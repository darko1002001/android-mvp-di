package com.aranea_apps.android.samples.mvp.modules.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.aranea_apps.android.samples.mvp.R;
import com.aranea_apps.android.samples.mvp.base.activity.BaseActivity;
import com.aranea_apps.android.samples.mvp.modules.login.di.DaggerLoginComponent;
import com.aranea_apps.android.samples.mvp.modules.login.di.LoginComponent;
import com.aranea_apps.android.samples.mvp.modules.login.di.LoginModule;
import com.aranea_apps.android.samples.mvp.modules.main.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

  @InjectView(R.id.username)
  EditText username;
  @InjectView(R.id.password)
  EditText password;
  @InjectView(R.id.buttonLogin)
  Button buttonLogin;

  @Inject
  LoginPresenter presenter;

  @InjectView(R.id.progressBar)
  ProgressBar progressBar;
  private LoginComponent loginComponent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.inject(this);
    initializeInjector();

    presenter.setLoginView(this);
  }

  private void initializeInjector() {
    this.loginComponent = DaggerLoginComponent.builder()
      .applicationComponent(getApplicationComponent())
      .activityModule(getActivityModule())
      .loginModule(new LoginModule())
      .build();
    this.loginComponent.inject(this);

  }

  public LoginComponent getLoginComponent() {
    return loginComponent;
  }

  @OnClick(R.id.buttonLogin)
  public void onLoginClicked() {
    presenter.loginClicked(username.getText().toString(), password.getText().toString());
  }

  @Override
  public void startProgress() {
    buttonLogin.setVisibility(View.GONE);
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void stopProgress() {
    buttonLogin.setVisibility(View.VISIBLE);
    progressBar.setVisibility(View.GONE);
  }

  @Override
  public void startMainActivity() {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }

  @Override
  public void loginError() {
    stopProgress();
  }
}