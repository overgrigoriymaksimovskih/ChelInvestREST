package ru.chelinvest_rest.exceptions;

public class DigitPreparingException extends IncorrectValueException{
    public DigitPreparingException() {
    }

    public DigitPreparingException(String message) {
        super(message);
    }
}
