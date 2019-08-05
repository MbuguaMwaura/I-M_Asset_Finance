package com.example.assetfinance.models;

public class BankDetails {
    String bankName;
    String branch;
    String accountNumber;
    String odLimit;
    String outStandingLoans;

    public BankDetails(String bankName, String branch, String accountNumber, String odLimit, String outStandingLoans) {
        this.bankName = bankName;
        this.branch = branch;
        this.accountNumber = accountNumber;
        this.odLimit = odLimit;
        this.outStandingLoans = outStandingLoans;
    }

    public BankDetails() {
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOdLimit() {
        return odLimit;
    }

    public void setOdLimit(String odLimit) {
        this.odLimit = odLimit;
    }

    public String getOutStandingLoans() {
        return outStandingLoans;
    }

    public void setOutStandingLoans(String outStandingLoans) {
        this.outStandingLoans = outStandingLoans;
    }
}
