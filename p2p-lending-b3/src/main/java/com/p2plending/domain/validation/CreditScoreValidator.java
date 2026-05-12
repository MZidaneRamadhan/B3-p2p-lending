package com.p2plending.domain.validation;

import com.p2plending.domain.entity.Loan;

public class CreditScoreValidator extends Validator {
    public boolean validate(Loan loan) {
        boolean valid = loan.getBorrower().getCreditScore() >= 650;
        return valid && (next == null || next.validate(loan));
    }
}
