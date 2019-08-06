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
import com.example.assetfinance.models.Supplier;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SupplierActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.dealerName)
    EditText dealerName;
    @BindView(R.id.postalAddress) EditText postalAddress;
    @BindView(R.id.number) EditText number;
    @BindView(R.id.invoiceNoDate) EditText invoiceNoDate;
    @BindView(R.id.salesPerson) EditText salesPerson;
    @BindView(R.id.proceedSix)
    Button proceedSixBtn;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);
        setTitle("5. DEALER/SUPPLIER");
        ButterKnife.bind(this);


        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        String inputDealerName = mSharedPreferences.getString(Constants.SIX_DEALER_NAME, null);
        String inputPostalAddress = mSharedPreferences.getString(Constants.SIX_POSTAL_ADDRESS_DEALER, null);
        String inputTelNo = mSharedPreferences.getString(Constants.SIX_TEL_NO_DEALER, null);
        String inputInvoiceDate = mSharedPreferences.getString(Constants.SIX_INVOICE_DATE, null);
        String inputSalesPerson = mSharedPreferences.getString(Constants.SIX_SALES_PERSON, null);


        if ((inputDealerName) != null){
            dealerName.setText(inputDealerName);
        }
        if ((inputPostalAddress) != null){
            postalAddress.setText(inputPostalAddress);
        }
        if ((inputTelNo)!= null){
            number.setText(inputTelNo);
        }
        if ((inputInvoiceDate)!= null){
            invoiceNoDate.setText(inputInvoiceDate);
        }
        if ((inputSalesPerson)!= null){
            salesPerson.setText(inputSalesPerson);
        }

        proceedSixBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedSixBtn){
            String inputDealerName = dealerName.getText().toString();
            String inputPostalAddress = postalAddress.getText().toString();
            String inputTelNo = number.getText().toString();
            String inputSalesPerson = salesPerson.getText().toString();
            String inputInvoiceDate = invoiceNoDate.getText().toString();

            if (
                    !(inputDealerName).equals("") &&
                            !(inputPostalAddress).equals("") &&
                            !(inputTelNo).equals("") &&
                            !(inputSalesPerson).equals("") &&
                            !(inputInvoiceDate).equals("")
     ){
                addToSharedPreferences(inputDealerName, inputPostalAddress, inputTelNo, inputSalesPerson, inputInvoiceDate);
            }
            if ( (inputDealerName).equals("") ||
                    (inputPostalAddress).equals("") ||
                    (inputTelNo).equals("") ||
                    (inputSalesPerson).equals("") ||
                    (inputInvoiceDate).equals("")){
                Toast.makeText(this,"Please fill in all the fields", Toast.LENGTH_LONG).show();
                return;
            }


            String inputID = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(inputID).child("supplier_details");
            Supplier supplier = new Supplier(inputDealerName,inputPostalAddress,inputTelNo,inputInvoiceDate,inputSalesPerson);
            reference.setValue(supplier);
            Intent intent = new Intent(this, AssetDetail.class);
            startActivity(intent);
        }
    }
    private void addToSharedPreferences(String inputDealerName,
                                        String inputPostalAddress,
                                        String inputTelNo,
                                        String inputSalesPerson,
                                        String inputInvoiceDate
    ) {
        mEditor.putString(Constants.SIX_DEALER_NAME,inputDealerName).apply();
        mEditor.putString(Constants.SIX_POSTAL_ADDRESS_DEALER,inputPostalAddress).apply();
        mEditor.putString(Constants.SIX_TEL_NO_DEALER, inputTelNo).apply();
        mEditor.putString(Constants.SIX_SALES_PERSON, inputSalesPerson).apply();
        mEditor.putString(Constants.SIX_INVOICE_DATE, inputInvoiceDate).apply();



    }
}
