package com.example.assetfinance.ui.business;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.assetfinance.Constants;
import com.example.assetfinance.R;
import com.example.assetfinance.ui.ApplicantActivity;
import com.example.assetfinance.ui.PreviewActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessPreviewActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.editPageOne)
    TextView editPageOne;
//    @BindView(R.id.editPageTwo)
//    TextView editPageTwo;
//    @BindView(R.id.done)
//    Button finish;
//    @BindView(R.id.generate)
//    Button generate;

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.idNumber) TextView idNumber;
    @BindView(R.id.pinNumber) TextView pinNumber;
    @BindView(R.id.poBox) TextView poBox;
    @BindView(R.id.physicalLocation) TextView location;
    @BindView(R.id.mobileNumber) TextView mobileNumber;
    @BindView(R.id.officeNumber) TextView officeNumber;
    @BindView(R.id.ownerTenant) TextView ownerTenant;
    @BindView(R.id.tentant) TextView tenant;
    @BindView(R.id.poBox2) TextView poBoxTwo;
    @BindView(R.id.postalCodeTwo) TextView postalCodeTwo;
    @BindView(R.id.postalCode) TextView postalCode;
    @BindView(R.id.phonenumber) TextView phoneNumber;
    @BindView(R.id.businessNature) TextView businessNature;
    @BindView(R.id.yearOfBusiness) TextView yearOfBusiness;
    @BindView(R.id.introBy) TextView introBy;
    @BindView(R.id.purpose) TextView purpose;

    @BindView(R.id.bankName)
    TextView bankName;
    @BindView(R.id.branch) TextView branch;
    @BindView(R.id.accountNumber) TextView accountNumber;
    @BindView(R.id.odLimit) TextView odLimit;
    @BindView(R.id.outStandingLoans) TextView outStandingLoans;

    private SharedPreferences mSharedPreferences;
    private int STORAGE_PERMISSION_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);
        setTitle("PREVIEW");

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String inputName = mSharedPreferences.getString(Constants.ONE_BUSINESS_NAME, null);
        String inputIDCERT = mSharedPreferences.getString(Constants.ONE_BUSINESS_ID_CERT, null);
        String inputPin = mSharedPreferences.getString(Constants.ONE_BUSINESS_PIN, null);
        String inputPoBox = mSharedPreferences.getString(Constants.ONE_BUSINESS_PO_BOX, null);
        String inputPostalCode = mSharedPreferences.getString(Constants.ONE_BUSINESS_POSTAL_CODE, null);
        String inputLocation = mSharedPreferences.getString(Constants.ONE_BUSINESS_LOCATION, null);
        String inputNumber = mSharedPreferences.getString(Constants.ONE_BUSINESS_PHONE_NUMBER, null);
        String inputOfficeNumber = mSharedPreferences.getString(Constants.ONE_BUSINESS_OFFICE_NUMBER, null);
        String inputOwnerTenant = mSharedPreferences.getString(Constants.ONE_BUSINESS_OWNER_TENANT, null);
        String inputLandlord = mSharedPreferences.getString(Constants.ONE_BUSINESS_TENTANT_LANDLORD, null);
        String inputPoBoxLandLord = mSharedPreferences.getString(Constants.ONE_BUSINESS_PO_BOX_LANDLORD, null);
        String inputPostalCodeLandord = mSharedPreferences.getString(Constants.ONE_BUSINESS_POSTAL_CODE_LANDLORD, null);
        String inputNumberLandLord = mSharedPreferences.getString(Constants.ONE_BUSINESS_PHONE_NUMBER_LANDLORD, null);
        String inputBusiness = mSharedPreferences.getString(Constants.ONE_BUSINESS_NATURE_OF_BUSINESS, null);
        String inputYear = mSharedPreferences.getString(Constants.ONE_BUSINESS_YEAR_BUSINESS, null);
        String inputIntroBy = mSharedPreferences.getString(Constants.ONE_BUSINESS_INTRO_BY, null);
        String inputPurpose = mSharedPreferences.getString(Constants.ONE_BUSINESS_PURPOSE, null);



        name.setText(inputName);
        idNumber.setText(inputIDCERT);
        pinNumber.setText(inputPin);
        poBox.setText(inputPoBox);
        postalCode.setText(inputPostalCode);
        location.setText(inputLocation);
        mobileNumber.setText(inputNumber);
        officeNumber.setText(inputOfficeNumber);
        ownerTenant.setText(inputOwnerTenant);
        tenant.setText(inputLandlord);
        poBoxTwo.setText(inputPoBoxLandLord);
        postalCodeTwo.setText(inputPostalCodeLandord);
        phoneNumber.setText(inputNumberLandLord);
        businessNature.setText(inputBusiness);
        yearOfBusiness.setText(inputYear);
        introBy.setText(inputIntroBy);
        purpose.setText(inputPurpose);




