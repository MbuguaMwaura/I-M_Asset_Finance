package com.example.assetfinance.models.FormSeven;

public class AssetDetail {
    String make;
    String modelCc;
    int yearOfManufacture;
    int valuationAmount;
    String assetState;
    String insuranceOption;
    int invoicePrice;
    int discounts;
    int netCost;
    int deposit;
    int balanceOfCost;

    public AssetDetail(String make, String modelCc, int yearOfManufacture, int valuationAmount, String assetState, String insuranceOption, int invoicePrice, int discounts, int netCost, int deposit, int balanceOfCost) {
        this.make = make;
        this.modelCc = modelCc;
        this.yearOfManufacture = yearOfManufacture;
        this.valuationAmount = valuationAmount;
        this.assetState = assetState;
        this.insuranceOption = insuranceOption;
        this.invoicePrice = invoicePrice;
        this.discounts = discounts;
        this.netCost = netCost;
        this.deposit = deposit;
        this.balanceOfCost = balanceOfCost;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModelCc() {
        return modelCc;
    }

    public void setModelCc(String modelCc) {
        this.modelCc = modelCc;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getValuationAmount() {
        return valuationAmount;
    }

    public void setValuationAmount(int valuationAmount) {
        this.valuationAmount = valuationAmount;
    }

    public String getAssetState() {
        return assetState;
    }

    public void setAssetState(String assetState) {
        this.assetState = assetState;
    }

    public String getInsuranceOption() {
        return insuranceOption;
    }

    public void setInsuranceOption(String insuranceOption) {
        this.insuranceOption = insuranceOption;
    }

    public int getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(int invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public int getDiscounts() {
        return discounts;
    }

    public void setDiscounts(int discounts) {
        this.discounts = discounts;
    }

    public int getNetCost() {
        return netCost;
    }

    public void setNetCost(int netCost) {
        this.netCost = netCost;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getBalanceOfCost() {
        return balanceOfCost;
    }

    public void setBalanceOfCost(int balanceOfCost) {
        this.balanceOfCost = balanceOfCost;
    }
}
