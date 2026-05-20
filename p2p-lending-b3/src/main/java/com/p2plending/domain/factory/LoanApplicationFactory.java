package com.p2plending.domain.factory;

import com.p2plending.domain.entity.*;

public class LoanApplicationFactory {
    public static LoanApplication createApplication(Borrower borrower, double amount, int tenorMonths) {
        return new LoanApplication("APP1", borrower, amount, tenorMonths);
    }
}
