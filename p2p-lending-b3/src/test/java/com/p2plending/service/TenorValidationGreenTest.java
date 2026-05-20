package com.p2plending.service;

import com.p2plending.domain.entity.Borrower;
import com.p2plending.domain.entity.Loan;
import com.p2plending.domain.state.PendingState;
import com.p2plending.domain.strategy.FixedRateStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * GREEN TEST — Validasi Tenor Pinjaman
 *
 * Tenor yang valid: 3, 6, atau 12 bulan
 * Hasil yang diharapkan: "Validated"
 */
public class TenorValidationGreenTest {

    private final LoanService loanService = new LoanService();

    private Loan createLoan(int tenor) {
        Borrower borrower = new Borrower("B1", "Budi", "budi@example.com", "123456789", 700, 10000000);
        Loan loan = new Loan("L1", borrower, 5000000, tenor, new FixedRateStrategy());
        loan.setState(new PendingState());
        return loan;
    }

    @Test
    public void tenor3_shouldBeValidated() {
        Loan loan = createLoan(3);
        loanService.validateLoan(loan);
        assertEquals("Validated", loan.getStateName());
    }

    @Test
    public void tenor6_shouldBeValidated() {
        Loan loan = createLoan(6);
        loanService.validateLoan(loan);
        assertEquals("Validated", loan.getStateName());
    }

    @Test
    public void tenor12_shouldBeValidated() {
        Loan loan = createLoan(12);
        loanService.validateLoan(loan);
        assertEquals("Validated", loan.getStateName());
    }
}
