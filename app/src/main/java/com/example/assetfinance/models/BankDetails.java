package com.example.assetfinance.models;


import org.parceler.Parcel;

@Parcel
public class BankDetails {
    String bankName;
    String branch;
    String accountNumber;
    String odLimit;
    String outStandingLoans;
    private String pushId;
    String index;

    public BankDetails() {
    }
    public BankDetails(String bankName, String branch, String accountNumber, String odLimit, String outStandingLoans) {
        this.bankName = bankName;
        this.branch = branch;
        this.accountNumber = accountNumber;
        this.odLimit = odLimit;
        this.outStandingLoans = outStandingLoans;
        this.index = "not_specified";
    }


    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
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
