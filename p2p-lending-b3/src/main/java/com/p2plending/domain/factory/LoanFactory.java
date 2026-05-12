package com.p2plending.domain.factory;

import com.p2plending.domain.entity.*;
import com.p2plending.domain.state.PendingState;
import com.p2plending.domain.strategy.InterestStrategy;

public class LoanFactory {
    public static Loan createLoan(
            LoanApplication application,
            InterestStrategy strategy
    ) {
        Loan loan = new Loan(
                "LN1",
                application.getBorrower(),
                application.getAmount(),
                application.getTenorMonths(),
                strategy
        );

        loan.setState(new PendingState());
        return loan;
    }
}
