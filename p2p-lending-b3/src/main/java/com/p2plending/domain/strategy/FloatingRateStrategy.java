package com.p2plending.domain.strategy;

public class FloatingRateStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double principal, int tenorMonths) {
        return principal * 0.10;

    }}
