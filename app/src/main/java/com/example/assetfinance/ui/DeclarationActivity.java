package com.example.assetfinance.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.assetfinance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeclarationActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.proceedTen)
    Button proceedTenBtn;
    @BindView(R.id.sign) Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declaration);
        setTitle("10. DECLARATION");
        ButterKnife.bind(this);

        proceedTenBtn.setOnClickListener(this);
        sign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedTenBtn){
            Intent intent = new Intent(this, PreviewActivity.class);
            startActivity(intent);
        }
        if (v == sign){
            Intent intent = new Intent(this, SignatureActivity.class);
            startActivity(intent);
        }
    }
}
