package com.hermes.sinfo.crawler;

public enum Buyer {
    INSTITUTIONAL(4),
    FOREIGN(6);

    private int codeOfBuyer;

    Buyer(int codeOfBuyer) {
        this.codeOfBuyer = codeOfBuyer;
    }

    public int getCodeOfBuyer() {
        return codeOfBuyer;
    }
}
