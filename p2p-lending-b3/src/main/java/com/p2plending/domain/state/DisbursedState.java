package com.p2plending.domain.state;

public class DisbursedState implements LoanState {
    public String getStateName() {
        return "Disbursed";
    }
}
