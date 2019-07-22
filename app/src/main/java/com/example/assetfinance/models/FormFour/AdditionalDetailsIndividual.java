package com.example.assetfinance.models.FormFour;

public class AdditionalDetailsIndividual {

    int age;
    String occupation;
    String nationality;
    String employerName;
    String address;
    int telNo;
    String currentPosition;
    int yearsInCurrentPosition;
    String maritalStatus;
    String nameOfSpouse;
    String spouseOccupation;

    int employmentIncome;
    int selfIncome;
    int spouseIncome;
    int netDisposableIncome;

    public AdditionalDetailsIndividual(int age, String occupation, String nationality, String employerName, String address, int telNo, String currentPosition, int yearsInCurrentPosition, String maritalStatus, String nameOfSpouse, String spouseOccupation, int employmentIncome, int selfIncome, int spouseIncome, int netDisposableIncome) {
        this.age = age;
        this.occupation = occupation;
        this.nationality = nationality;
        this.employerName = employerName;
        this.address = address;
        this.telNo = telNo;
        this.currentPosition = currentPosition;
        this.yearsInCurrentPosition = yearsInCurrentPosition;
        this.maritalStatus = maritalStatus;
        this.nameOfSpouse = nameOfSpouse;
        this.spouseOccupation = spouseOccupation;
        this.employmentIncome = employmentIncome;
        this.selfIncome = selfIncome;
        this.spouseIncome = spouseIncome;
        this.netDisposableIncome = netDisposableIncome;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelNo() {
        return telNo;
    }

    public void setTelNo(int telNo) {
        this.telNo = telNo;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getYearsInCurrentPosition() {
        return yearsInCurrentPosition;
    }

    public void setYearsInCurrentPosition(int yearsInCurrentPosition) {
        this.yearsInCurrentPosition = yearsInCurrentPosition;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNameOfSpouse() {
        return nameOfSpouse;
    }

    public void setNameOfSpouse(String nameOfSpouse) {
        this.nameOfSpouse = nameOfSpouse;
    }

    public String getSpouseOccupation() {
        return spouseOccupation;
    }

    public void setSpouseOccupation(String spouseOccupation) {
        this.spouseOccupation = spouseOccupation;
    }

    public int getEmploymentIncome() {
        return employmentIncome;
    }

    public void setEmploymentIncome(int employmentIncome) {
        this.employmentIncome = employmentIncome;
    }

    public int getSelfIncome() {
        return selfIncome;
    }

    public void setSelfIncome(int selfIncome) {
        this.selfIncome = selfIncome;
    }

    public int getSpouseIncome() {
        return spouseIncome;
    }

    public void setSpouseIncome(int spouseIncome) {
        this.spouseIncome = spouseIncome;
    }

    public int getNetDisposableIncome() {
        return netDisposableIncome;
    }

    public void setNetDisposableIncome(int netDisposableIncome) {
        this.netDisposableIncome = netDisposableIncome;
    }
}

