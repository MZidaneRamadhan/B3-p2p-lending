package com.p2plending.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Borrower extends User {
    private int creditScore;
    private double loanLimit;

    public Borrower(String userId, String name, int creditScore, double loanLimit) {
        super(userId, name);
        this.creditScore = creditScore;
        this.loanLimit = loanLimit;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getLoanLimit() {
        return loanLimit;
    }

}