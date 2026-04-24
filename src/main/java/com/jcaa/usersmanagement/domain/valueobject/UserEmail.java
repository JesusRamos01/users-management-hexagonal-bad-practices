package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidUserEmailException;
import java.util.Objects;
import java.util.regex.Pattern;

public record UserEmail(String value) {

  private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+\\-]+@[a-zA-Z0-9.\\-]+\\.[a-zA-Z]{2,}$");

  public UserEmail {
    final String normalizedValue = Objects.requireNonNull(value, "UserEmail cannot be null")
        .trim()
        .toLowerCase();

    if (!isValid(normalizedValue)) {
      throw InvalidUserEmailException.becauseFormatIsInvalid(normalizedValue);
    }

    value = normalizedValue;
  }

  public static boolean isValid(final String value) {
    if (value == null) {
      return false;
    }

    final String normalizedValue = value.trim().toLowerCase();

    return !normalizedValue.isEmpty()
        && EMAIL_PATTERN.matcher(normalizedValue).matches();
  }

  @Override
  public String toString() {
    return value;
  }
}
