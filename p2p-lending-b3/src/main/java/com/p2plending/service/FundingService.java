package com.p2plending.service;

import com.p2plending.domain.entity.*;
import com.p2plending.domain.state.DisbursedState;

public class FundingService {

    public void contribute(Loan loan, Lender lender, double amount) {
        loan.addFunding(amount);

        System.out.println("Funding progress: " +
                loan.getFundedAmount() + "/" + loan.getAmount());

        if (loan.getFundedAmount() >= loan.getAmount()) {
            System.out.println("Funding completed");
            loan.setState(new DisbursedState());
        }
    }
}

