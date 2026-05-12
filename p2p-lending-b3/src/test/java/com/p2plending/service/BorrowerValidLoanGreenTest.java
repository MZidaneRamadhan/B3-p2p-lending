package com.p2plending.service;

import com.p2plending.domain.entity.Borrower;
import com.p2plending.domain.entity.Loan;
import com.p2plending.domain.state.PendingState;
import com.p2plending.domain.strategy.FixedRateStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * GREEN TEST — Borrower Mengajukan Pinjaman Valid
 *
 * Semua aturan terpenuhi:
 *   1. Amount: 1.000.000 <= amount <= 50.000.000
 *   2. Credit score: >= 650
 *   3. Tenor: 3, 6, atau 12 bulan
 *
 * Hasil yang diharapkan: "Validated"
 */
public class BorrowerValidLoanGreenTest {

    private final LoanService loanService = new LoanService();

    private Loan createLoan(double amount, int creditScore, int tenor) {
        Borrower borrower = new Borrower("B1", "Budi", creditScore, 10000000);
        Loan loan = new Loan("L1", borrower, amount, tenor, new FixedRateStrategy());
        loan.setState(new PendingState());
        return loan;
    }

    @Test
    public void allRulesMet_shouldBeValidated() {
        Loan loan = createLoan(5000000, 700, 6);
        loanService.validateLoan(loan);
        assertEquals("Validated", loan.getStateName());
    }
}
