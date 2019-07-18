package com.example.assetfinance.models;

public class Vehicle {
    String regNo;
    String make;
    String model;
    String balanceLoan;
    String financedBy;

    public Vehicle(String regNo, String make, String model, String balanceLoan, String financedBy) {
        this.regNo = regNo;
        this.make = make;
        this.model = model;
        this.balanceLoan = balanceLoan;
        this.financedBy = financedBy;
    }

    public Vehicle() {
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBalanceLoan() {
        return balanceLoan;
    }

    public void setBalanceLoan(String balanceLoan) {
        this.balanceLoan = balanceLoan;
    }

    public String getFinancedBy() {
        return financedBy;
    }

    public void setFinancedBy(String financedBy) {
        this.financedBy = financedBy;
    }
}
