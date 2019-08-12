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
import com.example.assetfinance.models.BankDetails;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BankDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.bankName)
    EditText bankName;
    @BindView(R.id.branch) EditText branch;
    @BindView(R.id.accountNumber) EditText accountNumber;
    @BindView(R.id.odLimit) EditText odLimit;
    @BindView(R.id.outStandingLoans) EditText outStandingLoans;
    @BindView(R.id.proceedTwo)
    Button proceedTwo;
    @BindView(R.id.addBank) Button addBank;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);
        setTitle("2. APPLICANT'S BANK DETAILS");
        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        proceedTwo.setOnClickListener(this);
        addBank.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedTwo){
            Intent intent = new Intent(this, ExistingAssetsActivity.class);
            startActivity(intent);
        }
        if (v == addBank){
            String inputbankName = bankName.getText().toString();
            String Branch = branch.getText().toString();
            String inputaccountNumber = accountNumber.getText().toString();
            String inputodLimit = odLimit.getText().toString();
            String inputoutStandingLoans = outStandingLoans.getText().toString();


            if (
                    (inputbankName).equals("") ||
                            (Branch).equals("") ||
                            (inputaccountNumber).equals("") ||
                            (inputodLimit).equals("") ||
                            (inputoutStandingLoans).equals("")


            ){
                Toast.makeText(this,"Please fill in all details",Toast.LENGTH_LONG).show();
                return;
            }

            String inputID = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(inputID).child("bank_details");
            BankDetails bankDetails = new BankDetails(inputbankName,Branch,inputaccountNumber,inputodLimit,inputoutStandingLoans);
            DatabaseReference pushRef = reference.push();
            String pushID = pushRef.getKey();
            bankDetails.setPushId(pushID);
            pushRef.setValue(bankDetails);
        }
    }
}
