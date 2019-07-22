package com.example.assetfinance.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.assetfinance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdditionalInformation extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.age)
    EditText age;
    @BindView(R.id.occupation) EditText occupation;
    @BindView(R.id.employerName) EditText employerName;
    @BindView(R.id.address) EditText address;
    @BindView(R.id.telephoneNumber) EditText telephoneNumber;
    @BindView(R.id.position) EditText position;
    @BindView(R.id.yearsInCurrentPosition) EditText yearsInCurrentPosition;
    @BindView(R.id.status) EditText status;
    @BindView(R.id.spouse) EditText spouse;
    @BindView(R.id.spouseOccupation) EditText spouseOccupation;
    @BindView(R.id.employmentIncome) EditText employmentIncome;
    @BindView(R.id.selfIncome) EditText selfIncome;
    @BindView(R.id.spouseIncome) EditText spouseIncome;
    @BindView(R.id.livingExpenses) EditText livingExpenses;
    @BindView(R.id.loanRepayments) EditText loanRepayments;
    @BindView(R.id.otherIncomeBusiness) EditText otherIncomeBusiness;
    @BindView(R.id.disposableIncome) EditText disposableIncome;
    @BindView(R.id.proceedFour)
    Button proceedFourBtn;
    @BindView(R.id.addLoan)
    ImageButton addLoanBtn;
    @BindView(R.id.addIncome) ImageButton addIncomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_information);
        ButterKnife.bind(this);

        proceedFourBtn.setOnClickListener(this);
        addIncomeBtn.setOnClickListener(this);
        addLoanBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedFourBtn){

        }
        if (v == addIncomeBtn){

        }
        if (v == addLoanBtn){

        }
    }
}
