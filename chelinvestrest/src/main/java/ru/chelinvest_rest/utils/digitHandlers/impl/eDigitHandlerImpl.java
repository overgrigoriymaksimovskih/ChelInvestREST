package ru.chelinvest_rest.utils.digitHandlers.impl;

import ru.chelinvest_rest.utils.CheckersOfSignature.RuCase;
import ru.chelinvest_rest.utils.digitHandlers.DigitHandler;

public final class eDigitHandlerImpl implements DigitHandler {

    public eDigitHandlerImpl() {
    }
    @Override
    //40.90.100
    public String process(long num, String sGender, String sCase) {
        if (RuCase.I.equals(sCase) || RuCase.V.equals(sCase)) {

            if (num >= 40 && num < 50) return "сорок";
            if (num >= 90 && num < 100) return "девяносто";

            return "сто";
        }
        if (num >= 40 && num < 50) return "сорока";
        if (num >= 90 && num < 100) return "девяноста";

        return "ста";
    }
}
