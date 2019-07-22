package com.example.assetfinance.models.FormFour;

public class Expense {
    int livingExpense;
    int currentLoanRepayments;

    public Expense(int livingExpense, int currentLoanRepayments) {
        this.livingExpense = livingExpense;
        this.currentLoanRepayments = currentLoanRepayments;
    }

    public int getLivingExpense() {
        return livingExpense;
    }

    public void setLivingExpense(int livingExpense) {
        this.livingExpense = livingExpense;
    }

    public int getCurrentLoanRepayments() {
        return currentLoanRepayments;
    }

    public void setCurrentLoanRepayments(int currentLoanRepayments) {
        this.currentLoanRepayments = currentLoanRepayments;
    }
}
