package com.p2plending.service;

import com.p2plending.domain.entity.Borrower;
import com.p2plending.domain.entity.Loan;
import com.p2plending.domain.state.PendingState;
import com.p2plending.domain.strategy.FixedRateStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * RED TEST — Mengajukan Pinjaman dengan Jumlah Negatif atau Nol
 *
 * Amount negatif (< 0) atau nol (0) melanggar batas minimum 1.000.000
 * Hasil yang diharapkan: "Rejected"
 */
public class NegativeAmountLoanRedTest {

    private final LoanService loanService = new LoanService();

    private Loan createLoan(double amount) {
        Borrower borrower = new Borrower("B1", "Budi", "budi@example.com", "123456789", 700, 10000000);
        Loan loan = new Loan("L1", borrower, amount, 6, new FixedRateStrategy());
        loan.setState(new PendingState());
        return loan;
    }

    @Test
    public void negativeAmount_shouldBeRejected() {
        Loan loan = createLoan(-5000000);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }

    @Test
    public void zeroAmount_shouldBeRejected() {
        Loan loan = createLoan(0);
        loanService.validateLoan(loan);
        assertEquals("Rejected", loan.getStateName());
    }
}
