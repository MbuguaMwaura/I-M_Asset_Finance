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
import com.example.assetfinance.services.DjangoService;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DjangoFormActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.firstName)
    EditText firstName;
    @BindView(R.id.lastName) EditText lastName;
    @BindView(R.id.email) EditText email;


    @BindView(R.id.proceedTest)
    Button proceedTestBtn;


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_django_form);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();
        String nameOne = mSharedPreferences.getString(Constants.FIRST_NAME_KEY, null);
        String nameTwo = mSharedPreferences.getString(Constants.LAST_NAME_KEY, null);
        String personEmail = mSharedPreferences.getString(Constants.EMAIL_KEY, null);

        if ((nameOne) != null){
            firstName.setText(nameOne);
        }
        if ((nameTwo) != null){
            lastName.setText(nameTwo);
        }
        if ((personEmail)!= null){
            email.setText(personEmail);
        }



        proceedTestBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedTestBtn){
           String first = firstName.getText().toString();
           String last = lastName.getText().toString();
           String emailAddress = email.getText().toString();
            if(!(first).equals("") && !(last).equals("") && !(emailAddress).equals("") ) {
                addToSharedPreferences(first, last, emailAddress);
            }
            Intent intent = new Intent(this, DjangoFormTwoActivity.class);
            startActivity(intent);

        }
    }
    private void addToSharedPreferences(String first_name, String last_name, String email) {
        mEditor.putString(Constants.FIRST_NAME_KEY,first_name).apply();
        mEditor.putString(Constants.LAST_NAME_KEY, last_name).apply();
        mEditor.putString(Constants.EMAIL_KEY, email).apply();
    }
}
