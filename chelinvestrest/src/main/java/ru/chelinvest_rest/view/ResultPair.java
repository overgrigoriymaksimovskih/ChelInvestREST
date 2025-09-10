package ru.chelinvest_rest.view;

class ResultPair {
    private String nSum;
    private String sGender;
    private String sCase;
    private String response;

    public ResultPair(String nSum, String sGender, String sCase, String response) {
        this.nSum = nSum;
        this.sGender = sGender;
        this.sCase = sCase;
        this.response = response;
    }

    public String getnSum() {
        return nSum;
    }

    public String getsGender() {
        return sGender;
    }

    public String getsCase() {
        return sCase;
    }

    public String getResponse() {
        return response;
    }
}