//
        editPageOne.setOnClickListener(this);
//        editPageTwo.setOnClickListener(this);
//        finish.setOnClickListener(this);
//        generate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == editPageOne){
            Intent intent = new Intent(this, ApplicantActivity.class);
            intent.putExtra("edit",true);
            startActivity(intent);
        }
//        if (v == editPageTwo){
//            Intent intent = new Intent(this, DjangoFormTwoActivity.class);
//            intent.putExtra("edit", true);
//            startActivity(intent);
//        }
//        if (v == finish){
//            String nameOne = mSharedPreferences.getString(Constants.FIRST_NAME_KEY, null);
//            String nameTwo = mSharedPreferences.getString(Constants.LAST_NAME_KEY, null);
//            String personEmail = mSharedPreferences.getString(Constants.EMAIL_KEY, null);
//            String mobileNumber = mSharedPreferences.getString(Constants.PHONE_KEY, null);
//            String personAddress = mSharedPreferences.getString(Constants.ADDRESS_KEY, null);
//            String personDescription = mSharedPreferences.getString(Constants.DESCRIPTION_KEY, null);
//
//            final DjangoService djangoService = new DjangoService();
//            djangoService.post(nameOne, nameTwo, personEmail, mobileNumber, personAddress, personDescription, new Callback() {
//                @Override
//                public void onFailure(@NotNull Call call, @NotNull IOException e) {
//
//                }
//
//                @Override
//                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//
//                }
//            });
//
//
//        }
//        if (v == generate){
//            createPdf();
//        }
    }


//    private void createPdf() {
//        if (ContextCompat.checkSelfPermission(PreviewActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
//            Toast.makeText(PreviewActivity.this, "You have already granted permission",Toast.LENGTH_LONG).show();
//
//        } else {
//
//            requestStoragePersmission();
//        }
//
//
//        String nameOne = mSharedPreferences.getString(Constants.FIRST_NAME_KEY, null);
//        String nameTwo = mSharedPreferences.getString(Constants.LAST_NAME_KEY, null);
//        String personEmail = mSharedPreferences.getString(Constants.EMAIL_KEY, null);
//        String mobileNumber = mSharedPreferences.getString(Constants.PHONE_KEY, null);
//        String personAddress = mSharedPreferences.getString(Constants.ADDRESS_KEY, null);
//        String personDescription = mSharedPreferences.getString(Constants.DESCRIPTION_KEY, null);
//
//
//        PdfDocument document = new PdfDocument();
//        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
//        PdfDocument.Page page = document.startPage(pageInfo);
//        Canvas canvas = page.getCanvas();
//        Paint paint = new Paint();
//        paint.setColor(Color.BLACK);
//        canvas.drawText(nameOne, 80, 50, paint);
//        canvas.drawText(nameTwo, 80, 70, paint);
//        canvas.drawText(personEmail, 80, 90, paint);
//        canvas.drawText(mobileNumber, 80, 110, paint);
//        canvas.drawText(personAddress, 80, 130, paint);
//        canvas.drawText(personDescription, 80, 150, paint);
//        document.finishPage(page);
//        pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 2).create();
//        page = document.startPage(pageInfo);
//        canvas = page.getCanvas();
//        paint = new Paint();
//        paint.setColor(Color.BLUE);
//        canvas.drawCircle(100, 100, 100, paint);
//        document.finishPage(page);
//        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/mypdf/";
//        File file = new File(directory_path);
//        boolean wasSuccessful = true;
//        if (!file.exists()) {
//            wasSuccessful = file.mkdirs();
//        }
//        // Toast.makeText(PreviewActivity.this, String.valueOf(wasSuccessful),Toast.LENGTH_LONG).show();
//        String targetPdf = directory_path + "test-2.pdf";
//        File filePath = new File(targetPdf);
//        try {
//            document.writeTo(new FileOutputStream(filePath));
////            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
//        } catch (IOException e) {
//            Log.e("main", "error " + e.toString());
////            Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
//        }
//        // close the document
//        document.close();
//    }

    private void requestStoragePersmission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){

            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed to create PDF documents")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(BusinessPreviewActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);

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
        }    }
}
