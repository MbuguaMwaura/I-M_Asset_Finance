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
import com.example.assetfinance.services.DjangoService;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DjangoFormTwoActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.description) EditText description;
    @BindView(R.id.address) EditText address;


    @BindView(R.id.proceedTestTwo)
    Button proceedTestBtn;


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_django_form_two);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();
        String mobileNumber = mSharedPreferences.getString(Constants.PHONE_KEY, null);
        String personAddress = mSharedPreferences.getString(Constants.ADDRESS_KEY, null);
        String personDescription = mSharedPreferences.getString(Constants.DESCRIPTION_KEY, null);

        if ((mobileNumber)!= null){
            phone.setText(mobileNumber);
        }
        if ((personAddress)!= null){
            address.setText(personAddress);
        }
        if ((personDescription)!=null){
            description.setText(personDescription);
        }

        proceedTestBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String homeAddress = address.getText().toString();
        String phoneNumber = phone.getText().toString();
        String describe = description.getText().toString();
        if(!(homeAddress).equals("") && !(phoneNumber).equals("") && !(describe).equals("") ) {
            addToSharedPreferences(phoneNumber, homeAddress, describe);
        }
        String nameOne = mSharedPreferences.getString(Constants.FIRST_NAME_KEY, null);
        String nameTwo = mSharedPreferences.getString(Constants.LAST_NAME_KEY, null);
        String personEmail = mSharedPreferences.getString(Constants.EMAIL_KEY, null);
        String mobileNumber = mSharedPreferences.getString(Constants.PHONE_KEY, null);
        String personAddress = mSharedPreferences.getString(Constants.ADDRESS_KEY, null);
        String personDescription = mSharedPreferences.getString(Constants.DESCRIPTION_KEY, null);

        final DjangoService djangoService = new DjangoService();
        djangoService.post(nameOne, nameTwo, personEmail, mobileNumber, personAddress, personDescription, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void addToSharedPreferences(String phone, String address, String description) {
        mEditor.putString(Constants.PHONE_KEY,phone).apply();
        mEditor.putString(Constants.ADDRESS_KEY, address).apply();
        mEditor.putString(Constants.DESCRIPTION_KEY, description).apply();
    }
}
