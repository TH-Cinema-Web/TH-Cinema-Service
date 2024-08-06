package com.example.casem3.model;

public class Customer {
    private String phoneNumber;
    private String fullName;
    private String email;
    private String userName;

    public Customer() {
    }

    public Customer(String phoneNumber, String fullName, String email, String userName) {
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.email = email;
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
