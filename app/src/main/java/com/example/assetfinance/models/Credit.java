package com.example.assetfinance.models;

public class Credit {
    String name;
    String facilityType;
    String sanctionedLimit;
    String currentOutstanding;

    public Credit(String name, String facilityType, String sanctionedLimit, String currentOutstanding) {
        this.name = name;
        this.facilityType = facilityType;
        this.sanctionedLimit = sanctionedLimit;
        this.currentOutstanding = currentOutstanding;
    }

    public Credit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getSanctionedLimit() {
        return sanctionedLimit;
    }

    public void setSanctionedLimit(String sanctionedLimit) {
        this.sanctionedLimit = sanctionedLimit;
    }

    public String getCurrentOutstanding() {
        return currentOutstanding;
    }

    public void setCurrentOutstanding(String currentOutstanding) {
        this.currentOutstanding = currentOutstanding;
    }
}

