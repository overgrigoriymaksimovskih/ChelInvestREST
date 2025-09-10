package ru.chelinvest_rest.exceptions;

public class StringMakingException extends IncorrectValueException{
    public StringMakingException() {
    }

    public StringMakingException(String message) {
        super(message);
    }
}
