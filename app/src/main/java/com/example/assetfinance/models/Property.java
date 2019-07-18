package com.example.assetfinance.models;

public class Property {
    String property;
    String size;
    String location;
    String lrNo;
    String approxValue;

    public Property(String property, String size, String location, String lrNo, String approxValue) {
        this.property = property;
        this.size = size;
        this.location = location;
        this.lrNo = lrNo;
        this.approxValue = approxValue;
    }

    public Property() {
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLrNo() {
        return lrNo;
    }

    public void setLrNo(String lrNo) {
        this.lrNo = lrNo;
    }

    public String getApproxValue() {
        return approxValue;
    }

    public void setApproxValue(String approxValue) {
        this.approxValue = approxValue;
    }
}
