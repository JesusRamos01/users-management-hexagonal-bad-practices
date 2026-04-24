package com.jcaa.usersmanagement.domain.exception;

public final class InvalidUserPasswordException extends DomainException {

  private static final String INVALID_USER_PASSWORD_MESSAGE = "The user password is not valid.";
  private static final String INVALID_USER_PASSWORD_MIN_LENGTH_MESSAGE =
      "The user password must have at least %d characters.";

  private InvalidUserPasswordException(final String message) {
    super(message);
  }

  public static InvalidUserPasswordException becauseValueIsEmpty() {
    return new InvalidUserPasswordException(INVALID_USER_PASSWORD_MESSAGE);
  }

  public static InvalidUserPasswordException becauseLengthIsTooShort(final int minimumLength) {
    return new InvalidUserPasswordException(
        String.format(INVALID_USER_PASSWORD_MIN_LENGTH_MESSAGE, minimumLength));
  }
}
