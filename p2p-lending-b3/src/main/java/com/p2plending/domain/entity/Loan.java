package com.p2plending.domain.entity;

import com.p2plending.domain.state.LoanState;
import com.p2plending.domain.strategy.InterestStrategy;

public class Loan {
    private String loanId;
    private Borrower borrower;
    private double amount;
    private int tenorMonths;
    private double fundedAmount;
    private LoanState currentState;
    private InterestStrategy strategy;

    public Loan(String loanId, Borrower borrower, double amount, int tenorMonths, InterestStrategy strategy) {
        this.loanId = loanId;
        this.borrower = borrower;
        this.amount = amount;
        this.tenorMonths = tenorMonths;
        this.strategy = strategy;
        this.fundedAmount = 0;
    }

    public double getAmount() {
        return amount;
    }

    public int getTenorMonths() {
        return tenorMonths;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public double getFundedAmount() {
        return fundedAmount;
    }

    public void addFunding(double amount) {
        fundedAmount += amount;
    }

    public void setState(LoanState state) {
        this.currentState = state;
        System.out.println("Loan state changed to: " + state.getStateName());
    }

    // Getter untuk ngecek state dari test (LoanServiceTest, dll)
    // Mengembalikan nama state saat ini: "Pending", "Validated", "Rejected", dll.
    public String getStateName() {
        if (currentState == null) {
            return null;
        }
        return currentState.getStateName();
    }

}
