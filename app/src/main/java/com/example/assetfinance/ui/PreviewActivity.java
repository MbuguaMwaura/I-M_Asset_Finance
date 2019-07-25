package com.example.assetfinance.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assetfinance.Constants;
import com.example.assetfinance.R;
import com.example.assetfinance.services.DjangoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PreviewActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.editPageOne)
    TextView editPageOne;
    @BindView(R.id.editPageTwo)
    TextView editPageTwo;
    @BindView(R.id.done)
    Button finish;
    @BindView(R.id.generate)
    Button generate;

    @BindView(R.id.firstName) TextView firstName;
    @BindView(R.id.lastName) TextView textView;
    @BindView(R.id.email) TextView email;
    @BindView(R.id.number) TextView number;
    @BindView(R.id.address) TextView address;
    @BindView(R.id.description) TextView description;

    private SharedPreferences mSharedPreferences;
    private int STORAGE_PERMISSION_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String nameOne = mSharedPreferences.getString(Constants.FIRST_NAME_KEY, null);
        String nameTwo = mSharedPreferences.getString(Constants.LAST_NAME_KEY, null);
        String personEmail = mSharedPreferences.getString(Constants.EMAIL_KEY, null);
        String mobileNumber = mSharedPreferences.getString(Constants.PHONE_KEY, null);
        String personAddress = mSharedPreferences.getString(Constants.ADDRESS_KEY, null);
        String personDescription = mSharedPreferences.getString(Constants.DESCRIPTION_KEY, null);

        firstName.setText(nameOne);
        textView.setText(nameTwo);
        email.setText(personEmail);
        number.setText(mobileNumber);
        address.setText(personAddress);
        description.setText(personDescription);

        editPageOne.setOnClickListener(this);
        editPageTwo.setOnClickListener(this);
        finish.setOnClickListener(this);
        generate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == editPageOne){
            Intent intent = new Intent(this, DjangoFormActivity.class);
            intent.putExtra("edit",true);
            startActivity(intent);
        }
        if (v == editPageTwo){
            Intent intent = new Intent(this, DjangoFormTwoActivity.class);
            intent.putExtra("edit", true);
            startActivity(intent);
        }
        if (v == finish){
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


        }
        if (v == generate){
            createPdf();
        }
    }


    private void createPdf() {
        if (ContextCompat.checkSelfPermission(PreviewActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(PreviewActivity.this, "You have already granted permission",Toast.LENGTH_LONG).show();

        } else {

            requestStoragePersmission();
        }


        String nameOne = mSharedPreferences.getString(Constants.FIRST_NAME_KEY, null);
        String nameTwo = mSharedPreferences.getString(Constants.LAST_NAME_KEY, null);
        String personEmail = mSharedPreferences.getString(Constants.EMAIL_KEY, null);
        String mobileNumber = mSharedPreferences.getString(Constants.PHONE_KEY, null);
        String personAddress = mSharedPreferences.getString(Constants.ADDRESS_KEY, null);
        String personDescription = mSharedPreferences.getString(Constants.DESCRIPTION_KEY, null);


        PdfDocument document = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawText(nameOne, 80, 50, paint);
        canvas.drawText(nameTwo, 80, 70, paint);
        canvas.drawText(personEmail, 80, 90, paint);
        canvas.drawText(mobileNumber, 80, 110, paint);
        canvas.drawText(personAddress, 80, 130, paint);
        canvas.drawText(personDescription, 80, 150, paint);
        document.finishPage(page);
        pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 2).create();
        page = document.startPage(pageInfo);
        canvas = page.getCanvas();
        paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100, 100, 100, paint);
        document.finishPage(page);
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/mypdf/";
        File file = new File(directory_path);
        boolean wasSuccessful = true;
        if (!file.exists()) {
            wasSuccessful = file.mkdirs();
        }
        Toast.makeText(PreviewActivity.this, String.valueOf(wasSuccessful),Toast.LENGTH_LONG).show();
        String targetPdf = directory_path + "test-2.pdf";
        File filePath = new File(targetPdf);
        try {
            document.writeTo(new FileOutputStream(filePath));
//            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("main", "error " + e.toString());
//            Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        // close the document
        document.close();
    }

    private void requestStoragePersmission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){

            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed to create PDF documents")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(PreviewActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);

                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "PERMISSION DENIED", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
