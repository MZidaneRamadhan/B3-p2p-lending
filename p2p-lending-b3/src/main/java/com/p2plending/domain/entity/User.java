package com.p2plending.domain.entity;

public class User {
    protected String userId;
    protected String name;
    protected String email;
    protected String number;

    public User(String userId, String name, String email,String number) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.number = number;
    }
}
