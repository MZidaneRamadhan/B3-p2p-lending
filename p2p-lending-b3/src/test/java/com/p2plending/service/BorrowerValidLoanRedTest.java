package com.p2plending.service;

import com.p2plending.domain.entity.Borrower;
import com.p2plending.domain.entity.Loan;
import com.p2plending.domain.state.PendingState;
import com.p2plending.domain.strategy.FixedRateStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * RED TEST Borrower Mengajukan Pinjaman Valid
 * Satu atau lebih aturan dilanggar:
 * 1. Amount < 1.000.000 atau > 50.000.000
 * 2. Credit score < 650
 * 3. Tenor bukan 3, 6, atau 12
 * Hasil yang diharapkan: "Rejected"
 */
public class BorrowerValidLoanRedTest {

    private final LoanService loanService = new LoanService();

    private Loan createLoan(double amount, int creditScore, int tenor) {
        Borrower borrower = new Borrower("B1", "Budi", creditScore, 10000000);
        Loan loan = new Loan("L1", borrower, amount, tenor, new FixedRateStrategy());
        loan.setState(new PendingState());
        return loan;
    }

    @Test
    public void amountBelowMinimum_shouldBeRejected() {
        Loan loan = createLoan(500000, 700, 6);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }

    @Test
    public void amountAboveMaximum_shouldBeRejected() {
        Loan loan = createLoan(100000000, 700, 6);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }

    @Test
    public void lowCreditScore_shouldBeRejected() {
        Loan loan = createLoan(5000000, 500, 6);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }

    @Test
    public void invalidTenor_shouldBeRejected() {
        Loan loan = createLoan(5000000, 700, 24);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }
}
