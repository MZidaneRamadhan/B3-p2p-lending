package com.p2plending.domain.entity;

public class User {
    protected String userId;
    protected String name;
    protected String email;
    protected String number;

    // Constructor utama — untuk data lengkap (userId, name, email, number)
    public User(String userId, String name, String email, String number) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.number = number;
    }

    // Constructor tambahan — untuk subclass (Borrower, Lender) yang cuma butuh userId & name
    // Email dan number diisi default string kosong
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.email = "";
        this.number = "";
    }
}
