package com.example.assetfinance.ui.business;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.assetfinance.Constants;
import com.example.assetfinance.R;
import com.example.assetfinance.models.FormFive.AdditionalInfoCompany;
import com.example.assetfinance.models.FormFour.AdditionalDetailsIndividual;
import com.example.assetfinance.ui.SupplierActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessAdditionalInfo extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.shareholder)
    EditText shareholder;

    @BindView(R.id.annualTurnover) EditText annualTurnOver;
    @BindView(R.id.annualNetProfit) EditText annualNetProfit;
    @BindView(R.id.associateCompany) EditText associateCompany;
    @BindView(R.id.proceedFive)
    Button proceedFiveBtn;


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_additional_info);
        setTitle("4. ADDITIONAL INFO");
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();


        String inputShareholder = mSharedPreferences.getString(Constants.FIVE_BUSINESS_SHAREHOLDERS, null);
        String inputTurnover = mSharedPreferences.getString(Constants.FIVE_BUSINESS_TURNOVER, null);
        String inputNetProfit = mSharedPreferences.getString(Constants.FIVE_BUSINESS_NET_PROFIT, null);
        String inputAssociateCompanies = mSharedPreferences.getString(Constants.FIVE_BUSINESS_ASSOCIATE_COMPANIES, null);



        if ((inputShareholder) != null){
            shareholder.setText(inputShareholder);
        }
        if ((inputTurnover) != null){
            annualTurnOver.setText(inputTurnover);
        }
        if ((inputNetProfit)!= null){
            annualNetProfit.setText(inputNetProfit);
        }
        if ((inputAssociateCompanies)!= null){
            associateCompany.setText(inputAssociateCompanies);
        }

        proceedFiveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == proceedFiveBtn){
            String inputShareholder = shareholder.getText().toString();
            String inputTurnover = annualTurnOver.getText().toString();
            String inputNetProfit = annualNetProfit.getText().toString();
            String inputAssociateCompanies = associateCompany.getText().toString();


            if (
                    !(inputShareholder).equals("") &&
                            !(inputTurnover).equals("") &&
                            !(inputNetProfit).equals("") &&
                            !(inputAssociateCompanies).equals("")

            ){
                addToSharedPreferences(inputShareholder, inputTurnover, inputNetProfit, inputAssociateCompanies);
            }

            if (
                    (inputShareholder).equals("") ||
                            (inputTurnover).equals("") ||
                            (inputNetProfit).equals("") ||
                            (inputAssociateCompanies).equals("")

            ){
                Toast.makeText(this,"Please fill in all the fields",Toast.LENGTH_LONG).show();
                return;
            }
            Intent intent = new Intent(this, BusinessDealerActivity.class);
            startActivity(intent);
            String inputID = mSharedPreferences.getString(Constants.ONE_BUSINESS_ID_CERT, null);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(inputID).child("additional_info_details");
            AdditionalInfoCompany additionalInfoCompany = new AdditionalInfoCompany(inputShareholder,inputTurnover,inputNetProfit,inputAssociateCompanies);
            reference.setValue(additionalInfoCompany);
        }
    }
    private void addToSharedPreferences(String inputShareholder,
                                        String inputTurnover,
                                        String inputNetProfit,
                                        String inputAssociateCompanies
    ) {
        mEditor.putString(Constants.FIVE_BUSINESS_SHAREHOLDERS,inputShareholder).apply();
        mEditor.putString(Constants.FIVE_BUSINESS_TURNOVER,inputTurnover).apply();
        mEditor.putString(Constants.FIVE_BUSINESS_NET_PROFIT, inputNetProfit).apply();
        mEditor.putString(Constants.FIVE_BUSINESS_ASSOCIATE_COMPANIES, inputAssociateCompanies).apply();
    }
}
