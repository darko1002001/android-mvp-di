package com.aranea_apps.android.samples.mvp.utils;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SmallTest
public class EmailValidatorTest {

  /**
   * Email validation pattern.
   */
  public static final Pattern EMAIL_PATTERN = Pattern.compile(
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
      "\\@" +
      "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
      "(" +
      "\\." +
      "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
      ")+"
  );

  @Test
  public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
    assertTrue(EmailValidator.isValidEmail(EMAIL_PATTERN, "name@email.com"));
  }

  @Test
  public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
    assertTrue(EmailValidator.isValidEmail(EMAIL_PATTERN, "name@email.co.uk"));
  }

  @Test
  public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
    assertFalse(EmailValidator.isValidEmail(EMAIL_PATTERN, "name@email"));
  }

  @Test
  public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
    assertFalse(EmailValidator.isValidEmail(EMAIL_PATTERN, "name@email..com"));
  }

  @Test
  public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
    assertFalse(EmailValidator.isValidEmail(EMAIL_PATTERN, "@email.com"));
  }

  @Test
  public void emailValidator_EmptyString_ReturnsFalse() {
    assertFalse(EmailValidator.isValidEmail(EMAIL_PATTERN, ""));
  }

  @Test
  public void emailValidator_NullEmail_ReturnsFalse() {
    assertFalse(EmailValidator.isValidEmail(EMAIL_PATTERN, null));
  }
}