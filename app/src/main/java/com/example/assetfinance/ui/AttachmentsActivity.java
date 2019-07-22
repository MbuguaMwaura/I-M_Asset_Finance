package com.example.assetfinance.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.assetfinance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttachmentsActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.proceedNine)
    Button proceedNineBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attachments);
        ButterKnife.bind(this);
        setTitle("9. APPLICATION ATTACHMENTS");

        proceedNineBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == proceedNineBtn){
            Intent intent =  new Intent(this, DeclarationActivity.class);
            startActivity(intent);
        }
    }
}
