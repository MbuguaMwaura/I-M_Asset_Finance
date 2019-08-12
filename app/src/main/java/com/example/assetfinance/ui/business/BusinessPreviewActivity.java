package com.example.assetfinance.ui.business;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assetfinance.Constants;
import com.example.assetfinance.R;
import com.example.assetfinance.adapters.FirebaseBankViewHolder;
import com.example.assetfinance.adapters.FirebaseCreditViewHolder;
import com.example.assetfinance.adapters.FirebasePropertyViewHolder;
import com.example.assetfinance.adapters.FirebaseVehicleViewHolder;
import com.example.assetfinance.models.BankDetails;
import com.example.assetfinance.models.Credit;
import com.example.assetfinance.models.Property;
import com.example.assetfinance.models.Vehicle;
import com.example.assetfinance.ui.ApplicantActivity;
import com.example.assetfinance.ui.PreviewActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessPreviewActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.editPageOne)
    TextView editPageOne;
    @BindView(R.id.recyclerViewBank)
    RecyclerView mRecyclerView;
    @BindView(R.id.recyclerViewVehicle)
    RecyclerView recyclerViewVehicle;
    @BindView(R.id.recyclerViewProperty) RecyclerView recyclerViewProperty;
    @BindView(R.id.recyclerViewCredit) RecyclerView recyclerViewCredit;
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

    @BindView(R.id.shareholder) TextView shareholder;
    @BindView(R.id.annualNetProfit) TextView annualNetProfit;
    @BindView(R.id.annualTurnover) TextView annualTurnover;
    @BindView(R.id.associateCompany) TextView associateCompany;

    @BindView(R.id.dealerName)
    TextView dealerName;
    @BindView(R.id.postalAddress) TextView postalAddress;
    @BindView(R.id.number) TextView number;
    @BindView(R.id.invoiceNoDate) TextView invoiceNoDate;
    @BindView(R.id.salesPerson) TextView salesPerson;

    @BindView(R.id.make)
    TextView make;
    @BindView(R.id.modelCC) TextView modelCC;
    @BindView(R.id.yearOfManufacture) TextView yearOfManucature;
    @BindView(R.id.valuation) TextView valuation;
    @BindView(R.id.invoicePrice) TextView invoicePrice;
    @BindView(R.id.discounts) TextView discount;
    @BindView(R.id.netCost)
    TextView netCost;
    @BindView(R.id.accessory) TextView accessory;
    @BindView(R.id.accessoryValue) TextView accesssoryValue;
    @BindView(R.id.totalCost) TextView totalCost;
    @BindView(R.id.deposit) TextView deposit;
    @BindView(R.id.balanceOfCost) TextView balanceOfCost;
    @BindView(R.id.vehicleState) TextView vehicleState;
    @BindView(R.id.insurance) TextView insurance;

    @BindView(R.id.individualId) TextView individualId;
    @BindView(R.id.individualBankStatements) TextView bankStatements;
    @BindView(R.id.individualBusinessPin) TextView businessPin;
    @BindView(R.id.individualCertificateReg) TextView businessCertificate;
    @BindView(R.id.individualContractCopies) TextView contracts;
    @BindView(R.id.individualPayslip) TextView payslip;
    @BindView(R.id.individualInvoice) TextView invoice;
    @BindView(R.id.individualPin) TextView pin;

    @BindView(R.id.signature)
    ImageView signature;
    @BindView(R.id.date) TextView date;




    private SharedPreferences mSharedPreferences;
    private int STORAGE_PERMISSION_CODE = 1;

    private ProgressDialog progressDialog;

    private ItemTouchHelper mItemTouchHelper;
    private DatabaseReference reference;
    private DatabaseReference referenceVehicle;
    private DatabaseReference referenceProperty;
    private DatabaseReference referenceCredit;
    private FirebaseRecyclerAdapter<BankDetails, FirebaseBankViewHolder> firebaseRecyclerAdapter;
    private FirebaseRecyclerAdapter<Vehicle, FirebaseVehicleViewHolder> firebaseRecyclerAdapterVehicle;
    private FirebaseRecyclerAdapter<Property, FirebasePropertyViewHolder> firebaseRecyclerAdapterProperty;
    private FirebaseRecyclerAdapter<Credit, FirebaseCreditViewHolder> firebaseRecyclerAdapterCredit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_preview);
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

        String inputShareholder = mSharedPreferences.getString(Constants.FIVE_BUSINESS_SHAREHOLDERS, null);
        String inputTurnover = mSharedPreferences.getString(Constants.FIVE_BUSINESS_TURNOVER, null);
        String inputNetProfit = mSharedPreferences.getString(Constants.FIVE_BUSINESS_NET_PROFIT, null);
        String inputAssociateCompanies = mSharedPreferences.getString(Constants.FIVE_BUSINESS_ASSOCIATE_COMPANIES, null);

        String inputDealerName = mSharedPreferences.getString(Constants.SIX_BUSINESS_DEALER_NAME, null);
        String inputPostalAddress = mSharedPreferences.getString(Constants.SIX_BUSINESS_POSTAL_ADDRESS_DEALER, null);
        String inputTelNoTwo = mSharedPreferences.getString(Constants.SIX_BUSINESS_TEL_NO_DEALER, null);
        String inputInvoiceDate = mSharedPreferences.getString(Constants.SIX_BUSINESS_INVOICE_DATE, null);
        String inputSalesPerson = mSharedPreferences.getString(Constants.SIX_BUSINESS_SALES_PERSON, null);

        String inputMake = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_MAKE, null);
        String inputModelCC = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_MODEL_CC, null);
        String inputYearOfManufacture = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_YEAR_MANUFACTURE, null);
        String inputValuation = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_VALUATION, null);
        String inputInvoicePrice = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_INVOICE_PRICE, null);
        String inputDiscounts = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_DISCOUNT, null);
        String inputNetCost = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_NET_COST, null);
        String inputAccessoryName = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_ACCESSORY_OTHER, null);
        String inputAccessoryValue = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_VALUE, null);
        String inputTotalCost = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_TOTAL_COST, null);
        String inputDeposit = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_DEPOSIT, null);
        String inputBalanceOfCost = mSharedPreferences.getString(Constants.SEVEN_BUSINESS_BALANCE_OF_COST, null);
        String inputVehicleState = mSharedPreferences.getString(Constants.SEVEN_VEHICLE_BUSINESS_STATE,null);
        String inputInsurance = mSharedPreferences.getString(Constants.SEVEN_INSURANCE_BUSINESS_OPTION,null);



        String inputIndividualId = mSharedPreferences.getString(Constants.NINE_BUSINESS_ID,"no document uploaded");
        String inputInvoice = mSharedPreferences.getString(Constants.NINE_BUSINESS_INVOICE,"no document uploaded");
        String inputPinCert = mSharedPreferences.getString(Constants.NINE_BUSINESS_CERTIFICATE,"no document uploaded");
        String inputPaySlip = mSharedPreferences.getString(Constants.NINE_BUSINESS_PAYSLIP,"no document uploaded");
        String inputBankStatements = mSharedPreferences.getString(Constants.NINE_BUSINESS_BANK_STATEMENTS,"no document uploaded");
        String inputBusinessPin = mSharedPreferences.getString(Constants.NINE_BUSINESS_BUSINESS_PIN,"no document uploaded");
        String inputCertificateREgistration = mSharedPreferences.getString(Constants.NINE_BUSINESS_BUSINESS_REG,"no document uploaded");
        String inputCopiesContract = mSharedPreferences.getString(Constants.NINE_BUSINESS_CONTRACT_COPIES,"no document uploaded");

        String signUri = mSharedPreferences.getString("signaturebusiness","");
        String dateSigned = mSharedPreferences.getString("datebusiness","");

        try {
            Bitmap img= MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.parse(signUri));
            if(img!= null) {
                signature.setImageBitmap(img);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        date.setText(dateSigned);

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

        shareholder.setText(inputShareholder);
        annualTurnover.setText(inputTurnover);
        annualNetProfit.setText(inputNetProfit);
        associateCompany.setText(inputAssociateCompanies);

        dealerName.setText(inputDealerName);
        postalAddress.setText(inputPostalAddress);
        number.setText(inputTelNoTwo);
        invoiceNoDate.setText(inputInvoiceDate);
        salesPerson.setText(inputSalesPerson);

        make.setText(inputMake);
        modelCC.setText(inputModelCC);
        yearOfManucature.setText(inputYearOfManufacture);
        valuation.setText(inputValuation);
        invoicePrice.setText(inputInvoicePrice);
        discount.setText(inputDiscounts);
        netCost.setText(inputNetCost);
        accessory.setText(inputAccessoryName);
        accesssoryValue.setText(inputAccessoryValue);
        totalCost.setText(inputTotalCost);
        deposit.setText(inputDeposit);
        balanceOfCost.setText(inputBalanceOfCost);
        vehicleState.setText(inputVehicleState);
        insurance.setText(inputInsurance);

        individualId.setText(inputIndividualId);
        invoice.setText(inputInvoice);
        pin.setText(inputPinCert);
        payslip.setText(inputPaySlip);
        bankStatements.setText(inputBankStatements);
        businessPin.setText(inputBusinessPin);
        businessCertificate.setText(inputCertificateREgistration);
        contracts.setText(inputCopiesContract);


        reference = FirebaseDatabase.getInstance().getReference().child(inputIDCERT).child("bank_details");
        referenceVehicle =  FirebaseDatabase.getInstance().getReference().child(inputIDCERT).child("vehicle_details");
        referenceProperty = FirebaseDatabase.getInstance().getReference().child(inputIDCERT).child("property_details");
        referenceCredit = FirebaseDatabase.getInstance().getReference().child(inputIDCERT).child("credit_details");

        setUpFirebaseAdapter();
//
        editPageOne.setOnClickListener(this);
//        editPageTwo.setOnClickListener(this);
//        finish.setOnClickListener(this);
//        generate.setOnClickListener(this);
    }

    private void setUpFirebaseAdapter() {
        FirebaseRecyclerOptions<BankDetails> options = new FirebaseRecyclerOptions.Builder<BankDetails>()
                .setQuery(reference, BankDetails.class)
                .build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<BankDetails, FirebaseBankViewHolder>(options) {

            @NonNull
            @Override
            public FirebaseBankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bank_item, viewGroup, false);
                return new FirebaseBankViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull FirebaseBankViewHolder holder, int position, @NonNull BankDetails model) {
                holder.bindBank(model);
            }
        };
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);

        FirebaseRecyclerOptions<Vehicle> optionstwo = new FirebaseRecyclerOptions.Builder<Vehicle>()
                .setQuery(referenceVehicle, Vehicle.class)
                .build();
        firebaseRecyclerAdapterVehicle = new FirebaseRecyclerAdapter<Vehicle, FirebaseVehicleViewHolder>(optionstwo) {
            @NonNull
            @Override
            public FirebaseVehicleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vehicle_item, viewGroup, false);
                return new FirebaseVehicleViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull FirebaseVehicleViewHolder holder, int position, @NonNull Vehicle model) {
                holder.bindVehicle(model);
            }
        };
        recyclerViewVehicle.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerViewVehicle.setAdapter(firebaseRecyclerAdapterVehicle);

        FirebaseRecyclerOptions<Property> optionsthree = new FirebaseRecyclerOptions.Builder<Property>()
                .setQuery(referenceProperty,Property.class)
                .build();
        firebaseRecyclerAdapterProperty = new FirebaseRecyclerAdapter<Property, FirebasePropertyViewHolder>(optionsthree) {
            @Override
            protected void onBindViewHolder(@NonNull FirebasePropertyViewHolder holder, int position, @NonNull Property model) {
                holder.bindProperty(model);
            }

            @NonNull
            @Override
            public FirebasePropertyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.property_item, viewGroup,false);
                return new FirebasePropertyViewHolder(view);
            }
        };
        recyclerViewProperty.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerViewProperty.setAdapter(firebaseRecyclerAdapterProperty);

        FirebaseRecyclerOptions<Credit> optionsFour = new FirebaseRecyclerOptions.Builder<Credit>()
                .setQuery(referenceCredit,Credit.class)
                .build();
        firebaseRecyclerAdapterCredit = new FirebaseRecyclerAdapter<Credit, FirebaseCreditViewHolder>(optionsFour) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseCreditViewHolder holder, int position, @NonNull Credit model) {
                holder.bindCredit(model);
            }

            @NonNull
            @Override
            public FirebaseCreditViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.credit_item, viewGroup,false);
                return new FirebaseCreditViewHolder(view);
            }
        };
        recyclerViewCredit.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerViewCredit.setAdapter(firebaseRecyclerAdapterCredit);

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

    @Override
    protected void onStart() {
        super.onStart();

        firebaseRecyclerAdapterProperty.startListening();
        firebaseRecyclerAdapter.startListening();
        firebaseRecyclerAdapterVehicle.startListening();
        firebaseRecyclerAdapterCredit.startListening();

    }
    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseRecyclerAdapterVehicle != null && firebaseRecyclerAdapter !=null && firebaseRecyclerAdapterProperty !=null && firebaseRecyclerAdapterCredit !=null)  {
            firebaseRecyclerAdapter.stopListening();
            firebaseRecyclerAdapterVehicle.stopListening();
            firebaseRecyclerAdapterProperty.stopListening();
        }
    }

}
