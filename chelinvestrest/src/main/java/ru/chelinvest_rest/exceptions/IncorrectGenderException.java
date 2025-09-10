package ru.chelinvest_rest.exceptions;

public class IncorrectGenderException extends IncorrectValueException {
    public IncorrectGenderException() {
    }

    public IncorrectGenderException(String message) {
        super(message);
    }

    public IncorrectGenderException(String message, Throwable cause) {
        super(message, cause);
    }
}
