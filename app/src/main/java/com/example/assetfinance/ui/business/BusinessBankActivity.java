package com.example.assetfinance.ui.business;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.assetfinance.R;
import com.example.assetfinance.ui.ExistingAssetsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessBankActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.bankName)
    EditText bankName;
    @BindView(R.id.branch) EditText branch;
    @BindView(R.id.accountNumber) EditText accountNumber;
    @BindView(R.id.odLimit) EditText odLimit;
    @BindView(R.id.outStandingLoans) EditText outStandingLoans;
    @BindView(R.id.proceedTwo)
    Button proceedTwo;
    @BindView(R.id.addBank) Button addBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_bank);
        setTitle("2. APPLICANT'S BANK DETAILS");
        ButterKnife.bind(this);

        proceedTwo.setOnClickListener(this);
        addBank.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedTwo){
            Intent intent = new Intent(this, BusinessExistingAssets.class);
            startActivity(intent);
        }
    }
}
