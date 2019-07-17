package com.example.assetfinance.models;

public class Applicant {
    String name;
    int idNumber;
    String pinNumber;
    String address;
    int postalCode;
    String town;
    String physicalAddress;
    int mobileNumber;
    int officeNumber;
    String landLord;
    String homeaddress;
    int postalCodeAddress;
    int phoneNumber;
    String natureOfBusiness;
    int yearStartedBusiness;
    String introducedBy;
    String purposeOfAsset;

    public Applicant(String name, int idNumber, String pinNumber, String address, int postalCode, String town, String physicalAddress, int mobileNumber, int officeNumber, String landLord, String homeaddress, int postalCodeAddress, int phoneNumber, String natureOfBusiness, int yearStartedBusiness, String introducedBy, String purposeOfAsset) {
        this.name = name;
        this.idNumber = idNumber;
        this.pinNumber = pinNumber;
        this.address = address;
        this.postalCode = postalCode;
        this.town = town;
        this.physicalAddress = physicalAddress;
        this.mobileNumber = mobileNumber;
        this.officeNumber = officeNumber;
        this.landLord = landLord;
        this.homeaddress = homeaddress;
        this.postalCodeAddress = postalCodeAddress;
        this.phoneNumber = phoneNumber;
        this.natureOfBusiness = natureOfBusiness;
        this.yearStartedBusiness = yearStartedBusiness;
        this.introducedBy = introducedBy;
        this.purposeOfAsset = purposeOfAsset;
    }

    public Applicant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
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

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
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

    public int getPostalCodeAddress() {
        return postalCodeAddress;
    }

    public void setPostalCodeAddress(int postalCodeAddress) {
        this.postalCodeAddress = postalCodeAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public int getYearStartedBusiness() {
        return yearStartedBusiness;
    }

    public void setYearStartedBusiness(int yearStartedBusiness) {
        this.yearStartedBusiness = yearStartedBusiness;
    }

    public String getIntroducedBy() {
        return introducedBy;
    }

    public void setIntroducedBy(String introducedBy) {
        this.introducedBy = introducedBy;
    }

    public String getPurposeOfAsset() {
        return purposeOfAsset;
    }

    public void setPurposeOfAsset(String purposeOfAsset) {
        this.purposeOfAsset = purposeOfAsset;
    }
}
