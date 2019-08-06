package com.example.assetfinance.models.FormSeven;

public class AssetDetails {
    String make;
    String modelCc;
    String yearOfManufacture;
    String valuationAmount;
    String assetState;
    String insuranceOption;
    String invoicePrice;
    String discounts;
    String netCost;
    String deposit;
    String balanceOfCost;
    String accessories;
    String accessoriesValue;
    String totalCost;

    public AssetDetails(String make, String modelCc, String yearOfManufacture, String valuationAmount,
                        String assetState, String insuranceOption, String invoicePrice, String discounts,
                        String netCost, String deposit, String balanceOfCost, String accessories, String accessoriesValue, String totalCost) {
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
        this.accessories = accessories;
        this.accessoriesValue = accessoriesValue;
        this.totalCost = totalCost;
    }


    public AssetDetails() {
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getAccessoriesValue() {
        return accessoriesValue;
    }

    public void setAccessoriesValue(String accessoriesValue) {
        this.accessoriesValue = accessoriesValue;
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

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getValuationAmount() {
        return valuationAmount;
    }

    public void setValuationAmount(String valuationAmount) {
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

    public String getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(String invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getDiscounts() {
        return discounts;
    }

    public void setDiscounts(String discounts) {
        this.discounts = discounts;
    }

    public String getNetCost() {
        return netCost;
    }

    public void setNetCost(String netCost) {
        this.netCost = netCost;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getBalanceOfCost() {
        return balanceOfCost;
    }

    public void setBalanceOfCost(String balanceOfCost) {
        this.balanceOfCost = balanceOfCost;
    }
}
