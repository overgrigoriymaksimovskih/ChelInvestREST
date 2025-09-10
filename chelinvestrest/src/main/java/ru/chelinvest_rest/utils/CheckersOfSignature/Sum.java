package ru.chelinvest_rest.utils.CheckersOfSignature;

public final class Sum {
    private Sum() {
    }

    public static boolean iisValidNumber(Long nSum) {
        return 0 <= nSum && nSum <= 999_999_999_999L;
    }
}
