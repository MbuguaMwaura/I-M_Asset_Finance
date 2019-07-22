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

public class CreditActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.facilityType) EditText facilityType;
    @BindView(R.id.limit) EditText sanctionedLimit;
    @BindView(R.id.outstanding) EditText outstanding;
    @BindView(R.id.addCredit)
    Button addCreditBtn;
    @BindView(R.id.proceedEight) Button proceedEightBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        setTitle("8. OTHER CREDIT FACILITIES AT I&M BANK LTD");
        ButterKnife.bind(this);

        addCreditBtn.setOnClickListener(this);
        proceedEightBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == addCreditBtn){

        }
        if (v == proceedEightBtn){
            Intent intent = new Intent(this, AttachmentsActivity.class);
            startActivity(intent);
        }
    }
}
