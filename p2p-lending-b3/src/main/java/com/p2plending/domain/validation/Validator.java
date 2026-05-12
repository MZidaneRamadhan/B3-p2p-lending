package com.p2plending.domain.validation;

import com.p2plending.domain.entity.Loan;

public abstract class Validator {
    protected Validator next;

    public void setNext(Validator next) {
        this.next = next;
    }

    public abstract boolean validate(Loan loan);
}
