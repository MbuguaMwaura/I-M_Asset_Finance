package com.example.assetfinance.ui;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.assetfinance.R;
import com.example.assetfinance.ui.business.BusinessApplicantActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.apply)
    Button apply;
    @BindView(R.id.applyindividual) Button applyIndividual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ASSET FINANCE");
        ButterKnife.bind(this);


        apply.setOnClickListener(this);
        applyIndividual.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == apply){
            Intent intent = new Intent(this, ApplicantActivity.class);
            startActivity(intent);
        }
        if (v == applyIndividual){
            Intent intent = new Intent(this, BusinessApplicantActivity.class);
            startActivity(intent);
        }
    }
}
