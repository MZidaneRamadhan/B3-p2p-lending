package com.p2plending.domain.state;

public class FundingState implements LoanState {
    public String getStateName() {
        return "Funding";
    }
}