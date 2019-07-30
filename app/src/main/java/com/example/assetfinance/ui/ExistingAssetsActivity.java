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

public class ExistingAssetsActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.vehicleRegNo)
    EditText vehicleRegNo;
    @BindView(R.id.make) EditText make;
    @BindView(R.id.model) EditText model;
    @BindView(R.id.loanBalance) EditText loanBalance;
    @BindView(R.id.financedBy) EditText financeBy;


    @BindView(R.id.property) EditText property;
    @BindView(R.id.size) EditText size;
    @BindView(R.id.location) EditText location;
    @BindView(R.id.lrNo) EditText lrNo;
    @BindView(R.id.value) EditText value;

    @BindView(R.id.addProperty) Button addPropertyBtn;
    @BindView(R.id.proceedThree) Button proceedThreeBtn;
    @BindView(R.id.addVehicle)
    Button addVehicleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_assets);
        setTitle("3. EXISTING VEHICLES/PROPERTIES");
        ButterKnife.bind(this);

        addVehicleBtn.setOnClickListener(this);
        addPropertyBtn.setOnClickListener(this);
        proceedThreeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == addVehicleBtn){

        }
        if (v == addPropertyBtn){

        }
        if (v == proceedThreeBtn){
            Intent intent = new Intent(this, AdditionalInformation.class);
            startActivity(intent);
        }
    }
}
