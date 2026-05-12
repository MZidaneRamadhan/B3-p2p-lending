package com.p2plending.domain.state;

public class RejectedState implements LoanState {
    public String getStateName() {
        return "Rejected";
    }
}
