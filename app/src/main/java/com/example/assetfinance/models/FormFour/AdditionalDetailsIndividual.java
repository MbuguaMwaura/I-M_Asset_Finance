package com.example.assetfinance.models.FormFour;

public class AdditionalDetailsIndividual {

    String age;
    String occupation;
    String nationality;
    String employerName;
    String address;
    String telNo;
    String currentPosition;
    String yearsInCurrentPosition;
    String maritalStatus;
    String nameOfSpouse;
    String spouseOccupation;
        
    String employmentIncome;
    String selfIncome;
    String spouseIncome;
    String netDisposableIncome;
    String other;
    String livingExpense;
    String currentLoanRepayments;
    String otherIncomeBusiness;

    public AdditionalDetailsIndividual(String age, String occupation, String nationality, String employerName, String address, String telNo, String currentPosition, String yearsInCurrentPosition, String maritalStatus, String nameOfSpouse, String spouseOccupation, String employmentIncome, String selfIncome, String spouseIncome, String netDisposableIncome, String other, String livingExpense, String currentLoanRepayments, String otherIncomeBusiness ) {
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
        this.other = other;
        this.livingExpense = livingExpense;
        this.currentLoanRepayments = currentLoanRepayments;
        this.otherIncomeBusiness = otherIncomeBusiness;
    }

    public String getAge() {
        return age;
    }

    public String getLivingExpense() {
        return livingExpense;
    }

    public void setLivingExpense(String livingExpense) {
        this.livingExpense = livingExpense;
    }

    public String getCurrentLoanRepayments() {
        return currentLoanRepayments;
    }

    public void setCurrentLoanRepayments(String currentLoanRepayments) {
        this.currentLoanRepayments = currentLoanRepayments;
    }

    public String getOtherIncomeBusiness() {
        return otherIncomeBusiness;
    }

    public void setOtherIncomeBusiness(String otherIncomeBusiness) {
        this.otherIncomeBusiness = otherIncomeBusiness;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public void setAge(String age) {
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

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getYearsInCurrentPosition() {
        return yearsInCurrentPosition;
    }

    public void setYearsInCurrentPosition(String yearsInCurrentPosition) {
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

    public String getEmploymentIncome() {
        return employmentIncome;
    }

    public void setEmploymentIncome(String employmentIncome) {
        this.employmentIncome = employmentIncome;
    }

    public String getSelfIncome() {
        return selfIncome;
    }

    public void setSelfIncome(String selfIncome) {
        this.selfIncome = selfIncome;
    }

    public String getSpouseIncome() {
        return spouseIncome;
    }

    public void setSpouseIncome(String spouseIncome) {
        this.spouseIncome = spouseIncome;
    }

    public String getNetDisposableIncome() {
        return netDisposableIncome;
    }

    public void setNetDisposableIncome(String netDisposableIncome) {
        this.netDisposableIncome = netDisposableIncome;
    }
}

