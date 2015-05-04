package com.aranea_apps.android.samples.mvp.modules.login;

import com.aranea_apps.android.samples.mvp.domain.User;

public interface LoginCallback {

  void success(User user);

  void error();

}
