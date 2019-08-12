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
import android.widget.Toast;

import com.example.assetfinance.Constants;
import com.example.assetfinance.R;
import com.example.assetfinance.models.FormSeven.AssetDetails;
import com.example.assetfinance.models.Property;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssetDetail extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.make)
    EditText make;
    @BindView(R.id.modelCC) EditText modelCC;
    @BindView(R.id.yearOfManufacture) EditText yearOfManucature;
    @BindView(R.id.valuation) EditText valuation;
    @BindView(R.id.invoicePrice) EditText invoicePrice;
    @BindView(R.id.discounts) EditText discount;
    @BindView(R.id.netCost)
    TextView netCost;
    @BindView(R.id.accessory) EditText accessory;
    @BindView(R.id.accessoryValue) EditText accesssoryValue;
    @BindView(R.id.totalCost) TextView totalCost;
    @BindView(R.id.deposit) EditText deposit;
    @BindView(R.id.balanceOfCost) TextView balanceOfCost;
    @BindView(R.id.vehicleState) TextView vehicleState;
    @BindView(R.id.insurance) TextView insurance;


    @BindView(R.id.netCostBtn) ImageButton netCostBtn;
    @BindView(R.id.costTotal) ImageButton costTotalBtn;
    @BindView(R.id.costBalance) ImageButton costBalanceBtn;
    @BindView(R.id.proceedSeven)
    Button proceedSevenBtn;

    @BindView(R.id.checkNew) CheckBox checkNew;
    @BindView(R.id.checkUsed)
    CheckBox checkUsed;
    @BindView(R.id.checkIMInsurance) CheckBox checkIMInsurance;
    @BindView(R.id.checkInterested) CheckBox checkInterested;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_detail);
        setTitle("6. ASSET DETAILS");
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
        String inputVehicleState = mSharedPreferences.getString(Constants.SEVEN_VEHICLE_STATE,null);
        String inputInsurance = mSharedPreferences.getString(Constants.SEVEN_INSURANCE_OPTION,null);


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

        if (inputVehicleState != null) {
            if ((inputVehicleState).equals("New Vehicle") ){
                checkNew.setChecked(true);
            }else {
                checkNew.setChecked(false);
            }
        }
        if (inputVehicleState != null && (inputVehicleState).equals("Used Vehicle")) {
            checkUsed.setChecked(true);
        }
        if (inputInsurance != null && (inputInsurance).equals("Using I&M Insurance Agency")) {
            checkIMInsurance.setChecked(true);
        }
        if (inputInsurance != null && (inputInsurance).equals("Interest in Insurance Finance (IPF)")) {
            checkInterested.setChecked(true);
        }


        proceedSevenBtn.setOnClickListener(this);
        netCostBtn.setOnClickListener(this);
        costBalanceBtn.setOnClickListener(this);
        costTotalBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == netCostBtn){
            int total = 0;
            String computeInvoicePrice = invoicePrice.getText().toString();
            int invoicePriceInt = Integer.parseInt(computeInvoicePrice);
            String computeDiscount = discount.getText().toString();
            int discountInt = Integer.parseInt(computeDiscount);

            total = invoicePriceInt - discountInt;
            String totalVal = String.valueOf(total);

            netCost.setText("Net Cost: "+totalVal);

        }
        if (v == costTotalBtn){
            int total = 0;
            String computeInvoicePrice = invoicePrice.getText().toString();
            int invoicePriceInt = Integer.parseInt(computeInvoicePrice);
            String computeDiscount = discount.getText().toString();
            int discountInt = Integer.parseInt(computeDiscount);
            String computeValue = accesssoryValue.getText().toString();
            int valueInt = Integer.parseInt(computeValue);


            total = invoicePriceInt-discountInt + valueInt;
            String totalVal = String.valueOf(total);

            totalCost.setText("Total Cost: "+totalVal);



        }
        if (v == costBalanceBtn){
            int total = 0;
            String computeDeposit = deposit.getText().toString();
            int depositInt = Integer.parseInt(computeDeposit);
            String computeInvoicePrice = invoicePrice.getText().toString();
            int invoicePriceInt = Integer.parseInt(computeInvoicePrice);
            String computeDiscount = discount.getText().toString();
            int discountInt = Integer.parseInt(computeDiscount);
            String computeValue = accesssoryValue.getText().toString();
            int valueInt = Integer.parseInt(computeValue);

            total = invoicePriceInt-discountInt + valueInt - depositInt;
            String totalVal = String.valueOf(total);
            balanceOfCost.setText("Balance of Cost: "+totalVal);


        }
        if (v == proceedSevenBtn){
            String inputVehicleState = "";
            String inputInsurance = "";
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
            if (checkNew.isChecked()){ inputVehicleState = "New Vehicle";}
            if (checkUsed.isChecked()){ inputVehicleState = "Used Vehicle";}
            if (checkIMInsurance.isChecked()){inputInsurance = "Using I&M Insurance Agency";}
            if (checkInterested.isChecked()){inputInsurance = "Interest in Insurance Finance (IPF)";}

            AssetDetails assetDetail = new AssetDetails(inputMake,inputModelCC,inputYearOfManufacture,inputValuation,inputVehicleState,
                    inputInsurance,inputInvoicePrice,inputDiscounts, inputNetCost,inputDeposit,inputBalanceOfCost,inputAccessoryName,
                    inputAccessoryValue,inputTotalCost);
            String inputID = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(inputID).child("asset_details");
            reference.setValue(assetDetail);


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
                            !(inputBalanceOfCost).equals("") &&
                            !(inputVehicleState).equals("")&&
                            !(inputInsurance).equals("")

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
                        inputBalanceOfCost,
                        inputVehicleState,
                        inputInsurance);
            }

            if (
                    (inputMake).equals("") ||
                            (inputModelCC).equals("") ||
                            (inputYearOfManufacture).equals("") ||
                            (inputValuation).equals("") ||
                            (inputInvoicePrice).equals("") ||
                            (inputDiscounts).equals("") ||
                            (inputNetCost).equals("") ||
                            (inputAccessoryName).equals("") ||
                            (inputAccessoryValue).equals("") ||
                            (inputTotalCost).equals("") ||
                            (inputDeposit).equals("") ||
                            (inputBalanceOfCost).equals("")

            ){
                Toast.makeText(this,"Please fill in all details", Toast.LENGTH_LONG).show();
                return;
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
                                         String inputBalanceOfCost,
                                         String inputVehicleState,
                                         String inputInsurance) {
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
        mEditor.putString(Constants.SEVEN_VEHICLE_STATE, inputVehicleState).apply();
        mEditor.putString(Constants.SEVEN_INSURANCE_OPTION, inputInsurance).apply();



    }
}
