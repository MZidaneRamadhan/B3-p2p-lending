package com.p2plending.domain.strategy;

public class FixedRateStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double principal, int tenorMonths) {
        return principal * 0.10;
    }
}
