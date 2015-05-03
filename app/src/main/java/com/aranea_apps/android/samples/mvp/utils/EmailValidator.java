package com.aranea_apps.android.samples.mvp.utils;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.regex.Pattern;

/**
 * An Email format validator for {@link android.widget.EditText}.
 */
public class EmailValidator implements TextWatcher {

    private boolean mIsValid = false;

    public boolean isValid() {
        return mIsValid;
    }

    /**
     * Validates if the given input is a valid email address.
     *
     * @param emailPattern The {@link Pattern} used to validate the given email.
     * @param email The email to validate.
     * @return {@code true} if the input is a valid email. {@code false} otherwise.
     */
    public static boolean isValidEmail(Pattern emailPattern, CharSequence email) {
        return email != null && emailPattern.matcher(email).matches();
    }

    @Override
    final public void afterTextChanged(Editable editableText) {
        mIsValid = isValidEmail(android.util.Patterns.EMAIL_ADDRESS, editableText);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {/*No-op*/}

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {/*No-op*/}
}