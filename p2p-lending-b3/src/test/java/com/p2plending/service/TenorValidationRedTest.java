package com.p2plending.service;

import com.p2plending.domain.entity.Borrower;
import com.p2plending.domain.entity.Loan;
import com.p2plending.domain.state.PendingState;
import com.p2plending.domain.strategy.FixedRateStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * RED TEST — Validasi Tenor Pinjaman
 *
 * Tenor yang tidak valid: selain 3, 6, atau 12 bulan
 * Hasil yang diharapkan: "Rejected"
 */
public class TenorValidationRedTest {

    private final LoanService loanService = new LoanService();

    private Loan createLoan(int tenor) {
        Borrower borrower = new Borrower("B1", "Budi", "budi@example.com", "123456789", 700, 10000000);
        Loan loan = new Loan("L1", borrower, 5000000, tenor, new FixedRateStrategy());
        loan.setState(new PendingState());
        return loan;
    }

    @Test
    public void tenor1_shouldBeRejected() {
        Loan loan = createLoan(1);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }

    @Test
    public void tenor2_shouldBeRejected() {
        Loan loan = createLoan(2);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }

    @Test
    public void tenor4_shouldBeRejected() {
        Loan loan = createLoan(4);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }

    @Test
    public void tenor5_shouldBeRejected() {
        Loan loan = createLoan(5);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }

    @Test
    public void tenor7_shouldBeRejected() {
        Loan loan = createLoan(7);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }

    @Test
    public void tenor24_shouldBeRejected() {
        Loan loan = createLoan(24);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }

    @Test
    public void tenor0_shouldBeRejected() {
        Loan loan = createLoan(0);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }

    @Test
    public void tenorNegative_shouldBeRejected() {
        Loan loan = createLoan(-1);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }
}
