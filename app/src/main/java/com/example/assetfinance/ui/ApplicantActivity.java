package com.example.assetfinance.ui;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApplicantActivity extends AppCompatActivity implements View.OnClickListener {
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
        setContentView(R.layout.activity_applicant);
        setTitle("1. APPLICANT");
        ButterKnife.bind(this);



        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        String inputName = mSharedPreferences.getString(Constants.ONE_NAME, null);
        String inputIDCERT = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
        String inputPin = mSharedPreferences.getString(Constants.ONE_PIN, null);
        String inputPoBox = mSharedPreferences.getString(Constants.ONE_PO_BOX, null);
        String inputPostalCode = mSharedPreferences.getString(Constants.ONE_POSTAL_CODE, null);
        String inputLocation = mSharedPreferences.getString(Constants.ONE_LOCATION, null);
        String inputNumber = mSharedPreferences.getString(Constants.ONE_PHONE_NUMBER, null);
        String inputOfficeNumber = mSharedPreferences.getString(Constants.ONE_OFFICE_NUMBER, null);
        String inputOwnerTenant = mSharedPreferences.getString(Constants.ONE_OWNER_TENANT, null);
        String inputLandlord = mSharedPreferences.getString(Constants.ONE_TENTANT_LANDLORD, null);
        String inputPoBoxLandLord = mSharedPreferences.getString(Constants.ONE_PO_BOX_LANDLORD, null);
        String inputPostalCodeLandord = mSharedPreferences.getString(Constants.ONE_POSTAL_CODE_LANDLORD, null);
        String inputNumberLandLord = mSharedPreferences.getString(Constants.ONE_PHONE_NUMBER_LANDLORD, null);
        String inputBusiness = mSharedPreferences.getString(Constants.ONE_NATURE_OF_BUSINESS, null);
        String inputYear = mSharedPreferences.getString(Constants.ONE_YEAR_BUSINESS, null);
        String inputIntroBy = mSharedPreferences.getString(Constants.ONE_INTRO_BY, null);
        String inputPurpose = mSharedPreferences.getString(Constants.ONE_PURPOSE, null);




        if ((inputName) != null){
            name.setText(inputName);
        }
        if ((inputIDCERT) != null){
            idNumber.setText(inputIDCERT);
        }
        if ((inputPin)!= null){
            pinNumber.setText(inputPin);
        }
        if ((inputPoBox)!= null){
            poBox.setText(inputPoBox);
        }
        if ((inputPostalCode)!= null){
            postalCode.setText(inputPostalCode);
        }
        if ((inputLocation)!= null){
            location.setText(inputLocation);
        }
        if ((inputNumber)!= null){
            mobileNumber.setText(inputNumber);
        }
        if ((inputOfficeNumber)!= null){
            officeNumber.setText(inputOfficeNumber);
        }
        if ((inputOwnerTenant)!= null){
            ownerTenant.setText(inputOwnerTenant);
        }
        if ((inputLandlord)!= null){
            tenant.setText(inputLandlord);
        }
        if ((inputPoBoxLandLord)!= null){
            poBoxTwo.setText(inputPoBoxLandLord);
        }
        if ((inputPostalCodeLandord)!= null){
            postalCodeTwo.setText(inputPostalCodeLandord);
        }
        if ((inputNumberLandLord)!= null){
            phoneNumber.setText(inputNumberLandLord);
        }
        if ((inputBusiness)!= null){
            businessNature.setText(inputBusiness);
        }
        if ((inputYear)!= null){
            yearOfBusiness.setText(inputYear);
        }
        if ((inputIntroBy)!= null){
            introBy.setText(inputIntroBy);
        }
        if ((inputPurpose)!= null){
            purpose.setText(inputPurpose);
        }




        proceedOne.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedOne){
            String inputName = name.getText().toString();
            String inputIDCERT = idNumber.getText().toString();
            String inputPin = pinNumber.getText().toString();
            String inputPoBox = poBox.getText().toString();
            String inputPostalCode = postalCode.getText().toString();
            String inputLocation = location.getText().toString();
            String inputNumber = mobileNumber.getText().toString();
            String inputOfficeNumber = officeNumber.getText().toString();
            String inputOwnerTenant = ownerTenant.getText().toString();
            String inputLandlord = tenant.getText().toString();
            String inputPoBoxLandLord = poBoxTwo.getText().toString();
            String inputPostalCodeLandord = postalCodeTwo.getText().toString();
            String inputNumberLandLord = phoneNumber.getText().toString();
            String inputBusiness = businessNature.getText().toString();
            String inputYear = yearOfBusiness.getText().toString();
            String inputIntroBy = introBy.getText().toString();
            String inputPurpose = purpose.getText().toString();

            if (
                    !(inputName).equals("") &&
                            !(inputIDCERT).equals("") &&
                            !(inputPin).equals("") &&
                            !(inputPoBox).equals("") &&
                            !(inputPostalCode).equals("") &&
                            !(inputLocation).equals("") &&
                            !(inputNumber).equals("") &&
                            !(inputOfficeNumber).equals("") &&
                            !(inputOwnerTenant).equals("") &&
                            !(inputLandlord).equals("") &&
                            !(inputPoBoxLandLord).equals("") &&
                            !(inputPostalCodeLandord).equals("") &&
                            !(inputNumberLandLord).equals("") &&
                            !(inputBusiness).equals("") &&
                            !(inputYear).equals("") &&
                            !(inputIntroBy).equals("") &&
                            !(inputPurpose).equals("")

            ){
                addToSharedPreferences(inputName, inputIDCERT, inputPin, inputPoBox, inputPostalCode,
                       inputLocation, inputNumber, inputOfficeNumber, inputOwnerTenant, inputLandlord,
                        inputPoBoxLandLord, inputPostalCodeLandord, inputNumberLandLord, inputBusiness,
                        inputYear, inputIntroBy, inputPurpose);
            }
            if (
                    (inputName).equals("") ||
                            (inputIDCERT).equals("") ||
                            (inputPin).equals("") ||
                            (inputPoBox).equals("") ||
                            (inputPostalCode).equals("") ||
                            (inputLocation).equals("") ||
                            (inputNumber).equals("") ||
                            (inputOfficeNumber).equals("") ||
                            (inputOwnerTenant).equals("") ||
                            (inputLandlord).equals("") ||
                            (inputPoBoxLandLord).equals("") ||
                            (inputPostalCodeLandord).equals("") ||
                            (inputNumberLandLord).equals("") ||
                            (inputBusiness).equals("") ||
                            (inputYear).equals("") ||
                            (inputIntroBy).equals("") ||
                            (inputPurpose).equals("")

            ){
                Toast.makeText(this,"Please fill in all details", Toast.LENGTH_LONG).show();
                return;
            }
            Applicant applicant = new Applicant(inputName,inputIDCERT,inputPin,inputPoBox,inputPostalCode,inputLocation,inputNumber,inputOfficeNumber,inputLandlord,inputPoBoxLandLord,inputPostalCode,inputNumberLandLord,inputBusiness,inputYear,inputIntroBy,inputPurpose,inputOwnerTenant);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(inputIDCERT).child("applicant_details");
            reference.setValue(applicant);



            Intent intent = new Intent(this,BankDetailsActivity.class);
            intent.putExtra("User",inputName);
            startActivity(intent);
        }
    }
    private void addToSharedPreferences(String inputName,
                                        String inputIDCERT,
                                        String inputPin,
                                        String inputPoBox,
                                        String inputPostalCode,
                                        String inputLocation,
                                        String inputNumber,
                                        String inputOfficeNumber,
                                        String inputOwnerTenant,
                                        String inputLandlord,
                                        String inputPoBoxLandLord,
                                        String inputPostalCodeLandord,
                                        String inputNumberLandLord,
                                        String inputBusiness,
                                        String inputYear,
                                        String inputIntroBy,
                                        String inputPurpose) {
        mEditor.putString(Constants.ONE_NAME,inputName).apply();
        mEditor.putString(Constants.ONE_ID_CERT, inputIDCERT).apply();
        mEditor.putString(Constants.ONE_PIN, inputPin).apply();
        mEditor.putString(Constants.ONE_PO_BOX, inputPoBox).apply();
        mEditor.putString(Constants.ONE_PO_BOX_LANDLORD, inputPoBoxLandLord).apply();
        mEditor.putString(Constants.ONE_POSTAL_CODE, inputPostalCode).apply();
        mEditor.putString(Constants.ONE_LOCATION, inputLocation).apply();
        mEditor.putString(Constants.ONE_PHONE_NUMBER, inputNumber).apply();
        mEditor.putString(Constants.ONE_OFFICE_NUMBER, inputOfficeNumber).apply();
        mEditor.putString(Constants.ONE_OWNER_TENANT, inputOwnerTenant).apply();
        mEditor.putString(Constants.ONE_TENTANT_LANDLORD, inputLandlord).apply();
        mEditor.putString(Constants.ONE_POSTAL_CODE_LANDLORD, inputPostalCodeLandord).apply();
        mEditor.putString(Constants.ONE_PHONE_NUMBER_LANDLORD, inputNumberLandLord).apply();
        mEditor.putString(Constants.ONE_NATURE_OF_BUSINESS, inputBusiness).apply();
        mEditor.putString(Constants.ONE_YEAR_BUSINESS, inputYear).apply();
        mEditor.putString(Constants.ONE_INTRO_BY, inputIntroBy).apply();
        mEditor.putString(Constants.ONE_PURPOSE, inputPurpose).apply();





    }
}
