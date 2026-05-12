package com.p2plending.domain.state;

public class PendingState implements LoanState {
    public String getStateName() {
        return "Pending";
    }
}
