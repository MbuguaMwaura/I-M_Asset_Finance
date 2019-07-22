package com.example.assetfinance.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.assetfinance.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);
        setTitle("6. DEALER/SUPPLIER");
        ButterKnife.bind(this);

        proceedSixBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedSixBtn){

        }
    }
}
