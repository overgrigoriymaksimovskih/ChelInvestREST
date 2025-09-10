package ru.chelinvest_rest.view;

class ResultPair {
    private String nSum;
    private String response;

    public ResultPair(String nSum, String response) {
        this.nSum = nSum;
        this.response = response;
    }

    public String getnSum() {
        return nSum;
    }

    public String getResponse() {
        return response;
    }
}
