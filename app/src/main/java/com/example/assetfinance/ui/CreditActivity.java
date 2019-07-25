package com.example.assetfinance.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.assetfinance.Constants;
import com.example.assetfinance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreditActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.facilityType) EditText facilityType;
    @BindView(R.id.limit) EditText sanctionedLimit;
    @BindView(R.id.outstanding) EditText outstanding;
    @BindView(R.id.addCredit)
    Button addCreditBtn;
    @BindView(R.id.proceedEight) Button proceedEightBtn;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        setTitle("8. OTHER CREDIT FACILITIES AT I&M BANK LTD");
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        String inputName = mSharedPreferences.getString(Constants.EIGHT_NAME, null);
        String inputFacilityType = mSharedPreferences.getString(Constants.EIGHT_FACILITY_TYPE, null);
        String inputSanctionedLimit = mSharedPreferences.getString(Constants.EIGHT_SANCTIONED_LIMIT, null);
        String inputOutstanding= mSharedPreferences.getString(Constants.EIGHT_CURRENT_OUTSTANDING, null);

        if ((inputName) != null){
            name.setText(inputName);
        }
        if ((inputFacilityType) != null){
            facilityType.setText(inputFacilityType);
        }
        if ((inputSanctionedLimit)!= null){
            sanctionedLimit.setText(inputSanctionedLimit);
        }
        if ((inputOutstanding)!= null){
            outstanding.setText(inputOutstanding);
        }

        addCreditBtn.setOnClickListener(this);
        proceedEightBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == addCreditBtn){

        }
        if (v == proceedEightBtn){
            String inputName = name.getText().toString();
            String inputFacilitytype = facilityType.getText().toString();
            String inputSanctionedLimit = sanctionedLimit.getText().toString();
            String inputOutstanding = outstanding.getText().toString();


            if (
                    !(inputName).equals("") &&
                            !(inputFacilitytype).equals("") &&
                            !(inputSanctionedLimit).equals("") &&
                            !(inputOutstanding).equals("")
            ){
                addToSharedPreferences(inputName, inputFacilitytype,inputSanctionedLimit,inputOutstanding);
            }

            Intent intent = new Intent(this, AttachmentsActivity.class);
            startActivity(intent);


        }
    }
    private void addToSharedPreferences(String inputName,
                                        String inputFacilitytype,
                                        String inputSanctionedLimit,
                                        String inputOutstanding
    ) {
        mEditor.putString(Constants.EIGHT_NAME,inputName).apply();
        mEditor.putString(Constants.EIGHT_FACILITY_TYPE,inputFacilitytype).apply();
        mEditor.putString(Constants.EIGHT_SANCTIONED_LIMIT, inputSanctionedLimit).apply();
        mEditor.putString(Constants.EIGHT_CURRENT_OUTSTANDING, inputOutstanding).apply();




    }
}
