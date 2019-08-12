package com.example.assetfinance.ui.business;

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
import com.example.assetfinance.models.Property;
import com.example.assetfinance.models.Vehicle;
import com.example.assetfinance.ui.AdditionalInformation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessExistingAssets extends AppCompatActivity implements View.OnClickListener {
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

    @BindView(R.id.addProperty)
    Button addPropertyBtn;
    @BindView(R.id.proceedThree) Button proceedThreeBtn;
    @BindView(R.id.addVehicle)
    Button addVehicleBtn;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_existing_assets);
        setTitle("3. EXISTING VEHICLES/PROPERTIES");
        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        addVehicleBtn.setOnClickListener(this);
        addPropertyBtn.setOnClickListener(this);
        proceedThreeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == addVehicleBtn){
            String regNo = vehicleRegNo.getText().toString();
            String inputMake  = make.getText().toString();
            String inputModel = model.getText().toString();
            String inputBalance = loanBalance.getText().toString();
            String inputFinancedBy = financeBy.getText().toString();
            Vehicle vehicle = new Vehicle(regNo,inputMake,inputModel,inputBalance,inputFinancedBy);

            if (
                    (regNo).equals("") ||
                            (inputMake).equals("") ||
                            (inputModel).equals("") ||
                            (inputBalance).equals("") ||
                            (inputFinancedBy).equals("")
            ){
                Toast.makeText(this,"Please fill in all vehicle details", Toast.LENGTH_LONG).show();
                return;
            }

            String inputID = mSharedPreferences.getString(Constants.ONE_BUSINESS_ID_CERT, null);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference(inputID).child("vehicle_details");
            DatabaseReference pushRef = reference.push();
            String pushID = pushRef.getKey();
            vehicle.setPushId(pushID);
            pushRef.setValue(vehicle);
            Toast.makeText(this,"Adding Vehicle details",Toast.LENGTH_SHORT).show();
        }
        if (v == addPropertyBtn){
            String inputProperty = property.getText().toString();
            String inputSize = size.getText().toString();
            String inputLocation = location.getText().toString();
            String inputLrNo = lrNo.getText().toString();
            String inputValue = value.getText().toString();
            Property property = new Property(inputProperty,inputSize,inputLocation,inputLrNo,inputValue);

            if (
                    (inputProperty).equals("") ||
                            (inputSize).equals("") ||
                            (inputLocation).equals("") ||
                            (inputLrNo).equals("") ||
                            (inputValue).equals("")
            ){
                Toast.makeText(this,"Please fill in all property details", Toast.LENGTH_LONG).show();
                return;
            }

            String inputID = mSharedPreferences.getString(Constants.ONE_BUSINESS_ID_CERT, null);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(inputID).child("property_details");
            DatabaseReference pushRef = reference.push();
            pushRef.setValue(property);
            Toast.makeText(this,"Adding Property details",Toast.LENGTH_SHORT).show();


        }
        if (v == proceedThreeBtn){
            Intent intent = new Intent(this, BusinessAdditionalInfo.class);
            startActivity(intent);
        }
    }
}
