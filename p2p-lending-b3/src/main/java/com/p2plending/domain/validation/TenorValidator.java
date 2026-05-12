package com.p2plending.domain.validation;

import com.p2plending.domain.entity.Loan;

public class TenorValidator extends Validator {
    public boolean validate(Loan loan) {
        int tenor = loan.getTenorMonths();
        boolean valid = tenor == 3 || tenor == 6 || tenor == 12;
        return valid;
    }
}
