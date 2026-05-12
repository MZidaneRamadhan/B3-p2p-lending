package com.p2plending.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class FundingPool {
    private List<FundingContribution> contributions = new ArrayList<>();

    public void addContribution(FundingContribution contribution) {
        contributions.add(contribution);
    }
}

