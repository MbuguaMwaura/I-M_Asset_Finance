package com.example.assetfinance.models.FormFour;

public class Income {
     int otherIncomeBusiness;
     int other;

    public Income(int otherIncomeBusiness, int other) {
        this.otherIncomeBusiness = otherIncomeBusiness;
        this.other = other;
    }

    public int getOtherIncomeBusiness() {
        return otherIncomeBusiness;
    }

    public void setOtherIncomeBusiness(int otherIncomeBusiness) {
        this.otherIncomeBusiness = otherIncomeBusiness;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }
}
