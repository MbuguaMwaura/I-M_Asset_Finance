package com.example.assetfinance.models.FormFive;

public class AdditionalInfoCompany {
    String shareholders;
    String annualTurnover;
    String annualNetProfit;
    String companies;

    public AdditionalInfoCompany(String shareholders,String annualTurnover, String annualNetProfit, String companies) {
        this.shareholders = shareholders;
        this.annualTurnover = annualTurnover;
        this.annualNetProfit = annualNetProfit;
        this.companies = companies;
    }

    public AdditionalInfoCompany() {
    }

    public String getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(String annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public String getAnnualNetProfit() {
        return annualNetProfit;
    }

    public void setAnnualNetProfit(String annualNetProfit) {
        this.annualNetProfit = annualNetProfit;
    }
}
