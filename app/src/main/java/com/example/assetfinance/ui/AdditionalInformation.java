package com.example.assetfinance.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.assetfinance.Constants;
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

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_information);
        setTitle("4. ADDITIONAL INFO");
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();


        String inputAge = mSharedPreferences.getString(Constants.FOUR_AGE, null);
        String inputOccupation = mSharedPreferences.getString(Constants.FOUR_OCCUPATION, null);
        String inputEmployer = mSharedPreferences.getString(Constants.FOUR_EMPLOYER, null);
        String inputAddress = mSharedPreferences.getString(Constants.FOUR_ADDRESS, null);
        String inputTelNo = mSharedPreferences.getString(Constants.FOUR_TEL_NO, null);
        String inputPosition = mSharedPreferences.getString(Constants.FOUR_POSITION, null);
        String inputYears = mSharedPreferences.getString(Constants.FOUR_YEARS_IN_POSITION, null);
        String inputStatus = mSharedPreferences.getString(Constants.FOUR_STATUS, null);
        String inputSpouse = mSharedPreferences.getString(Constants.FOUR_NAME_SPOUSE, null);
        String inputIncome = mSharedPreferences.getString(Constants.FOUR_INCOME, null);
        String inputSelfIncome = mSharedPreferences.getString(Constants.FOUR_SELF_INCOME, null);
        String inputLivingExpenses = mSharedPreferences.getString(Constants.FOUR_LIVING_EXPENSES, null);
        String inputCurrentLoans = mSharedPreferences.getString(Constants.FOUR_CURRENT_LOAN_REPAYMENTS, null);
        String inputOtherIncome = mSharedPreferences.getString(Constants.FOUR_OTHER_INCOME, null);
        String inputNetDisposable = mSharedPreferences.getString(Constants.FOUR_NET_DISPOSABLE_INCOME, null);

        if ((inputAge) != null){
            age.setText(inputAge);
        }
        if ((inputOccupation) != null){
            occupation.setText(inputOccupation);
        }
        if ((inputEmployer)!= null){
            employerName.setText(inputEmployer);
        }
        if ((inputAddress)!= null){
            address.setText(inputAddress);
        }
        if ((inputTelNo)!= null){
            telephoneNumber.setText(inputTelNo);
        }
        if ((inputPosition)!= null){
            position.setText(inputPosition);
        }
        if ((inputYears)!= null){
            yearsInCurrentPosition.setText(inputYears);
        }
        if ((inputStatus)!= null){
            status.setText(inputStatus);
        }
        if ((inputSpouse)!= null){
            spouse.setText(inputSpouse);
        }
        if ((inputIncome)!= null){
            employmentIncome.setText(inputIncome);
        }
        if ((inputSelfIncome)!= null){
            selfIncome.setText(inputSelfIncome);
        }
        if ((inputLivingExpenses)!= null){
           livingExpenses.setText(inputLivingExpenses);
        }
        if ((inputCurrentLoans)!= null){
            loanRepayments.setText(inputCurrentLoans);
        }
        if ((inputOtherIncome)!= null){
            otherIncomeBusiness.setText(inputOtherIncome);
        }
        if ((inputNetDisposable)!= null){
            disposableIncome.setText(inputNetDisposable);
        }


        proceedFourBtn.setOnClickListener(this);
        addIncomeBtn.setOnClickListener(this);
        addLoanBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedFourBtn){
            String inputAge = age.getText().toString();
            String inputOccupation = occupation.getText().toString();
            String inputEmployer = employerName.getText().toString();
            String inputAddress = address.getText().toString();
            String inputTelNo = telephoneNumber.getText().toString();
            String inputPosition = position.getText().toString();
            String inputYears =yearsInCurrentPosition.getText().toString();
            String inputStatus = status.getText().toString();
            String inputSpouse = spouse.getText().toString();
            String inputIncome = employmentIncome.getText().toString();
            String inputSelfIncome = selfIncome.getText().toString();
            String inputLivingExpenses = livingExpenses.getText().toString();
            String inputCurrentLoans = loanRepayments.getText().toString();
            String inputOtherIncome = otherIncomeBusiness.getText().toString();
            String inputNetDisposable = disposableIncome.getText().toString();


            if (
                    !(inputAge).equals("") &&
                            !(inputOccupation).equals("") &&
                            !(inputEmployer).equals("") &&
                            !(inputAddress).equals("") &&
                            !(inputTelNo).equals("") &&
                            !(inputPosition).equals("") &&
                            !(inputYears).equals("") &&
                            !(inputStatus).equals("") &&
                            !(inputSpouse).equals("") &&
                            !(inputIncome).equals("") &&
                            !(inputSelfIncome).equals("") &&
                            !(inputLivingExpenses).equals("") &&
                            !(inputCurrentLoans).equals("") &&
                            !(inputOtherIncome).equals("") &&
                            !(inputNetDisposable).equals("")
            ){
                addToSharedPreferences(inputAge,
                        inputOccupation,
                        inputEmployer,
                        inputAddress,
                        inputTelNo,
                        inputPosition,
                        inputYears,
                        inputStatus,
                        inputSpouse,
                        inputIncome,
                        inputSelfIncome,
                        inputLivingExpenses,
                        inputCurrentLoans,
                        inputOtherIncome,
                        inputNetDisposable);
            }
            Intent intent = new Intent(this, AdditionalInfoCompany.class);
            startActivity(intent);
        }
        if (v == addIncomeBtn){

        }
        if (v == addLoanBtn){

        }
    }
    private void addToSharedPreferences(String inputAge,
                                        String inputOccupation,
                                        String inputEmployer,
                                        String inputAddress,
                                        String inputTelNo,
                                        String inputPosition,
                                        String inputYears,
                                        String inputStatus,
                                        String inputSpouse,
                                        String inputIncome,
                                        String inputSelfIncome,
                                        String inputLivingExpenses,
                                        String inputCurrentLoans,
                                        String inputOtherIncome,
                                        String inputNetDisposable) {
        mEditor.putString(Constants.FOUR_AGE,inputAge).apply();
        mEditor.putString(Constants.FOUR_OCCUPATION,inputOccupation).apply();
        mEditor.putString(Constants.FOUR_EMPLOYER, inputEmployer).apply();
        mEditor.putString(Constants.FOUR_ADDRESS, inputAddress).apply();
        mEditor.putString(Constants.FOUR_TEL_NO, inputTelNo).apply();
        mEditor.putString(Constants.FOUR_POSITION, inputPosition).apply();
        mEditor.putString(Constants.FOUR_YEARS_IN_POSITION, inputYears).apply();
        mEditor.putString(Constants.FOUR_STATUS, inputStatus).apply();
        mEditor.putString(Constants.FOUR_NAME_SPOUSE, inputSpouse).apply();
        mEditor.putString(Constants.FOUR_INCOME, inputIncome).apply();
        mEditor.putString(Constants.FOUR_SELF_INCOME, inputSelfIncome).apply();
        mEditor.putString(Constants.FOUR_LIVING_EXPENSES, inputLivingExpenses).apply();
        mEditor.putString(Constants.FOUR_CURRENT_LOAN_REPAYMENTS, inputCurrentLoans).apply();
        mEditor.putString(Constants.FOUR_OTHER_INCOME, inputOtherIncome).apply();
        mEditor.putString(Constants.FOUR_NET_DISPOSABLE_INCOME, inputNetDisposable).apply();




    }
}
