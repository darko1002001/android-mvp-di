package com.aranea_apps.android.samples.mvp.modules.login;

import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@LargeTest
public class LoginPresenterTest {

  LoginPresenter presenter;
  private LoginView loginView;
  private LoginInteractor loginInteractor;

  @BeforeClass
  public static void oneTimeSetUp() {
    // one-time initialization code
  }

  @AfterClass
  public static void oneTimeTearDown() {
    // one-time cleanup code
  }

  @Before
  public void setUp() {
    loginView = mock(LoginView.class);
    loginInteractor = mock(LoginInteractor.class);
    presenter = new LoginPresenter(loginView, loginInteractor);
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testIsValid() throws Exception {
    assertTrue(presenter.isValid("User", "Pass"));
    
  }

  @Test
  public void testIsValidWithoutUsername() throws Exception {
    assertFalse(presenter.isValid(null, "Pass"));
    verify(loginView).loginError();
  }

  @Test
  public void testIsValidWithoutPassword() throws Exception {
    assertFalse(presenter.isValid("User", null));
    verify(loginView).loginError();
  }

  @Test
  public void testIsValidWithoutCredentials() throws Exception {
    assertFalse(presenter.isValid(null, null));
    verify(loginView).loginError();
  }

  @Test
  public void testLoginClicked() throws Exception {
    presenter.loginClicked("User", "Pass");
    verify(loginView).startProgress();
    verify(loginInteractor).login("User", "Pass", presenter);
  }

}