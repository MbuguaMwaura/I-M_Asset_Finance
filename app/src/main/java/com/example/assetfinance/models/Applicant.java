package com.example.assetfinance.models;

public class Applicant {
    String name;
    String idNumber;
    String pinNumber;
    String address;
    String postalCode;

    String physicalAddress;
    String mobileNumber;
    String officeNumber;
    String landLord;
    String homeaddress;
    String postalCodeAddress;
    String phoneNumber;
    String natureOfBusiness;
    String yearStartedBusiness;
    String StringroducedBy;
    String purposeOfAsset;
    String ownerTenant;

    public Applicant(String name, String idNumber, String pinNumber, String address, String postalCode, String physicalAddress, String mobileNumber, String officeNumber, String landLord, String homeaddress, String postalCodeAddress, String phoneNumber, String natureOfBusiness, String yearStartedBusiness, String StringroducedBy, String purposeOfAsset, String ownerTenant) {
        this.name = name;
        this.idNumber = idNumber;
        this.pinNumber = pinNumber;
        this.address = address;
        this.postalCode = postalCode;
        this.physicalAddress = physicalAddress;
        this.mobileNumber = mobileNumber;
        this.officeNumber = officeNumber;
        this.landLord = landLord;
        this.homeaddress = homeaddress;
        this.postalCodeAddress = postalCodeAddress;
        this.phoneNumber = phoneNumber;
        this.natureOfBusiness = natureOfBusiness;
        this.yearStartedBusiness = yearStartedBusiness;
        this.StringroducedBy = StringroducedBy;
        this.purposeOfAsset = purposeOfAsset;
        this.ownerTenant = ownerTenant;
    }

    public Applicant() {
    }

    public String getOwnerTenant() {
        return ownerTenant;
    }

    public void setOwnerTenant(String ownerTenant) {
        this.ownerTenant = ownerTenant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getLandLord() {
        return landLord;
    }

    public void setLandLord(String landLord) {
        this.landLord = landLord;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getPostalCodeAddress() {
        return postalCodeAddress;
    }

    public void setPostalCodeAddress(String postalCodeAddress) {
        this.postalCodeAddress = postalCodeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public String getYearStartedBusiness() {
        return yearStartedBusiness;
    }

    public void setYearStartedBusiness(String yearStartedBusiness) {
        this.yearStartedBusiness = yearStartedBusiness;
    }

    public String getIntroducedBy() {
        return StringroducedBy;
    }

    public void setIntroducedBy(String StringroducedBy) {
        this.StringroducedBy = StringroducedBy;
    }

    public String getPurposeOfAsset() {
        return purposeOfAsset;
    }

    public void setPurposeOfAsset(String purposeOfAsset) {
        this.purposeOfAsset = purposeOfAsset;
    }
}
