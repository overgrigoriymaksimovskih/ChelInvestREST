package ru.chelinvest_rest.utils.digitHandlers.impl;

import ru.chelinvest_rest.utils.CheckersOfSignature.Gender;
import ru.chelinvest_rest.utils.CheckersOfSignature.RuCase;
import ru.chelinvest_rest.utils.digitHandlers.DigitHandler;

public final class aDigitHandlerImpl implements DigitHandler {

    public aDigitHandlerImpl() {
    }
    @Override
    // 1.2.3.4.
    public String process(long num, String sGender, String sCase) {
        if (num == 1){
            return oneToStr(sGender, sCase);
        }
        if (num == 2){
            return twoToStr(sGender, sCase);
        }
        if (num == 3){
            return threeToStr(sCase);
        }
        else {
            return fourToStr(sCase);
        }

    }
    // 1
    private String oneToStr(String sGender, String sCase) {

        if (Gender.FEMALE.equals(sGender)) {
            if (RuCase.I.equals(sCase)) return "одна";
            if (RuCase.V.equals(sCase)) return "одну";

            return "одной";
        }

        if (RuCase.I.equals(sCase) || RuCase.V.equals(sCase)) {
            if (Gender.MALE.equals(sGender)) return "один";
            if (Gender.MIDDLE.equals(sGender)) return "одно";
        }

        if (RuCase.R.equals(sCase)) return "одного";
        if (RuCase.D.equals(sCase)) return "одному";
        if (RuCase.T.equals(sCase)) return "одним";
        if (RuCase.P.equals(sCase)) return "одном";


        throw new IllegalArgumentException();
    }
    // 2
    private String twoToStr(String sGender, String sCase) {

        if (RuCase.I.equals(sCase) || RuCase.V.equals(sCase)) {
            if (Gender.FEMALE.equals(sGender)) return "две";

            return "два";

        }
        if (RuCase.D.equals(sCase)) return "двум";
        if (RuCase.T.equals(sCase)) return "двумя";

        return "двух";
    }
    //3
    private String threeToStr(String sCase) {
        if (RuCase.R.equals(sCase) || RuCase.P.equals(sCase)) return "трёх";
        if (RuCase.D.equals(sCase)) return "трём";
        if (RuCase.T.equals(sCase)) return "тремя";

        return "три";
    }
    //4
    private String fourToStr(String sCase) {
        if (RuCase.R.equals(sCase) || RuCase.P.equals(sCase)) return "четырёх";
        if (RuCase.D.equals(sCase)) return "четырём";
        if (RuCase.T.equals(sCase)) return "четырьмя";

        return "четыре";
    }

}
