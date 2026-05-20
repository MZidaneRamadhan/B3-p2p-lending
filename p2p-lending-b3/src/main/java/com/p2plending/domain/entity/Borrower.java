package com.p2plending.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Borrower extends User {
    private int creditScore;
    private double loanLimit;

    public Borrower(String userId, String name, String email, String number, int creditScore, double loanLimit) {
        super(userId, name, email, number);
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