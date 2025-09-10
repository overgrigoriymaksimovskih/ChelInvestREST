package ru.chelinvest_rest.utils.digitHandlers.impl;

import ru.chelinvest_rest.utils.CheckersOfSignature.RuCase;
import ru.chelinvest_rest.utils.digitHandlers.DigitHandler;
import ru.chelinvest_rest.utils.digitHandlers.SimpleNumberEnder;

public final class fDigitHandlerImpl implements DigitHandler  {
    private static final String[] fromFiveToNineTemplates = {"пят", "шест", "сем", "восем", "девят"};
    private static final String[] fromTenToNineteenTemplates = {
            "десят", "одиннадцат", "двенадцат", "тринадцат", "четырнадцат",
            "пятнадцат", "шестнадцат", "семнадцат", "восемнадцат", "девятнадцат"
    };

    public fDigitHandlerImpl() {
    }
    @Override
    //50-90
    public String process(long num, String sGender, String sCase) {
        if (RuCase.I.equals(sCase) || RuCase.V.equals(sCase)) {
            return fromFiveToNineToStr((int) (num / 10), sCase) + fromTenToNineteenTemplates[0];
        }

        return fromFiveToNineToStr((int) (num / 10), sCase) + fromTenToNineteenToStr(10, sCase);
    }

    private String fromFiveToNineToStr(int num, String sCase) {

        String template = fromFiveToNineTemplates[num - 5];

        if (8 == num
                && !RuCase.I.equals(sCase)
                && !RuCase.V.equals(sCase)
                && !RuCase.T.equals(sCase)
        ) {
            return "восьми";
        }

        SimpleNumberEnder simpleEnder = new SimpleNumberEnderImpl();
        return simpleEnder.addSimpleNumberEnding(template, sCase);
    }
    private String fromTenToNineteenToStr(int num, String sCase) {

        String template = fromTenToNineteenTemplates[num - 10];

        SimpleNumberEnder simpleEnder = new SimpleNumberEnderImpl();
        return simpleEnder.addSimpleNumberEnding(template, sCase);
    }
}
