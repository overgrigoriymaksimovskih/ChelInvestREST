package ru.chelinvest_rest.utils.digitHandlers.impl;

import ru.chelinvest_rest.utils.CheckersOfSignature.Gender;
import ru.chelinvest_rest.utils.CheckersOfSignature.RuCase;
import ru.chelinvest_rest.utils.digitHandlers.DigitHandler;
import ru.chelinvest_rest.utils.digitHandlers.SimpleNumberEnder;

public final class gDigitHandlerImpl implements DigitHandler  {
    private static final String[] fromFiveToNineTemplates = {"пят", "шест", "сем", "восем", "девят"};

    public gDigitHandlerImpl() {
    }
    @Override
    //200 - 900
    public String process(long num, String sGender, String sCase) {
        if (RuCase.I.equals(sCase) || RuCase.V.equals(sCase)) {
            if (200 == num) return "двести";
            if (300 == num) return "триста";
            if (400 == num) return "четыреста";
        }

        String template = firstCategoryHandler((int) (num / 100), Gender.MALE, sCase);

        if (RuCase.D.equals(sCase)) return template + "стам";
        if (RuCase.T.equals(sCase)) return template + "стами";
        if (RuCase.P.equals(sCase)) return template + "стах";

        return template + "сот";
    }
    private String firstCategoryHandler(int num, String sGender, String sCase) {

        if (1 == num) return oneToStr(sGender, sCase);
        if (2 == num) return twoToStr(sGender, sCase);
        if (3 == num) return threeToStr(sCase);
        if (4 == num) return fourToStr(sCase);

        return fromFiveToNineToStr(num, sCase);
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

    // 5 - 9
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
}
