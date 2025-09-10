package ru.chelinvest_rest.utils.digitHandlers.impl;

import ru.chelinvest_rest.utils.digitHandlers.DigitHandler;
import ru.chelinvest_rest.utils.digitHandlers.SimpleNumberEnder;

public final class dDigitHandlerImpl implements DigitHandler {
    private static final String[] twentyAndThirtyTemplates = {"двадцат", "тридцат"};

    public dDigitHandlerImpl() {
    }
    @Override
    //20-40
    public String process(long num, String sGender, String sCase) {
        String template = twentyAndThirtyTemplates[(int) (num / 10 - twentyAndThirtyTemplates.length)];
        SimpleNumberEnder simpleEnder = new SimpleNumberEnderImpl();
        return simpleEnder.addSimpleNumberEnding(template, sCase);
    }
}
