package ru.chelinvest_rest.service.impl;

import org.springframework.stereotype.Service;
import ru.chelinvest_rest.exceptions.*;
import ru.chelinvest_rest.service.NumberToTextConverter;
import ru.chelinvest_rest.utils.CheckersOfSignature.Gender;
import ru.chelinvest_rest.utils.CheckersOfSignature.RuCase;
import ru.chelinvest_rest.utils.CheckersOfSignature.Sum;
import ru.chelinvest_rest.utils.DigitPreparer;
import ru.chelinvest_rest.utils.StringMaker;

import java.util.List;
import java.util.Map;

@Service
public class NumberToTextConverterImpl implements NumberToTextConverter {

    @Override
    public String numberToWords(Long nSum, String sGender, String sCase) throws IncorrectValueException {

        if (0L == nSum) return zeroToStr(sCase);

        if (!Gender.isGender(sGender)) {

            String msg = String.format("%s - неверный пол", sGender);
            throw new IncorrectGenderException(msg);
        }
        if (!RuCase.isRuCase(sCase)) {

            String msg = String.format("%s - неверный падеж", sCase);
            throw new IncorrectCaseException(msg);
        }
        if (!Sum.iisValidNumber(nSum)) {

            String msg = String.format("%d - введено неверное число. Используйте от 0 до 999 999 999 999", nSum);
            throw new IncorrectNumberException(msg);
        }

        List<Map.Entry<Long, Integer>> preparedDigit = null;

        try {
            preparedDigit = DigitPreparer.convertNumberToArray(nSum);
        } catch (DigitPreparingException e) {
            throw new IncorrectValueException("Ошибка при подготовке числа для преобразования", e);
        }

        try {
            return StringMaker.processNumberList(preparedDigit, sGender, sCase);
        } catch (StringMakingException e) {
            throw new IncorrectValueException("Ошибка при создании строки из подготовленного списка пар \"Разряд/Значение\" ", e);
        }
    }

    private String zeroToStr(String sCase) {

        if (RuCase.R.equals(sCase)) return "ноля";
        if (RuCase.D.equals(sCase)) return "нолю";
        if (RuCase.T.equals(sCase)) return "нолём";
        if (RuCase.P.equals(sCase)) return " ноле";

        return "ноль";
    }
}
