package com.example.assetfinance.models;

public class Supplier {
    String dealerName;
    String postalAddress;
    int telephoneNumber;
    String invoiceNoDate;
    String salesPerson;

    public Supplier(String dealerName, String postalAddress, int telephoneNumber, String invoiceNoDate, String salesPerson) {
        this.dealerName = dealerName;
        this.postalAddress = postalAddress;
        this.telephoneNumber = telephoneNumber;
        this.invoiceNoDate = invoiceNoDate;
        this.salesPerson = salesPerson;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getInvoiceNoDate() {
        return invoiceNoDate;
    }

    public void setInvoiceNoDate(String invoiceNoDate) {
        this.invoiceNoDate = invoiceNoDate;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }
}
