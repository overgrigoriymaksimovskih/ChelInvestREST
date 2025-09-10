package ru.chelinvest_rest.service;

import ru.chelinvest_rest.exceptions.IncorrectValueException;

public interface NumberToTextConverter {

    // Преобразует число от 0 до 999 999 999 999 в строковое представление
    // nSum - число которое будем преобразовывать
    // sGender - род М - мужской, Ж - женский, С - средний
    // sCase - падеж. И - именительный, Р - родительный, Д - дательный, В - винительный, Т - творительный, П - предложный

    String numberToWords(Long nSum, String sGender, String sCase) throws IncorrectValueException;
}