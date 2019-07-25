package com.example.assetfinance.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.assetfinance.Constants;
import com.example.assetfinance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdditionalInfoCompany extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.shareholder)
    EditText shareholder;
    @BindView(R.id.addShareholder)
    ImageButton addShareHolderBtn;
    @BindView(R.id.annualTurnover) EditText annualTurnOver;
    @BindView(R.id.annualNetProfit) EditText annualNetProfit;
    @BindView(R.id.associateCompany) EditText associateCompany;
    @BindView(R.id.addCompany) ImageButton addCompany;
    @BindView(R.id.proceedFive)
    Button proceedFiveBtn;


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_info_company);
        setTitle("5. ADDITIONAL INFO");
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();


        String inputShareholder = mSharedPreferences.getString(Constants.FIVE_SHAREHOLDERS, null);
        String inputTurnover = mSharedPreferences.getString(Constants.FIVE_TURNOVER, null);
        String inputNetProfit = mSharedPreferences.getString(Constants.FIVE_NET_PROFIT, null);
        String inputAssociateCompanies = mSharedPreferences.getString(Constants.FIVE_ASSOCIATE_COMPANIES, null);



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
        addCompany.setOnClickListener(this);
        addShareHolderBtn.setOnClickListener(this);
        proceedFiveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == addCompany){

        }
        if (v == addShareHolderBtn){

        }
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

            Intent intent = new Intent(this, SupplierActivity.class);
            startActivity(intent);
        }
    }
    private void addToSharedPreferences(String inputShareholder,
                                        String inputTurnover,
                                        String inputNetProfit,
                                        String inputAssociateCompanies
                                       ) {
        mEditor.putString(Constants.FIVE_SHAREHOLDERS,inputShareholder).apply();
        mEditor.putString(Constants.FIVE_TURNOVER,inputTurnover).apply();
        mEditor.putString(Constants.FIVE_NET_PROFIT, inputNetProfit).apply();
        mEditor.putString(Constants.FIVE_ASSOCIATE_COMPANIES, inputAssociateCompanies).apply();


    }
}
