package com.example.assetfinance.ui.business;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assetfinance.Constants;
import com.example.assetfinance.R;
import com.example.assetfinance.models.Applicant;
import com.example.assetfinance.ui.BankDetailsActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessApplicantActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.idNumber) EditText idNumber;
    @BindView(R.id.pinNumber) EditText pinNumber;
    @BindView(R.id.poBox) EditText poBox;
    @BindView(R.id.physicalLocation) EditText location;
    @BindView(R.id.mobileNumber) EditText mobileNumber;
    @BindView(R.id.officeNumber) EditText officeNumber;
    @BindView(R.id.ownerTenant) EditText ownerTenant;
    @BindView(R.id.tentant) EditText tenant;
    @BindView(R.id.poBox2) EditText poBoxTwo;
    @BindView(R.id.postalCodeTwo) EditText postalCodeTwo;
    @BindView(R.id.postalCode) EditText postalCode;
    @BindView(R.id.phonenumber) EditText phoneNumber;
    @BindView(R.id.businessNature) EditText businessNature;
    @BindView(R.id.yearOfBusiness) EditText yearOfBusiness;
    @BindView(R.id.introBy) EditText introBy;
    @BindView(R.id.purpose) EditText purpose;
    @BindView(R.id.proceedOne)
    Button proceedOne;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_applicant);
        setTitle("1. APPLICANT");
        ButterKnife.bind(this);



        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        String inputBusinessName = mSharedPreferences.getString(Constants.ONE_BUSINESS_NAME, null);
        String inputBusinessIDCERT = mSharedPreferences.getString(Constants.ONE_BUSINESS_ID_CERT, null);
        String inputBusinessPin = mSharedPreferences.getString(Constants.ONE_BUSINESS_PIN, null);
        String inputBusinessPoBox = mSharedPreferences.getString(Constants.ONE_BUSINESS_PO_BOX, null);
        String inputBusinessPostalCode = mSharedPreferences.getString(Constants.ONE_BUSINESS_POSTAL_CODE, null);
        String inputBusinessLocation = mSharedPreferences.getString(Constants.ONE_BUSINESS_LOCATION, null);
        String inputBusinessNumber = mSharedPreferences.getString(Constants.ONE_BUSINESS_PHONE_NUMBER, null);
        String inputBusinessOfficeNumber = mSharedPreferences.getString(Constants.ONE_BUSINESS_OFFICE_NUMBER, null);
        String inputBusinessOwnerTenant = mSharedPreferences.getString(Constants.ONE_BUSINESS_OWNER_TENANT, null);
        String inputBusinessLandlord = mSharedPreferences.getString(Constants.ONE_BUSINESS_TENTANT_LANDLORD, null);
        String inputBusinessPoBoxLandLord = mSharedPreferences.getString(Constants.ONE_BUSINESS_PO_BOX_LANDLORD, null);
        String inputBusinessPostalCodeLandord = mSharedPreferences.getString(Constants.ONE_BUSINESS_POSTAL_CODE_LANDLORD, null);
        String inputBusinessNumberLandLord = mSharedPreferences.getString(Constants.ONE_BUSINESS_PHONE_NUMBER_LANDLORD, null);
        String inputBusinessBusiness = mSharedPreferences.getString(Constants.ONE_BUSINESS_NATURE_OF_BUSINESS, null);
        String inputBusinessYear = mSharedPreferences.getString(Constants.ONE_BUSINESS_YEAR_BUSINESS, null);
        String inputBusinessIntroBy = mSharedPreferences.getString(Constants.ONE_BUSINESS_INTRO_BY, null);
        String inputBusinessPurpose = mSharedPreferences.getString(Constants.ONE_BUSINESS_PURPOSE, null);


        Toast.makeText(this,inputBusinessName,Toast.LENGTH_SHORT).show();

        if ((inputBusinessName) != null){
            name.setText(inputBusinessName);
        }
        if ((inputBusinessIDCERT) != null){
            idNumber.setText(inputBusinessIDCERT);
        }
        if ((inputBusinessPin)!= null){
            pinNumber.setText(inputBusinessPin);
        }
        if ((inputBusinessPoBox)!= null){
            poBox.setText(inputBusinessPoBox);
        }
        if ((inputBusinessPostalCode)!= null){
            postalCode.setText(inputBusinessPostalCode);
        }
        if ((inputBusinessLocation)!= null){
            location.setText(inputBusinessLocation);
        }
        if ((inputBusinessNumber)!= null){
            mobileNumber.setText(inputBusinessNumber);
        }
        if ((inputBusinessOfficeNumber)!= null){
            officeNumber.setText(inputBusinessOfficeNumber);
        }
        if ((inputBusinessOwnerTenant)!= null){
            ownerTenant.setText(inputBusinessOwnerTenant);
        }
        if ((inputBusinessLandlord)!= null){
            tenant.setText(inputBusinessLandlord);
        }
        if ((inputBusinessPoBoxLandLord)!= null){
            poBoxTwo.setText(inputBusinessPoBoxLandLord);
        }
        if ((inputBusinessPostalCodeLandord)!= null){
            postalCodeTwo.setText(inputBusinessPostalCodeLandord);
        }
        if ((inputBusinessNumberLandLord)!= null){
            phoneNumber.setText(inputBusinessNumberLandLord);
        }
        if ((inputBusinessBusiness)!= null){
            businessNature.setText(inputBusinessBusiness);
        }
        if ((inputBusinessYear)!= null){
            yearOfBusiness.setText(inputBusinessYear);
        }
        if ((inputBusinessIntroBy)!= null){
            introBy.setText(inputBusinessIntroBy);
        }
        if ((inputBusinessPurpose)!= null){
            purpose.setText(inputBusinessPurpose);
        }




        proceedOne.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedOne){
            String inputBusinessName = name.getText().toString();
            String inputBusinessIDCERT = idNumber.getText().toString();
            String inputBusinessPin = pinNumber.getText().toString();
            String inputBusinessPoBox = poBox.getText().toString();
            String inputBusinessPostalCode = postalCode.getText().toString();
            String inputBusinessLocation = location.getText().toString();
            String inputBusinessNumber = mobileNumber.getText().toString();
            String inputBusinessOfficeNumber = officeNumber.getText().toString();
            String inputBusinessOwnerTenant = ownerTenant.getText().toString();
            String inputBusinessLandlord = tenant.getText().toString();
            String inputBusinessPoBoxLandLord = poBoxTwo.getText().toString();
            String inputBusinessPostalCodeLandord = postalCodeTwo.getText().toString();
            String inputBusinessNumberLandLord = phoneNumber.getText().toString();
            String inputBusinessBusiness = businessNature.getText().toString();
            String inputBusinessYear = yearOfBusiness.getText().toString();
            String inputBusinessIntroBy = introBy.getText().toString();
            String inputBusinessPurpose = purpose.getText().toString();

            if (
                    !(inputBusinessName).equals("") &&
                            !(inputBusinessIDCERT).equals("") &&
                            !(inputBusinessPin).equals("") &&
                            !(inputBusinessPoBox).equals("") &&
                            !(inputBusinessPostalCode).equals("") &&
                            !(inputBusinessLocation).equals("") &&
                            !(inputBusinessNumber).equals("") &&
                            !(inputBusinessOfficeNumber).equals("") &&
                            !(inputBusinessOwnerTenant).equals("") &&
                            !(inputBusinessLandlord).equals("") &&
                            !(inputBusinessPoBoxLandLord).equals("") &&
                            !(inputBusinessPostalCodeLandord).equals("") &&
                            !(inputBusinessNumberLandLord).equals("") &&
                            !(inputBusinessBusiness).equals("") &&
                            !(inputBusinessYear).equals("") &&
                            !(inputBusinessIntroBy).equals("") &&
                            !(inputBusinessPurpose).equals("")

            ){
                addToSharedPreferences(inputBusinessName, inputBusinessIDCERT, inputBusinessPin, inputBusinessPoBox, inputBusinessPostalCode,
                        inputBusinessLocation, inputBusinessNumber, inputBusinessOfficeNumber, inputBusinessOwnerTenant, inputBusinessLandlord,
                        inputBusinessPoBoxLandLord, inputBusinessPostalCodeLandord, inputBusinessNumberLandLord, inputBusinessBusiness,
                        inputBusinessYear, inputBusinessIntroBy, inputBusinessPurpose);
            }
            if (
                    (inputBusinessName).equals("") ||
                            (inputBusinessIDCERT).equals("") ||
                            (inputBusinessPin).equals("") ||
                            (inputBusinessPoBox).equals("") ||
                            (inputBusinessPostalCode).equals("") ||
                            (inputBusinessLocation).equals("") ||
                            (inputBusinessNumber).equals("") ||
                            (inputBusinessOfficeNumber).equals("") ||
                            (inputBusinessOwnerTenant).equals("") ||
                            (inputBusinessLandlord).equals("") ||
                            (inputBusinessPoBoxLandLord).equals("") ||
                            (inputBusinessPostalCodeLandord).equals("") ||
                            (inputBusinessNumberLandLord).equals("") ||
                            (inputBusinessBusiness).equals("") ||
                            (inputBusinessYear).equals("") ||
                            (inputBusinessIntroBy).equals("") ||
                            (inputBusinessPurpose).equals("")

            ){
                Toast.makeText(this,"Please fill in all details", Toast.LENGTH_LONG).show();
                return;
            }
            Applicant applicant = new Applicant(inputBusinessName,inputBusinessIDCERT,inputBusinessPin,inputBusinessPoBox,inputBusinessPostalCode,inputBusinessLocation,inputBusinessNumber,inputBusinessOfficeNumber,inputBusinessLandlord,inputBusinessPoBoxLandLord,inputBusinessPostalCode,inputBusinessNumberLandLord,inputBusinessBusiness,inputBusinessYear,inputBusinessIntroBy,inputBusinessPurpose,inputBusinessOwnerTenant);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(inputBusinessIDCERT).child("applicant_details");
            reference.setValue(applicant);

            Intent intent = new Intent(this, BusinessBankActivity.class);
            startActivity(intent);
        }
    }
    private void addToSharedPreferences(String inputBusinessName,
                                        String inputBusinessIDCERT,
                                        String inputBusinessPin,
                                        String inputBusinessPoBox,
                                        String inputBusinessPostalCode,
                                        String inputBusinessLocation,
                                        String inputBusinessNumber,
                                        String inputBusinessOfficeNumber,
                                        String inputBusinessOwnerTenant,
                                        String inputBusinessLandlord,
                                        String inputBusinessPoBoxLandLord,
                                        String inputBusinessPostalCodeLandord,
                                        String inputBusinessNumberLandLord,
                                        String inputBusinessBusiness,
                                        String inputBusinessYear,
                                        String inputBusinessIntroBy,
                                        String inputBusinessPurpose) {
        mEditor.putString(Constants.ONE_BUSINESS_NAME,inputBusinessName).apply();
        mEditor.putString(Constants.ONE_BUSINESS_ID_CERT, inputBusinessIDCERT).apply();
        mEditor.putString(Constants.ONE_BUSINESS_PIN, inputBusinessPin).apply();
        mEditor.putString(Constants.ONE_BUSINESS_PO_BOX, inputBusinessPoBox).apply();
        mEditor.putString(Constants.ONE_BUSINESS_PO_BOX_LANDLORD, inputBusinessPoBoxLandLord).apply();
        mEditor.putString(Constants.ONE_BUSINESS_POSTAL_CODE, inputBusinessPostalCode).apply();
        mEditor.putString(Constants.ONE_BUSINESS_LOCATION, inputBusinessLocation).apply();
        mEditor.putString(Constants.ONE_BUSINESS_PHONE_NUMBER, inputBusinessNumber).apply();
        mEditor.putString(Constants.ONE_BUSINESS_OFFICE_NUMBER, inputBusinessOfficeNumber).apply();
        mEditor.putString(Constants.ONE_BUSINESS_OWNER_TENANT, inputBusinessOwnerTenant).apply();
        mEditor.putString(Constants.ONE_BUSINESS_TENTANT_LANDLORD, inputBusinessLandlord).apply();
        mEditor.putString(Constants.ONE_BUSINESS_POSTAL_CODE_LANDLORD, inputBusinessPostalCodeLandord).apply();
        mEditor.putString(Constants.ONE_BUSINESS_PHONE_NUMBER_LANDLORD, inputBusinessNumberLandLord).apply();
        mEditor.putString(Constants.ONE_BUSINESS_NATURE_OF_BUSINESS, inputBusinessBusiness).apply();
        mEditor.putString(Constants.ONE_BUSINESS_YEAR_BUSINESS, inputBusinessYear).apply();
        mEditor.putString(Constants.ONE_BUSINESS_INTRO_BY, inputBusinessIntroBy).apply();
        mEditor.putString(Constants.ONE_BUSINESS_PURPOSE, inputBusinessPurpose).apply();




    }
}
