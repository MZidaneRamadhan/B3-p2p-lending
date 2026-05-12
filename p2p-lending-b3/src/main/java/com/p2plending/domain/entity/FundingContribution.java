package com.p2plending.domain.entity;

public class FundingContribution {
    private String contributionId;
    private Lender lender;
    private double amount;

    public FundingContribution(String contributionId, Lender lender, double amount) {
        this.contributionId = contributionId;
        this.lender = lender;
        this.amount = amount;
    }

}
