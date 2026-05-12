package com.p2plending.domain.entity;

public class LoanApplication {
    private String applicationId;
    private Borrower borrower;
    private double amount;
    private int tenorMonths;

    public LoanApplication(String applicationId, Borrower borrower,
            double amount, int tenorMonths) {
        this.applicationId = applicationId;
        this.borrower = borrower;
        this.amount = amount;
        this.tenorMonths = tenorMonths;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public double getAmount() {
        return amount;
    }

    public int getTenorMonths() {
        return tenorMonths;
    }
}
