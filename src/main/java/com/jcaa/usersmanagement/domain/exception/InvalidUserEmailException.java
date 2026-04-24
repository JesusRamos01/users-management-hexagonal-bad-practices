package com.jcaa.usersmanagement.domain.exception;

public final class InvalidUserEmailException extends DomainException {

  private static final String INVALID_USER_EMAIL_MESSAGE = "The user email must not be empty.";
  private static final String INVALID_USER_EMAIL_FORMAT_MESSAGE = "The user email format is invalid: '%s'.";

  private InvalidUserEmailException(final String message) {
    super(message);
  }

  public static InvalidUserEmailException becauseValueIsEmpty() {
    // VIOLACIÓN Regla 10: texto hardcodeado directamente — debe ser una constante.
    return new InvalidUserEmailException(INVALID_USER_EMAIL_MESSAGE);
  }

  public static InvalidUserEmailException becauseFormatIsInvalid(final String email) {
    // VIOLACIÓN Regla 10: texto hardcodeado directamente — debe ser una constante.
    return new InvalidUserEmailException(String.format(INVALID_USER_EMAIL_FORMAT_MESSAGE, email));
  }
}
