package com.example.assetfinance.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.assetfinance.Constants;
import com.example.assetfinance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssetDetail extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.make)
    EditText make;
    @BindView(R.id.modelCC) EditText modelCC;
    @BindView(R.id.yearOfManufacture) EditText yearOfManucature;
    @BindView(R.id.valuation) EditText valuation;
    @BindView(R.id.checkNew) CheckBox checkNew;
    @BindView(R.id.checkUsed)
    CheckBox checkUsed;
    @BindView(R.id.checkIMInsurance) CheckBox checkIMInsurance;
    @BindView(R.id.checkInterested) CheckBox checkInterested;
    @BindView(R.id.invoicePrice) EditText invoicePrice;
    @BindView(R.id.discounts) EditText discount;
    @BindView(R.id.netCost)
    TextView netCost;
    @BindView(R.id.accessory) EditText accessory;
    @BindView(R.id.accessoryValue) EditText accesssoryValue;
    @BindView(R.id.addAccessory)
    ImageButton addAccessoryBtn;
    @BindView(R.id.totalCost) TextView totalCost;
    @BindView(R.id.deposit) EditText deposit;
    @BindView(R.id.balanceOfCost) TextView balanceOfCost;
    @BindView(R.id.proceedSeven)
    Button proceedSevenBtn;


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_detail);
        setTitle("7. ASSET DETAILS");
        ButterKnife.bind(this);


        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        String inputMake = mSharedPreferences.getString(Constants.SEVEN_MAKE, null);
        String inputModelCC = mSharedPreferences.getString(Constants.SEVEN_MODEL_CC, null);
        String inputYearOfManufacture = mSharedPreferences.getString(Constants.SEVEN_YEAR_MANUFACTURE, null);
        String inputValuation = mSharedPreferences.getString(Constants.SEVEN_VALUATION, null);
        String inputInvoicePrice = mSharedPreferences.getString(Constants.SEVEN_INVOICE_PRICE, null);
        String inputDiscounts = mSharedPreferences.getString(Constants.SEVEN_DISCOUNT, null);
        String inputNetCost = mSharedPreferences.getString(Constants.SEVEN_NET_COST, null);
        String inputAccessoryName = mSharedPreferences.getString(Constants.SEVEN_ACCESSORY_OTHER, null);
        String inputAccessoryValue = mSharedPreferences.getString(Constants.SEVEN_VALUE, null);
        String inputTotalCost = mSharedPreferences.getString(Constants.SEVEN_TOTAL_COST, null);
        String inputDeposit = mSharedPreferences.getString(Constants.SEVEN_DEPOSIT, null);
        String inputBalanceOfCost = mSharedPreferences.getString(Constants.SEVEN_BALANCE_OF_COST, null);


        if ((inputMake) != null){
            make.setText(inputMake);
        }
        if ((inputModelCC) != null){
            modelCC.setText(inputModelCC);
        }
        if ((inputYearOfManufacture)!= null){
            yearOfManucature.setText(inputYearOfManufacture);
        }
        if ((inputValuation)!= null){
            valuation.setText(inputValuation);
        }
        if ((inputInvoicePrice)!= null){
            invoicePrice.setText(inputInvoicePrice);
        }
        if ((inputDiscounts)!= null){
            discount.setText(inputDiscounts);
        }
        if ((inputNetCost)!= null){
            netCost.setText(inputNetCost);
        }
        if ((inputAccessoryName)!= null){
            accessory.setText(inputAccessoryName);
        }
        if ((inputAccessoryValue)!= null){
            accesssoryValue.setText(inputAccessoryValue);
        }
        if ((inputTotalCost)!= null){
            totalCost.setText(inputTotalCost);
        }
        if ((inputDeposit)!= null){
            deposit.setText(inputDeposit);
        }
        if ((inputBalanceOfCost)!= null){
            balanceOfCost.setText(inputBalanceOfCost);
        }


        proceedSevenBtn.setOnClickListener(this);
        addAccessoryBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == addAccessoryBtn){

        }
        if (v == proceedSevenBtn){
            String inputMake = make.getText().toString();
            String inputModelCC = modelCC.getText().toString();
            String inputYearOfManufacture = yearOfManucature.getText().toString();
            String inputValuation = valuation.getText().toString();
            String inputInvoicePrice = invoicePrice.getText().toString();
            String inputDiscounts = discount.getText().toString();
            String inputNetCost = netCost.getText().toString();
            String inputAccessoryName = accessory.getText().toString();
            String inputAccessoryValue = accesssoryValue.getText().toString();
            String inputTotalCost = totalCost.getText().toString();
            String inputDeposit = deposit.getText().toString();
            String inputBalanceOfCost = balanceOfCost.getText().toString();

            if (
                    !(inputMake).equals("") &&
                            !(inputModelCC).equals("") &&
                            !(inputYearOfManufacture).equals("") &&
                            !(inputValuation).equals("") &&
                            !(inputInvoicePrice).equals("") &&
                            !(inputDiscounts).equals("") &&
                            !(inputNetCost).equals("") &&
                            !(inputAccessoryName).equals("") &&
                            !(inputAccessoryValue).equals("") &&
                            !(inputTotalCost).equals("") &&
                            !(inputDeposit).equals("") &&
                            !(inputBalanceOfCost).equals("")

            ){
                addToSharedPreferences(inputMake,
                        inputModelCC,
                        inputYearOfManufacture,
                        inputValuation,
                        inputInvoicePrice,
                        inputDiscounts,
                        inputNetCost,
                        inputAccessoryName,
                        inputAccessoryValue,
                        inputTotalCost,
                        inputDeposit,
                        inputBalanceOfCost);
            }


            Intent intent = new Intent(this,CreditActivity.class);
            startActivity(intent);
        }

    }
    private void addToSharedPreferences( String inputMake,
                                         String inputModelCC,
                                         String inputYearOfManufacture,
                                         String inputValuation,
                                         String inputInvoicePrice,
                                         String inputDiscounts,
                                         String inputNetCost,
                                         String inputAccessoryName,
                                         String inputAccessoryValue,
                                         String inputTotalCost,
                                         String inputDeposit,
                                         String inputBalanceOfCost) {
        mEditor.putString(Constants.SEVEN_MAKE,inputMake).apply();
        mEditor.putString(Constants.SEVEN_MODEL_CC, inputModelCC).apply();
        mEditor.putString(Constants.SEVEN_YEAR_MANUFACTURE, inputYearOfManufacture).apply();
        mEditor.putString(Constants.SEVEN_VALUATION, inputValuation).apply();
        mEditor.putString(Constants.SEVEN_INVOICE_PRICE, inputInvoicePrice).apply();
        mEditor.putString(Constants.SEVEN_DISCOUNT, inputDiscounts).apply();
        mEditor.putString(Constants.SEVEN_NET_COST, inputNetCost).apply();
        mEditor.putString(Constants.SEVEN_ACCESSORY_OTHER, inputAccessoryName).apply();
        mEditor.putString(Constants.SEVEN_VALUE, inputAccessoryValue).apply();
        mEditor.putString(Constants.SEVEN_TOTAL_COST, inputTotalCost).apply();
        mEditor.putString(Constants.SEVEN_DEPOSIT, inputDeposit).apply();
        mEditor.putString(Constants.SEVEN_BALANCE_OF_COST, inputBalanceOfCost).apply();


    }
}
