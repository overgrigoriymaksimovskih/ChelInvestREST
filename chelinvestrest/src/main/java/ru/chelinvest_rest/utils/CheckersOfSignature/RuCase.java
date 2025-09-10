package ru.chelinvest_rest.utils.CheckersOfSignature;

import java.util.Arrays;

public final class RuCase {
    public static final String I = "И";
    public static final String R = "Р";
    public static final String D = "Д";
    public static final String V = "В";
    public static final String T = "Т";
    public static final String P = "П";

    private static final String[] cases = {I, R, D, V, T, P};

    private RuCase() {
    }

    public static boolean isRuCase(String str) {
        return Arrays.asList(cases).contains(str);
    }
}
