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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

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
        final DjangoService djangoService = new DjangoService();
        String homeAddress = address.getText().toString();
        String phoneNumber = phone.getText().toString();
        String describe = description.getText().toString();
        if(!(homeAddress).equals("") && !(phoneNumber).equals("") && !(describe).equals("") ) {
            addToSharedPreferences(phoneNumber, homeAddress, describe);
        }

        Intent intent = new Intent(this, PreviewActivity.class);
        startActivity(intent);

//        djangoService.details(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                Toast.makeText(DjangoFormTwoActivity.this,"failed",Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                String jsonData = response.body().string();
//                Toast.makeText(DjangoFormTwoActivity.this, jsonData,Toast.LENGTH_LONG).show();
//                Gson gson = new GsonBuilder().setPrettyPrinting().create();
//                JsonParser jp = new JsonParser();
//                JsonElement je = jp.parse(jsonData);
//                JsonReader reader = new JsonReader(new StringReader(jsonData));
//                String prettyJsonString = gson.toJson(reader);
//                Document document = new Document();
//                try {
//                    PdfWriter.getInstance(document, new FileOutputStream("myJSON.pdf"));
//                } catch (DocumentException e) {
//                    e.printStackTrace();
//                }
//                document.open();
//                Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//                Chunk chunk = new Chunk(prettyJsonString, font);
//
//                try {
//                    document.add(chunk);
//                } catch (DocumentException e) {
//                    e.printStackTrace();
//                }
//                document.close();
//            }
//        });
    }
    private void addToSharedPreferences(String phone, String address, String description) {
        mEditor.putString(Constants.PHONE_KEY,phone).apply();
        mEditor.putString(Constants.ADDRESS_KEY, address).apply();
        mEditor.putString(Constants.DESCRIPTION_KEY, description).apply();

    }
}
