package com.p2plending.service;

import com.p2plending.domain.entity.Loan;
import com.p2plending.domain.state.*;
import com.p2plending.domain.validation.*;

public class LoanService {

    public void validateLoan(Loan loan) {
        Validator limit = new LimitValidator();
        Validator credit = new CreditScoreValidator();
        Validator tenor = new TenorValidator();

        limit.setNext(credit);
        credit.setNext(tenor);

        if (limit.validate(loan)) {
            loan.setState(new ValidatedState());
        } else {
            loan.setState(new RejectedState());
        }
    }

    public void openFunding(Loan loan) {
        loan.setState(new FundingState());
    }
}

