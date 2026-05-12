package com.p2plending.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Borrower extends User {
    private int creditScore;
    private double loanLimit;

    public Borrower(String userId, String name, int creditScore, double loanLimit) {
        super(userId, name);
        this.creditScore = creditScore;
        this.loanLimit = loanLimit;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getLoanLimit() {
        return loanLimit;
    }

}

// public class Borrower {

//     private String borrowerId;
//     private String name;
//     private String email;
//     private int creditScore;
//     private BigDecimal loanLimit;
//     private boolean isVerified;
//     private List<LoanApplication> activeLoans;

//     public Borrower(String borrowerId, String name, String email, int creditScore, BigDecimal loanLimit) {
//         if (borrowerId == null || borrowerId.isBlank()) throw new IllegalArgumentException("borrowerId tidak boleh kosong");
//         if (name == null || name.isBlank()) throw new IllegalArgumentException("nama tidak boleh kosong");
//         if (email == null || !email.contains("@")) throw new IllegalArgumentException("email tidak valid");
//         if (creditScore < 0 || creditScore > 1000) throw new IllegalArgumentException("creditScore harus antara 0-1000");
//         if (loanLimit == null || loanLimit.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("loanLimit harus lebih dari 0");

//         this.borrowerId = borrowerId;
//         this.name = name;
//         this.email = email;
//         this.creditScore = creditScore;
//         this.loanLimit = loanLimit;
//         this.isVerified = false; 
//         this.activeLoans = new ArrayList<>();
//     }

//     public boolean validateLoanLimit(BigDecimal requestedAmount) {
//         if (requestedAmount == null || requestedAmount.compareTo(BigDecimal.ZERO) <= 0) {
//             throw new IllegalArgumentException("jumlah pinjaman harus lebih dari 0");
//         }
//         return getRemainingLimit().compareTo(requestedAmount) >= 0;
//     }

//     public BigDecimal getRemainingLimit() {
//         BigDecimal totalActive = activeLoans.stream()
//                 .map(LoanApplication::getAmount)
//                 .reduce(BigDecimal.ZERO, BigDecimal::add);
//         return loanLimit.subtract(totalActive);
//     }

//     public void addActiveLoan(LoanApplication loanApplication) {
//         if (loanApplication == null)
//             throw new IllegalArgumentException("loanApplication tidak boleh null");
//         if (!this.borrowerId.equals(loanApplication.getBorrower().getBorrowerId())) {
//             throw new IllegalArgumentException("loan ini bukan milik borrower ini");
//         }
//         this.activeLoans.add(loanApplication);
//     }

//     public void removeLoan(LoanApplication loanApplication) {
//         this.activeLoans.remove(loanApplication);
//     }
    
//     public void verify() {
//         this.isVerified = true;
//     }

//     public boolean isEligibleToApply() {
//         return this.isVerified && creditScore >= 300;
//     }
// }   