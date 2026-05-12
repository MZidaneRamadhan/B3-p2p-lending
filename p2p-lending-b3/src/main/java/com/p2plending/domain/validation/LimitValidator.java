package com.p2plending.domain.validation;

import com.p2plending.domain.entity.Loan;

public class LimitValidator extends Validator {
    public boolean validate(Loan loan) {
        boolean valid = loan.getAmount() >= 1000000 &&
                loan.getAmount() <= 50000000;

        return valid && (next == null || next.validate(loan));
    }
}
