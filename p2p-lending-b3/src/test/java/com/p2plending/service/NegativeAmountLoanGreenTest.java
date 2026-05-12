package com.p2plending.service;

import com.p2plending.domain.entity.Borrower;
import com.p2plending.domain.entity.Loan;
import com.p2plending.domain.state.PendingState;
import com.p2plending.domain.strategy.FixedRateStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * GREEN TEST — Mengajukan Pinjaman dengan Jumlah Positif
 *
 * Amount positif dalam batas 1.000.000 <= amount <= 50.000.000
 * Hasil yang diharapkan: "Validated"
 */
public class NegativeAmountLoanGreenTest {

    private final LoanService loanService = new LoanService();

    @Test
    public void positiveAmount_shouldBeValidated() {
        Borrower borrower = new Borrower("B1", "Budi", 700, 10000000);
        Loan loan = new Loan("L1", borrower, 5000000, 6, new FixedRateStrategy());
        loan.setState(new PendingState());

        loanService.validateLoan(loan);

        assertEquals("Validated", loan.getStateName());
    }
}
