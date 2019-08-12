package com.example.assetfinance.ui;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assetfinance.Constants;
import com.example.assetfinance.R;
import com.example.assetfinance.models.IndividualDocument;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PDFTestActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.selectFileBtn)
    Button selectFileBtn;
    @BindView(R.id.upload) Button uploadBtn;
    @BindView(R.id.notification)
    TextView notification;
    @BindView(R.id.selectFileInvoiceBtn) Button selectFileInvoiceBtn;
    @BindView(R.id.notificationInvoice) TextView notificationInvoice;
    @BindView(R.id.selectFilePINBtn) Button selectPINBtn;
    @BindView(R.id.uploadPINBtn) Button uploadPINBtn;
    @BindView(R.id.notificationPIN) TextView notificationPIN;
    @BindView(R.id.selectFilePayslipBtn) Button selectFilePayslipBtn;
    @BindView(R.id.uploadPayslipBtn) Button uploadPayslipBtn;
    @BindView(R.id.notificationPayslip) TextView notificationPayslip;
    @BindView(R.id.selectFileStatementsBtn) Button selectStatements;
    @BindView(R.id.uploadStatementsBtn) Button uploadStatementBtn;
    @BindView(R.id.notificationStatements) TextView notificationStatements;
    @BindView(R.id.selectFileBusinessPINBtn) Button selectBusinessPINBtn;
    @BindView(R.id.uploadBusinessPINBtn) Button uploadBusinessPINBtn;
    @BindView(R.id.notificationBusinessPIN) TextView notificationBusinessPIN;
    @BindView(R.id.notificationBusinessReg) TextView notificationBusinessReg;
    @BindView(R.id.selectFileBusinessRegBtn) Button selectBusinessReg;
    @BindView(R.id.uploadBusinessRegBtn) Button uploadBusinessRegBtn;
    @BindView(R.id.notificationContract) TextView notificationContract;
    @BindView(R.id.selectFileContractBtn) Button selectContractBtn;
    @BindView(R.id.uploadContractBtn) Button uploadContractBtn;

    @BindView(R.id.uploadInvoiceBtn) Button uploadInvoiceBtn;


    @BindView(R.id.proceedEightTest) Button proceed;

    FirebaseStorage storage;
    FirebaseDatabase database;
    Uri pdfUri;
    Uri pdfInvoiceUri;
    Uri pdfPINUri;
    Uri pdfPayslip;
    Uri pdfStatements;
    Uri pdfBusinessPin;
    Uri pdfBusinessReg;
    Uri pdfContract;
    private StorageReference mStorageReference;
    ArrayList<IndividualDocument> documents = new ArrayList<>();

    ProgressDialog progressDialog;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdftest);
        ButterKnife.bind(this);
        setTitle("8. Upload Documents");

        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        selectFileBtn.setOnClickListener(this);
        uploadBtn.setOnClickListener(this);
        proceed.setOnClickListener(this);
        selectFileInvoiceBtn.setOnClickListener(this);
        uploadInvoiceBtn.setOnClickListener(this);
        selectPINBtn.setOnClickListener(this);
        uploadPINBtn.setOnClickListener(this);
        selectFilePayslipBtn.setOnClickListener(this);
        uploadPayslipBtn.setOnClickListener(this);
        selectStatements.setOnClickListener(this);
        uploadStatementBtn.setOnClickListener(this);
        selectBusinessPINBtn.setOnClickListener(this);
        uploadBusinessPINBtn.setOnClickListener(this);
        selectBusinessReg.setOnClickListener(this);
        uploadBusinessRegBtn.setOnClickListener(this);
        selectContractBtn.setOnClickListener(this);
        uploadContractBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == selectFileBtn){
            if (ContextCompat.checkSelfPermission(PDFTestActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                selectPdf();
            }else {
                ActivityCompat.requestPermissions(PDFTestActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
            }
        }
        if (v == uploadBtn){
            if (pdfUri != null){
                uploadFile(pdfUri);
            }else {
                Toast.makeText(this,"Please select a file", Toast.LENGTH_LONG).show();
            }
        }
        if (v == selectFileInvoiceBtn){
            selectPdfInvoice();
        }
        if (v == uploadInvoiceBtn){
            if (pdfInvoiceUri != null){
                uploadFileInvoice(pdfInvoiceUri);
            }else {
                Toast.makeText(this,"Please select a file", Toast.LENGTH_LONG).show();
            }
        }
        if (v == selectPINBtn){
            selectPdfPIN();
        }

        if (v == uploadPINBtn){
            if (pdfPINUri != null){
                uploadFilePIN(pdfPINUri);
            }else {
                Toast.makeText(this,"Please select a file", Toast.LENGTH_LONG).show();
            }
        }

        if (v == selectFilePayslipBtn){
            selectPdfPayslip();
        }
        if (v == uploadPayslipBtn){
            if (pdfPayslip != null){
                uploadFilePayslip(pdfPayslip);
            }else {
                Toast.makeText(this,"Please select a file", Toast.LENGTH_LONG).show();
            }
        }
        if (v== selectStatements){
            selectPdfStatements();
        }
        if (v == uploadStatementBtn){
            if (pdfStatements != null){
                uploadFileBankStatements(pdfStatements);
            }else {
                Toast.makeText(this,"Please select a file", Toast.LENGTH_SHORT).show();
            }
        }
        if (v == selectBusinessPINBtn){
            selectPdfBusinessPIN();
        }
        if (v == uploadBusinessPINBtn){
            if (pdfBusinessPin != null){
                uploadFileBusinessPin(pdfBusinessPin);
            }else {
                Toast.makeText(this,"Please select a file", Toast.LENGTH_SHORT).show();
            }
        }
        if (v == selectBusinessReg){
            selectPdfBusinessReg();
        }
        if (v == uploadBusinessRegBtn){
            if (pdfBusinessReg != null){
                uploadFileCertificateReg(pdfBusinessReg);
            }else {
                Toast.makeText(this,"Please select a file", Toast.LENGTH_SHORT).show();
            }
        }
        if (v == selectContractBtn){
            selectPdfContract();
        }
        if (v == uploadContractBtn){
            if (pdfContract != null){
                uploadFileContract(pdfContract);
            }else {
                Toast.makeText(this,"Please select a file", Toast.LENGTH_SHORT).show();
            }
        }

        if (v == proceed){
            Intent intent = new Intent(this, DeclarationActivity.class);
            startActivity(intent);
        }
    }

    private void uploadFile(Uri pdfUri) {
        progressDialog = new ProgressDialog(PDFTestActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setCancelable(false);
        progressDialog.setProgress(0);
        progressDialog.show();
        final String fileName = System.currentTimeMillis() + "";
        final StorageReference reference = storage.getReference();
        UploadTask uploadTask = reference.child("uploads").child(fileName).putFile(pdfUri);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    reference.child("uploads").child(fileName).getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {

                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()){

                            String inputID = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
                            DatabaseReference databaseReference = database.getReference();
                            databaseReference.child(inputID).child("documents").child("id").setValue(task.getResult().toString());

                            Toast.makeText(PDFTestActivity.this,"File successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }else{
                            Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress = (int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });


    }

    private void uploadFileInvoice(Uri pdfUri) {
        progressDialog = new ProgressDialog(PDFTestActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setCancelable(false);
        progressDialog.setProgress(0);
        progressDialog.show();
        final String fileName = System.currentTimeMillis() + "";
        final StorageReference reference = storage.getReference();
        UploadTask uploadTask = reference.child("uploads").child(fileName).putFile(pdfUri);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.child("uploads").child(fileName).getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {

                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()){

                            String inputID = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
                            DatabaseReference databaseReference = database.getReference();
                            databaseReference.child(inputID).child("documents").child("invoice").setValue(task.getResult().toString());

                            Toast.makeText(PDFTestActivity.this,"File successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }else{
                            Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress = (int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });


    }
    private void uploadFilePIN(Uri pdfUri) {
        progressDialog = new ProgressDialog(PDFTestActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setCancelable(false);
        progressDialog.setProgress(0);
        progressDialog.show();
        final String fileName = System.currentTimeMillis() + "";
        final StorageReference reference = storage.getReference();
        UploadTask uploadTask = reference.child("uploads").child(fileName).putFile(pdfUri);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.child("uploads").child(fileName).getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {

                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()){

                            String inputID = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
                            DatabaseReference databaseReference = database.getReference();
                            databaseReference.child(inputID).child("documents").child("pin").setValue(task.getResult().toString());

                            Toast.makeText(PDFTestActivity.this,"File successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }else{
                            Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress = (int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });


    }
    private void uploadFilePayslip(Uri pdfUri) {
        progressDialog = new ProgressDialog(PDFTestActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setCancelable(false);
        progressDialog.setProgress(0);
        progressDialog.show();
        final String fileName = System.currentTimeMillis() + "";
        final StorageReference reference = storage.getReference();
        UploadTask uploadTask = reference.child("uploads").child(fileName).putFile(pdfUri);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.child("uploads").child(fileName).getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {

                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()){

                            String inputID = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
                            DatabaseReference databaseReference = database.getReference();
                            databaseReference.child(inputID).child("documents").child("payslip").setValue(task.getResult().toString());

                            Toast.makeText(PDFTestActivity.this,"File successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }else{
                            Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress = (int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });


    }
    private void uploadFileBankStatements(Uri pdfUri) {
        progressDialog = new ProgressDialog(PDFTestActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setCancelable(false);
        progressDialog.setProgress(0);
        progressDialog.show();
        final String fileName = System.currentTimeMillis() + "";
        final StorageReference reference = storage.getReference();
        UploadTask uploadTask = reference.child("uploads").child(fileName).putFile(pdfUri);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.child("uploads").child(fileName).getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {

                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()){

                            String inputID = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
                            DatabaseReference databaseReference = database.getReference();
                            databaseReference.child(inputID).child("documents").child("bank_statements").setValue(task.getResult().toString());

                            Toast.makeText(PDFTestActivity.this,"File successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }else{
                            Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress = (int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });


    }
    private void uploadFileBusinessPin(Uri pdfUri) {
        progressDialog = new ProgressDialog(PDFTestActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setCancelable(false);
        progressDialog.setProgress(0);
        progressDialog.show();
        final String fileName = System.currentTimeMillis() + "";
        final StorageReference reference = storage.getReference();
        UploadTask uploadTask = reference.child("uploads").child(fileName).putFile(pdfUri);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.child("uploads").child(fileName).getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {

                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()){

                            String inputID = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
                            DatabaseReference databaseReference = database.getReference();
                            databaseReference.child(inputID).child("documents").child("business_pin").setValue(task.getResult().toString());

                            Toast.makeText(PDFTestActivity.this,"File successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }else{
                            Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress = (int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });


    }
    private void uploadFileCertificateReg(Uri pdfUri) {
        progressDialog = new ProgressDialog(PDFTestActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setCancelable(false);
        progressDialog.setProgress(0);
        progressDialog.show();
        final String fileName = System.currentTimeMillis() + "";
        final StorageReference reference = storage.getReference();
        UploadTask uploadTask = reference.child("uploads").child(fileName).putFile(pdfUri);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.child("uploads").child(fileName).getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {

                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()){

                            String inputID = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
                            DatabaseReference databaseReference = database.getReference();
                            databaseReference.child(inputID).child("documents").child("certificate_reg").setValue(task.getResult().toString());

                            Toast.makeText(PDFTestActivity.this,"File successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }else{
                            Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress = (int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });


    }
    private void uploadFileContract(Uri pdfUri) {
        progressDialog = new ProgressDialog(PDFTestActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setCancelable(false);
        progressDialog.setProgress(0);
        progressDialog.show();
        final String fileName = System.currentTimeMillis() + "";
        final StorageReference reference = storage.getReference();
        UploadTask uploadTask = reference.child("uploads").child(fileName).putFile(pdfUri);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.child("uploads").child(fileName).getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {

                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()){

                            String inputID = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
                            DatabaseReference databaseReference = database.getReference();
                            databaseReference.child(inputID).child("documents").child("contract").setValue(task.getResult().toString());

                            Toast.makeText(PDFTestActivity.this,"File successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }else{
                            Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(PDFTestActivity.this,"File not successfully uploaded", Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress = (int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });


    }

    private void selectPdf() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);
    }

    private void selectPdfInvoice() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,87);
    }
    private void selectPdfPIN() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,88);
    }
    private void selectPdfPayslip() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,89);
    }
    private void selectPdfStatements() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,90);
    }
    private void selectPdfBusinessPIN() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,91);
    }
    private void selectPdfBusinessReg() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,92);
    }
    private void selectPdfContract() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,93);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 9 && grantResults[0] ==  PackageManager.PERMISSION_GRANTED){
            selectPdf();
        }else {
            Toast.makeText(this,"Please provide persmission", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 86 && resultCode==RESULT_OK && data!=null){
            pdfUri = data.getData();

            String name = getFileName(pdfUri);

            addToSharedPreferences(Constants.NINE_ID,name);
//            String lastSegment = pathSegments.get(pathSegments.size() - 1);

            notification.setText("Selected file is: " + name);
        }

        else if(requestCode == 87 && resultCode==RESULT_OK && data!=null){
            pdfInvoiceUri = data.getData();

            String name = getFileName(pdfInvoiceUri);

            addToSharedPreferences(Constants.NINE_INVOICE,name);
//            String lastSegment = pathSegments.get(pathSegments.size() - 1);

            notificationInvoice.setText("Selected file is: " + name);
        }
        else if(requestCode == 88 && resultCode==RESULT_OK && data!=null){
            pdfPINUri = data.getData();

            String name = getFileName(pdfPINUri);

            addToSharedPreferences(Constants.NINE_PIN,name);
//            String lastSegment = pathSegments.get(pathSegments.size() - 1);

            notificationPIN.setText("Selected file is: " + name);
        }
        else if(requestCode == 89 && resultCode==RESULT_OK && data!=null){
            pdfPayslip = data.getData();

            String name = getFileName(pdfPayslip);

            addToSharedPreferences(Constants.NINE_PAYSLIP,name);
//            String lastSegment = pathSegments.get(pathSegments.size() - 1);

            notificationPayslip.setText("Selected file is: " + name);
        }
        else if(requestCode == 90 && resultCode==RESULT_OK && data!=null){
            pdfStatements = data.getData();

            String name = getFileName(pdfStatements);

            addToSharedPreferences(Constants.NINE_BANK_STATEMENTS,name);
//            String lastSegment = pathSegments.get(pathSegments.size() - 1);

            notificationStatements.setText("Selected file is: " + name);
        }
        else if(requestCode == 91 && resultCode==RESULT_OK && data!=null){
            pdfBusinessPin = data.getData();

            String name = getFileName(pdfBusinessPin);
            addToSharedPreferences(Constants.NINE_BUSINESS_PIN,name);
//            String lastSegment = pathSegments.get(pathSegments.size() - 1);

            notificationBusinessPIN.setText("Selected file is: " + name);
        } else if(requestCode == 92 && resultCode==RESULT_OK && data!=null){
            pdfBusinessReg = data.getData();

            String name = getFileName(pdfBusinessReg);
            addToSharedPreferences(Constants.NINE_BUSINESS_REG,name);
//            String lastSegment = pathSegments.get(pathSegments.size() - 1);

            notificationBusinessReg.setText("Selected file is: " + name);
        }
        else if(requestCode == 93 && resultCode==RESULT_OK && data!=null){
            pdfContract = data.getData();

            String name = getFileName(pdfContract);
            addToSharedPreferences(Constants.NINE_CONTRACT_COPIES,name);
//            String lastSegment = pathSegments.get(pathSegments.size() - 1);

            notificationContract.setText("Selected file is: " + name);
        }

        else {
            Toast.makeText(this,"Please select a file", Toast.LENGTH_SHORT).show();
        }


    }
    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (result == null) {
            result = uri.getLastPathSegment();
        }
        return result;
    }

    private void addToSharedPreferences(String constant, String document) {
        mEditor.putString(constant,document).apply();
    }

}
