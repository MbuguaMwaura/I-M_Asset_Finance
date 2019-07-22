package com.example.assetfinance.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_detail);
        setTitle("7. Asset Details");
        ButterKnife.bind(this);

        proceedSevenBtn.setOnClickListener(this);
        addAccessoryBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == addAccessoryBtn){

        }
        if (v == proceedSevenBtn){

        }

    }
}
