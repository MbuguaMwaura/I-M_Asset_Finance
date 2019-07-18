package com.example.assetfinance.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.assetfinance.R;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant);
        setTitle("1. APPLICANT");
        ButterKnife.bind(this);


        proceedOne.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedOne){
            Intent intent = new Intent(this,BankDetailsActivity.class);
            startActivity(intent);
        }
    }
}
