package com.example.assetfinance.models.FormFive;

public class AdditionalInfoCompany {
    int annualTurnover;
    int annualNetProfit;

    public AdditionalInfoCompany(int annualTurnover, int annualNetProfit) {
        this.annualTurnover = annualTurnover;
        this.annualNetProfit = annualNetProfit;
    }

    public int getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(int annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public int getAnnualNetProfit() {
        return annualNetProfit;
    }

    public void setAnnualNetProfit(int annualNetProfit) {
        this.annualNetProfit = annualNetProfit;
    }
}
