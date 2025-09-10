package ru.chelinvest_rest.utils.digitHandlers.impl;

import ru.chelinvest_rest.utils.digitHandlers.DigitHandler;
import ru.chelinvest_rest.utils.digitHandlers.SimpleNumberEnder;

public final class cDigitHandlerImpl implements DigitHandler {
    private static final String[] fromTenToNineteenTemplates = {
            "десят", "одиннадцат", "двенадцат", "тринадцат", "четырнадцат",
            "пятнадцат", "шестнадцат", "семнадцат", "восемнадцат", "девятнадцат"
    };

    public cDigitHandlerImpl() {
    }
    @Override
    // 10 - 19
    public String process(long num, String sGender, String sCase) {
        String template = fromTenToNineteenTemplates[(int) (num - fromTenToNineteenTemplates.length)];

        SimpleNumberEnder simpleEnder = new SimpleNumberEnderImpl();
        return simpleEnder.addSimpleNumberEnding(template, sCase);
    }
}
