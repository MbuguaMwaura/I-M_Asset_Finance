package com.example.assetfinance.ui;

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
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PreviewActivity extends AppCompatActivity implements View.OnClickListener {
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

    @BindView(R.id.age)
    TextView age;
    @BindView(R.id.occupation) TextView occupation;
    @BindView(R.id.employerName) TextView employerName;
    @BindView(R.id.address) TextView address;
    @BindView(R.id.telephoneNumber) TextView telephoneNumber;
    @BindView(R.id.position) TextView position;
    @BindView(R.id.yearsInCurrentPosition) TextView yearsInCurrentPosition;
    @BindView(R.id.status) TextView status;
    @BindView(R.id.spouse) TextView spouse;
    @BindView(R.id.spouseOccupation) TextView spouseOccupation;
    @BindView(R.id.employmentIncome) TextView employmentIncome;
    @BindView(R.id.selfIncome) TextView selfIncome;
    @BindView(R.id.spouseIncome) TextView spouseIncome;
    @BindView(R.id.livingExpenses) TextView livingExpenses;
    @BindView(R.id.loanRepayments) TextView loanRepayments;
    @BindView(R.id.otherIncomeBusiness) TextView otherIncomeBusiness;
    @BindView(R.id.disposableIncome)
    TextView disposableIncome;
    @BindView(R.id.other) TextView other;
    @BindView(R.id.nationality) TextView nationality;

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


//    @BindView(R.id.bankName)
//    TextView bankName;
//    @BindView(R.id.branch) TextView branch;
//    @BindView(R.id.accountNumber) TextView accountNumber;
//    @BindView(R.id.odLimit) TextView odLimit;
//    @BindView(R.id.outStandingLoans) TextView outStandingLoans;

    private SharedPreferences mSharedPreferences;
    private int STORAGE_PERMISSION_CODE = 1;



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
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);
        setTitle("PREVIEW");


        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);



        String inputName = mSharedPreferences.getString(Constants.ONE_NAME, null);
        String inputIDCERT = mSharedPreferences.getString(Constants.ONE_ID_CERT, null);
        String inputPin = mSharedPreferences.getString(Constants.ONE_PIN, null);
        String inputPoBox = mSharedPreferences.getString(Constants.ONE_PO_BOX, null);
        String inputPostalCode = mSharedPreferences.getString(Constants.ONE_POSTAL_CODE, null);
        String inputLocation = mSharedPreferences.getString(Constants.ONE_LOCATION, null);
        String inputNumber = mSharedPreferences.getString(Constants.ONE_PHONE_NUMBER, null);
        String inputOfficeNumber = mSharedPreferences.getString(Constants.ONE_OFFICE_NUMBER, null);
        String inputOwnerTenant = mSharedPreferences.getString(Constants.ONE_OWNER_TENANT, null);
        String inputLandlord = mSharedPreferences.getString(Constants.ONE_TENTANT_LANDLORD, null);
        String inputPoBoxLandLord = mSharedPreferences.getString(Constants.ONE_PO_BOX_LANDLORD, null);
        String inputPostalCodeLandord = mSharedPreferences.getString(Constants.ONE_POSTAL_CODE_LANDLORD, null);
        String inputNumberLandLord = mSharedPreferences.getString(Constants.ONE_PHONE_NUMBER_LANDLORD, null);
        String inputBusiness = mSharedPreferences.getString(Constants.ONE_NATURE_OF_BUSINESS, null);
        String inputYear = mSharedPreferences.getString(Constants.ONE_YEAR_BUSINESS, null);
        String inputIntroBy = mSharedPreferences.getString(Constants.ONE_INTRO_BY, null);
        String inputPurpose = mSharedPreferences.getString(Constants.ONE_PURPOSE, null);

        String inputAge = mSharedPreferences.getString(Constants.FOUR_AGE, null);
        String inputNationality = mSharedPreferences.getString(Constants.FOUR_NATIONALITY,null);
        String inputOccupation = mSharedPreferences.getString(Constants.FOUR_OCCUPATION, null);
        String inputEmployer = mSharedPreferences.getString(Constants.FOUR_EMPLOYER, null);
        String inputAddress = mSharedPreferences.getString(Constants.FOUR_ADDRESS, null);
        String inputTelNo = mSharedPreferences.getString(Constants.FOUR_TEL_NO, null);
        String inputPosition = mSharedPreferences.getString(Constants.FOUR_POSITION, null);
        String inputYears = mSharedPreferences.getString(Constants.FOUR_YEARS_IN_POSITION, null);
        String inputStatus = mSharedPreferences.getString(Constants.FOUR_STATUS, null);
        String inputSpouse = mSharedPreferences.getString(Constants.FOUR_NAME_SPOUSE, null);
        String inputSpouseOccupation = mSharedPreferences.getString(Constants.FOUR_SPOUSE_OCCUPATION,null);
        String inputIncome = mSharedPreferences.getString(Constants.FOUR_INCOME, null);
        String inputSelfIncome = mSharedPreferences.getString(Constants.FOUR_SELF_INCOME, null);
        String inputSpouseIncome = mSharedPreferences.getString(Constants.FOUR_SPOUSE_INCOME, null);
        String inputLivingExpenses = mSharedPreferences.getString(Constants.FOUR_LIVING_EXPENSES, null);
        String inputCurrentLoans = mSharedPreferences.getString(Constants.FOUR_CURRENT_LOAN_REPAYMENTS, null);
        String inputOtherIncome = mSharedPreferences.getString(Constants.FOUR_OTHER_INCOME, null);
        String inputNetDisposable = mSharedPreferences.getString(Constants.FOUR_NET_DISPOSABLE_INCOME, null);
        String inputOther = mSharedPreferences.getString("other", null);

        String inputDealerName = mSharedPreferences.getString(Constants.SIX_DEALER_NAME, null);
        String inputPostalAddress = mSharedPreferences.getString(Constants.SIX_POSTAL_ADDRESS_DEALER, null);
        String inputTelNoTwo = mSharedPreferences.getString(Constants.SIX_TEL_NO_DEALER, null);
        String inputInvoiceDate = mSharedPreferences.getString(Constants.SIX_INVOICE_DATE, null);
        String inputSalesPerson = mSharedPreferences.getString(Constants.SIX_SALES_PERSON, null);

        String inputMake = mSharedPreferences.getString(Constants.SEVEN_MAKE, null);
        String inputModelCC = mSharedPreferences.getString(Constants.SEVEN_MODEL_CC, null);
        String inputYearOfManufacture = mSharedPreferences.getString(Constants.SEVEN_YEAR_MANUFACTURE, null);
        String inputValuation = mSharedPreferences.getString(Constants.SEVEN_VALUATION, null);
        String inputInvoicePrice = mSharedPreferences.getString(Constants.SEVEN_INVOICE_PRICE, null);
        String inputDiscounts = mSharedPreferences.getString(Constants.SEVEN_DISCOUNT, null);
        String inputNetCost = mSharedPreferences.getString(Constants.SEVEN_NET_COST, null);
        String inputAccessoryName = mSharedPreferences.getString(Constants.SEVEN_ACCESSORY_OTHER, null);
        String inputAccessoryValue = mSharedPreferences.getString(Constants.SEVEN_VALUE, null);
        String inputTotalCost = mSharedPreferences.getString(Constants.SEVEN_TOTAL_COST, null);
        String inputDeposit = mSharedPreferences.getString(Constants.SEVEN_DEPOSIT, null);
        String inputBalanceOfCost = mSharedPreferences.getString(Constants.SEVEN_BALANCE_OF_COST, null);
        String inputVehicleState = mSharedPreferences.getString(Constants.SEVEN_VEHICLE_STATE,null);
        String inputInsurance = mSharedPreferences.getString(Constants.SEVEN_INSURANCE_OPTION,null);








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


        age.setText(inputAge);
        occupation.setText(inputOccupation);
        employerName.setText(inputEmployer);
        nationality.setText(inputNationality);
        address.setText(inputAddress);
        telephoneNumber.setText(inputTelNo);
        position.setText(inputPosition);
        yearsInCurrentPosition.setText(inputYears);
        status.setText(inputStatus);
        spouse.setText(inputSpouse);
        spouseOccupation.setText(inputSpouseOccupation);
        employmentIncome.setText(inputIncome);
        selfIncome.setText(inputSelfIncome);
        spouseIncome.setText(inputSpouseIncome);
        livingExpenses.setText(inputLivingExpenses);
        loanRepayments.setText(inputCurrentLoans);
        otherIncomeBusiness.setText(inputOtherIncome);
        other.setText(inputOther);
        disposableIncome.setText(inputNetDisposable);


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
//        canvas.drawBitmap();
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
       // Toast.makeText(PreviewActivity.this, String.valueOf(wasSuccessful),Toast.LENGTH_LONG).show();
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
