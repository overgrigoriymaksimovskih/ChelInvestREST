package ru.chelinvest_rest.utils.digitHandlers.impl;

import ru.chelinvest_rest.utils.CheckersOfSignature.RuCase;
import ru.chelinvest_rest.utils.digitHandlers.DigitHandler;
import ru.chelinvest_rest.utils.digitHandlers.SimpleNumberEnder;

public final class bDigitHandlerImpl implements DigitHandler {
    private static final String[] fromFiveToNineTemplates = {"пят", "шест", "сем", "восем", "девят"};

    public bDigitHandlerImpl() {
    }
    @Override
    //5-9
    public String process(long num, String sGender, String sCase) {
        String template = fromFiveToNineTemplates[(int) (num - fromFiveToNineTemplates.length)];

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
}
