 // Your web app's Firebase configuration

 var firebaseConfig = {
   apiKey: "AIzaSyC89jREm-d0nQW_bh2kwOdVJ1vgSHFx2kg",
   authDomain: "i-m-asset-finance.firebaseapp.com",
   databaseURL: "https://i-m-asset-finance.firebaseio.com",
   projectId: "i-m-asset-finance",
   storageBucket: "i-m-asset-finance.appspot.com",
   messagingSenderId: "1025108421687",
   appId: "1:1025108421687:web:e97eeb1efa876011"
 };
 // Initialize Firebase
 firebase.initializeApp(firebaseConfig);



 var ref = firebase.database().ref('/');
 ref.on('value', gotData, errData);

 function gotData(data) {
  var newItems = document.querySelectorAll('.newUser');
     for (var i = 0; i < newItems.length; i++) {
       newItems[i].remove();
     }


   var object = data.val();
   var keys = Object.keys(object);
   console.log(object.upload);
   var dom = document.getElementById('list');
   for (var i = 0; i < keys.length; i++) {

     var div = document.createElement('div');
     div.className = "col s12 m12 newUser";

     dom.appendChild(div);

     var divTwo = document.createElement('div');
     divTwo.className = "card-panel z-depth-3";



     div.appendChild(divTwo);


     var name = object[keys[i]].applicant_details.name;
     var userIdNumber = object[keys[i]].applicant_details.idNumber;

     var liTwo = document.createElement('h6');
     liTwo.textContent = userIdNumber;
     liTwo.className = "center"
     var li = document.createElement('h5');
     li.textContent = name;
     li.value = name;
     li.className = "center "

     divTwo.appendChild(li);
     divTwo.appendChild(liTwo);

    //  console.log(li.value);
     //  li.parent('list');



   }


 }

 function errData(err) {
   console.log('Error!');
   console.log(err);
 }
 

 function applicant() {


   var applicant = document.getElementById('inputField').value;
   var ref = firebase.database().ref(applicant);
   ref.on('value', getData, errorData);
   // 
   // var clearDom = document.getElementById('resultTwo');
   // clearDom.remove(newItems);

   function getData(data) {
     var newItems = document.querySelectorAll('.new');
     for (var i = 0; i < newItems.length; i++) {
       newItems[i].remove();
     }

     var object = data.val();
     // console.log(object.bank_details);

     var form = document.createElement('div');
     form.className = "border";

     var applicantCard = document.getElementById('applicant');
     applicantCard.className = 'card-panel z-depth-3';
     document.getElementById("name").innerHTML = "Name:  " + object.applicant_details.name;
     document.getElementById("idnumber").innerHTML = "ID Number:  " + object.applicant_details.idNumber;
     document.getElementById("pin_no").innerHTML = "PIN Number:  " + object.applicant_details.pinNumber;
     document.getElementById("postalcode").innerHTML = "Postal Code:  " + object.applicant_details.postalCode;
     document.getElementById("pobox").innerHTML = "PO Box:  " + object.applicant_details.homeaddress;
     document.getElementById("location").innerHTML = "Physical Location:  " + object.applicant_details.physicalAddress;
     document.getElementById("number").innerHTML = "Mobile Number:  " + object.applicant_details.mobileNumber;
     document.getElementById("officenumber").innerHTML = "Office Number:  " + object.applicant_details.officeNumber;
     document.getElementById("ownerTenant").innerHTML = "Owner/Tentant:  " + object.applicant_details.ownerTenant;
     document.getElementById("tenant").innerHTML = "Name of Landlord:  " + object.applicant_details.landLord;
     document.getElementById("poboxLandlord").innerHTML = "PO Box:  " + object.applicant_details.postalCodeAddress;
     document.getElementById("postalcodeLandlord").innerHTML = "Postal Code:  " + object.applicant_details.address;
     document.getElementById("numberLandlord").innerHTML = "Phone Number:  " + object.applicant_details.phoneNumber;
     document.getElementById("natureBusiness").innerHTML = "Nature of Business:  " + object.applicant_details.natureOfBusiness;
     document.getElementById("yearBusiness").innerHTML = "Year Business was Established:  " + object.applicant_details.yearStartedBusiness;
     document.getElementById("introducedBy").innerHTML = "Introduced by:  " + object.applicant_details.introducedBy;
     document.getElementById("purpose").innerHTML = "Purpose of asset being purchased:  " + object.applicant_details.purposeOfAsset;

     var element = document.getElementById('result');

     var bank_details = object.bank_details;
     var bankKeys = Object.keys(bank_details);
     var dom = document.getElementById('resultTwo');




     for (var i = 0; i < bankKeys.length; i++) {
      var div = document.createElement('div');
      div.className = "col s12 m6 new";
 
     
      var divTwo = document.createElement('div');
      divTwo.className = "card-panel z-depth-3 new";
 
 
 
      div.appendChild(divTwo);

       var k = bankKeys[i];
       var savedBank = bank_details[k].bankName;
       var savedBranch = bank_details[k].branch;
       var savedAccount = bank_details[k].accountNumber;
       var savedOdLimit = bank_details[k].odLimit;
       var savedOutstandingLoans = bank_details[k].outStandingLoans;

       var pBank = document.createElement('p');
       pBank.textContent = 'Bank:  ' + savedBank;
       pBank.className = 'new';
       var pBranch = document.createElement('p');
       pBranch.textContent = 'Branch:  ' + savedBranch;
       pBranch.className = 'new';
       var pAccount = document.createElement('p');
       pAccount.textContent = 'Account Number:  ' + savedAccount;
       pAccount.className = 'new';
       var pOdLimit = document.createElement('p');
       pOdLimit.textContent = 'OD Limit:  ' + savedOdLimit;
       pOdLimit.className = 'new';
       var pOutstandingLoans = document.createElement('p');
       pOutstandingLoans.textContent = 'Outstanding Loans:  ' + savedOutstandingLoans;
       pOutstandingLoans.className = 'new';


       divTwo.append(pBank);
       divTwo.append(pBranch);
       divTwo.append(pAccount);
       divTwo.append(pOdLimit);
       divTwo.append(pOutstandingLoans);
       dom.append(div);

      




     }

     var vehicle_details = object.vehicle_details;
     var vehicleKeys = Object.keys(vehicle_details);
     var domThree = document.getElementById('resultThree');

     for(var i = 0; i< vehicleKeys.length;i++){
      var div = document.createElement('div');
      div.className = "col s12 m6 new";
 
     
      var divTwo = document.createElement('div');
      divTwo.className = "card-panel z-depth-3 new";
 
 
 
      div.appendChild(divTwo);

       var k = vehicleKeys[i];
       var savedregNo = vehicle_details[k].regNo;
       var savedmake = vehicle_details[k].make;
       var savedmodel = vehicle_details[k].model;
       var savedbalanceLoan = vehicle_details[k].balanceLoan;
       var savedfinancedBy = vehicle_details[k].financedBy;

      
       var pRegNo = document.createElement('p');
       pRegNo.textContent = 'Vehicle Registration Number:  ' + savedregNo;
       pRegNo.className = 'new';
       var pMake = document.createElement('p');
       pMake.textContent = 'Make:  ' + savedmake;
       pMake.className = 'new';
       var pModel = document.createElement('p');
       pModel.textContent = 'Model:  ' + savedmodel;
       pModel.className = 'new';
       var pBalanceLoan = document.createElement('p');
       pBalanceLoan.textContent = 'Balance Of Loan:  ' + savedbalanceLoan;
       pBalanceLoan.className = 'new';
       var pFinancedBy = document.createElement('p');
       pFinancedBy.textContent = 'Financed By:  ' + savedfinancedBy;
       pFinancedBy.className = 'new';

      
       divTwo.append(pRegNo);
       divTwo.append(pMake);
       divTwo.append(pModel);
       divTwo.append(pBalanceLoan);
       divTwo.append(pFinancedBy);
       domThree.append(div);

     }

     var property_details = object.property_details;
     var propertyKeys = Object.keys(property_details);
     var domThreeB = document.getElementById('resultThreeB');

     for(var i = 0; i<propertyKeys.length;i++){
      var div = document.createElement('div');
      div.className = "col s12 m6 new";
 
     
      var divTwo = document.createElement('div');
      divTwo.className = "card-panel z-depth-3 new";
 
 
 
      div.appendChild(divTwo);

       var k = propertyKeys[i];
       var savedproperty = property_details[k].property;
       var savedsize = property_details[k].size;
       var savedlocation = property_details[k].location;
       var savedlrNo = property_details[k].lrNo;
       var savedapproxValue = property_details[k].approxValue;

      
       var pProperty = document.createElement('p');
       pProperty.textContent = 'Property type:  ' + savedproperty;
       pProperty.className = 'new';
       var pSize = document.createElement('p');
       pSize.textContent = 'Size:  ' + savedsize;
       pSize.className = 'new';
       var pLocation = document.createElement('p');
       pLocation.textContent = 'Model:  ' + savedlocation;
       pLocation.className = 'new';
       var pLrNo = document.createElement('p');
       pLrNo.textContent = 'Balance Of Loan:  ' + savedlrNo;
       pLrNo.className = 'new';
       var pApproxValue = document.createElement('p');
       pApproxValue.textContent = 'Financed By:  ' + savedapproxValue;
       pApproxValue.className = 'new';

      divTwo.append(pProperty);
       divTwo.append(pSize);
       divTwo.append(pLocation);
       divTwo.append(pLrNo);
       divTwo.append(pApproxValue);
  
       domThreeB.append(div);

     }
     var additional_info_details = object.additional_info_details;
    //  var propertyKeys = Object.keys(property_details);
     var domFour = document.getElementById('resultFour');
    if(additional_info_details.annualNetProfit != ""){
      var div = document.createElement('div');
      div.className = "col s12 m6 new";
 
     
      var divTwo = document.createElement('div');
      divTwo.className = "card-panel z-depth-3 new";
 
 
 
      div.appendChild(divTwo);

      var savedAnnualProfit = additional_info_details.annualNetProfit;
      var savedAnnualTurnover = additional_info_details.annualTurnover;
      var savedCompanies = additional_info_details.companies;
      var savedShareholders = additional_info_details.shareholders;


      var pAnnualProfit = document.createElement('p');
      pAnnualProfit.textContent = 'Annual Net Profit:  ' + savedAnnualProfit;
      pAnnualProfit.className = 'new';
      var pAnnualTurnover = document.createElement('p');
      pAnnualTurnover.textContent = 'Annual Turnover:  ' + savedAnnualTurnover;
      pAnnualTurnover.className = 'new';
      var pCompanies = document.createElement('p');
      pCompanies.textContent = 'Associate Companies:  ' + savedCompanies;
      pCompanies.className = 'new';
      var pShareholders = document.createElement('p');
      pShareholders.textContent = 'Shareholders:  ' + savedShareholders;
      pShareholders.className = 'new';

      divTwo.append(pShareholders);
      divTwo.append(pAnnualProfit);
      divTwo.append(pAnnualTurnover);
      divTwo.append(pCompanies);
    
 
      domFour.append(div);

    }
    if(additional_info_details.address != ""){
      var div = document.createElement('div');
      div.className = "col s12 m6 new";
 
     
      var divTwo = document.createElement('div');
      divTwo.className = "card-panel z-depth-3 new";
 
 
 
      div.appendChild(divTwo);

      var savedAddress = additional_info_details.address;
      var savedAge = additional_info_details.age;
      var savedCurrentLoanRepayments = additional_info_details.currentLoanRepayments;
      var savedCurrentPosition= additional_info_details.currentPosition;
      var savedEmployerName = additional_info_details.employerName;
      var savedEmploymentIncome = additional_info_details.employmentIncome;
      var savedLivingExpense = additional_info_details.livingExpense;
      var savedMaritalStatus= additional_info_details.maritalStatus;
      var savedNameOfSpouse = additional_info_details.nameOfSpouse;
      var savedNationality = additional_info_details.nationality;
      var savedNetDisposableIncome = additional_info_details.netDisposableIncome;
      var savedOccupation= additional_info_details.occupation;
      var savedOther = additional_info_details.other;
      var savedOtherIncomeBusiness = additional_info_details.otherIncomeBusiness;
      var savedSelfIncome = additional_info_details.selfIncome;
      var savedSpouseIncome= additional_info_details.spouseIncome;
      var savedSpouseOccupation = additional_info_details.spouseOccupation;
      var savedTelNo= additional_info_details.telNo;
      var savedYearsInCurrentPosition = additional_info_details.yearsInCurrentPosition;



      var pAddress = document.createElement('p');
      pAddress.textContent = 'Address:  ' + savedAddress;
      pAddress.className = 'new';
      var pAge = document.createElement('p');
      pAge.textContent = 'Age:  ' + savedAge;
      pAge.className = 'new';
      var pCurrentLoanRepayments = document.createElement('p');
      pCurrentLoanRepayments.textContent = 'Current Loan Repayments:  ' + savedCurrentLoanRepayments;
      pCurrentLoanRepayments.className = 'new';
      var pCurrentPosition = document.createElement('p');
      pCurrentPosition.textContent = 'Current Position:  ' + savedCurrentPosition;
      pCurrentPosition.className = 'new';

      var pEmployerName = document.createElement('p');
      pEmployerName.textContent = 'Employer Name:  ' + savedEmployerName;
      pEmployerName.className = 'new';
      var pEmploymentIncome = document.createElement('p');
      pEmploymentIncome.textContent = 'Employment Income:  ' + savedEmploymentIncome;
      pEmploymentIncome.className = 'new';
      var pLivingExpense = document.createElement('p');
      pLivingExpense.textContent = 'Living Expense:  ' + savedLivingExpense;
      pLivingExpense.className = 'new';
      var pMaritalStatus = document.createElement('p');
      pMaritalStatus.textContent = 'Marital Status:  ' + savedMaritalStatus;
      pMaritalStatus.className = 'new';

      var pNameOfSpouse = document.createElement('p');
      pNameOfSpouse.textContent = 'Name of Spouse:  ' + savedNameOfSpouse;
      pNameOfSpouse.className = 'new';
      var pNationality = document.createElement('p');
      pNationality.textContent = 'Nationality:  ' + savedNationality;
      pNationality.className = 'new';
      var pNetDisposableIncome = document.createElement('p');
      pNetDisposableIncome.textContent = 'Net Disposable Income:  ' + savedNetDisposableIncome;
      pNetDisposableIncome.className = 'new';
      var pOccupation = document.createElement('p');
      pOccupation.textContent = 'Occupation:  ' + savedOccupation;
      pOccupation.className = 'new';

      var pOther = document.createElement('p');
      pOther.textContent = 'Other eg farming:  ' + savedOther;
      pOther.className = 'new';
      var pOtherIncomeBusiness = document.createElement('p');
      pOtherIncomeBusiness.textContent = 'Other Income Business:  ' + savedOtherIncomeBusiness;
      pOtherIncomeBusiness.className = 'new';
      var pSelfIncome = document.createElement('p');
      pSelfIncome.textContent = 'Self Income:  ' + savedSelfIncome;
      pSelfIncome.className = 'new';
      var pSpouseIncome = document.createElement('p');
      pSpouseIncome.textContent = 'Spouse Income:  ' + savedSpouseIncome;
      pSpouseIncome.className = 'new';

      var pSpouseOccupation = document.createElement('p');
      pSpouseOccupation.textContent = 'Spouse Occupation:  ' + savedSpouseOccupation;
      pSpouseOccupation.className = 'new';
      var pTelNo = document.createElement('p');
      pTelNo.textContent = 'Telephone Number:  ' + savedTelNo;
      pTelNo.className = 'new';
      var pYearsInCurrentPosition = document.createElement('p');
      pYearsInCurrentPosition.textContent = 'Years in Current Position:  ' + savedYearsInCurrentPosition;
      pYearsInCurrentPosition.className = 'new';
   


      divTwo.append(pAddress);
      divTwo.append(pAge);
      divTwo.append(pTelNo);
      divTwo.append(pOccupation);
      divTwo.append(pCurrentPosition);
      divTwo.append(pYearsInCurrentPosition);
      divTwo.append(pEmployerName);
      divTwo.append(pEmploymentIncome);
      divTwo.append(pMaritalStatus);
      divTwo.append(pNameOfSpouse);
      divTwo.append(pSpouseOccupation);
      divTwo.append(pNationality);
      divTwo.append(pLivingExpense);
      divTwo.append(pCurrentLoanRepayments);
      divTwo.append(pOther);
      divTwo.append(pOtherIncomeBusiness);
      divTwo.append(pSelfIncome);
      divTwo.append(pSpouseIncome);
      divTwo.append(pNetDisposableIncome);

    
    
 
      domFour.append(div);

    }

    var supplier_details = object.supplier_details;
    var domFive = document.getElementById('resultFive');

    var div = document.createElement('div');
    div.className = "col s12 m6 new";

   
    var divTwo = document.createElement('div');
    divTwo.className = "card-panel z-depth-3 new";



    div.appendChild(divTwo);
    var savedDealerName = supplier_details.dealerName;
      var savedInvoiceNoDate = supplier_details.invoiceNoDate;
      var savedPostalAddress = supplier_details.postalAddress;
      var savedSalesPerson= supplier_details.salesPerson;
      var savedTelephoneNumber = supplier_details.telephoneNumber;

      var pDealerName = document.createElement('p');
      pDealerName.textContent = 'Name of the Dealer:  ' + savedDealerName;
      pDealerName.className = 'new';
      var pTelephoneNumber = document.createElement('p');
      pTelephoneNumber.textContent = 'Telephone Number:  ' + savedTelephoneNumber;
      pTelephoneNumber.className = 'new';
      var pInvoiceNoDate = document.createElement('p');
      pInvoiceNoDate.textContent = 'InvoiceNo/Date:  ' + savedInvoiceNoDate;
      pInvoiceNoDate.className = 'new';
      var pPostalAddress = document.createElement('p');
      pPostalAddress.textContent = 'Postal Address:  ' + savedPostalAddress;
      pPostalAddress.className = 'new';
      var pSalesPerson = document.createElement('p');
      pSalesPerson.textContent = 'Sales Person:  ' + savedSalesPerson;
      pSalesPerson.className = 'new';

      divTwo.append(pDealerName);
      divTwo.append(pTelephoneNumber);
      divTwo.append(pPostalAddress);
      divTwo.append(pInvoiceNoDate);
      divTwo.append(pSalesPerson);
      domFive.append(div);
  

      var asset_details = object.asset_details;
      var domSix = document.getElementById('resultSix');
  
      var div = document.createElement('div');
      div.className = "col s12 m12 new";
      var divTwo = document.createElement('div');
      divTwo.className = "card-panel z-depth-3 new";
      div.appendChild(divTwo);

      var savedAccessories = asset_details.accessories;
      var savedAccessoriesValue = asset_details.accessoriesValue;
      var savedAssetState = asset_details.assetState;
      var savedBalanceOfCost = asset_details.balanceOfCost;
      var savedDeposit = asset_details.deposit;

      var savedDiscounts = asset_details.discounts;
      var savedInsuranceOption = asset_details.insuranceOption;
      var savedInvoicePrice = asset_details.invoicePrice;
      var savedMake = asset_details.make;
      var savedModelCc = asset_details.modelCc;


      var savedNetCost = asset_details.netCost;
      var savedTotalCost = asset_details.totalCost;
      var savedValuationAmount = asset_details.valuationAmount;
      var savedYearOfManufacture = asset_details.yearOfManufacture;
      
      var pAccessories = document.createElement('p');
      pAccessories.textContent = 'Accessories:  ' + savedAccessories;
      pAccessories.className = 'new';
      var pAccessoriesValue = document.createElement('p');
      pAccessoriesValue.textContent = 'Accessories Value:  ' + savedAccessoriesValue;
      pAccessoriesValue.className = 'new';
      var pAssetState = document.createElement('p');
      pAssetState.textContent = 'Asset State:  ' + savedAssetState;
      pAssetState.className = 'new';
      var pBalanceOfCost = document.createElement('p');
      pBalanceOfCost.textContent = 'Balance of Cost:  ' + savedBalanceOfCost;
      pBalanceOfCost.className = 'new';
      var pDeposit = document.createElement('p');
      pDeposit.textContent = 'Deposit:  ' + savedDeposit;
      pDeposit.className = 'new';

      var pDiscounts = document.createElement('p');
      pDiscounts.textContent = 'Discounts:  ' + savedDiscounts;
      pDiscounts.className = 'new';
      var pInsuranceOption = document.createElement('p');
      pInsuranceOption.textContent = 'InsuranceOption:  ' + savedInsuranceOption;
      pInsuranceOption.className = 'new';
      var pInvoicePrice = document.createElement('p');
      pInvoicePrice.textContent = 'Invoice Price:  ' + savedInvoicePrice;
      pInvoicePrice.className = 'new';
      var pMake = document.createElement('p');
      pMake.textContent = 'Make:  ' + savedMake;
      pMake.className = 'new';
      var pModelCc = document.createElement('p');
      pModelCc.textContent = 'Model/CC:  ' + savedModelCc;
      pModelCc.className = 'new';

      var pNetCost = document.createElement('p');
      pNetCost.textContent = 'Net Cost:  ' + savedNetCost;
      pNetCost.className = 'new';
      var pTotalCost = document.createElement('p');
      pTotalCost.textContent = 'Total Cost:  ' + savedTotalCost;
      pTotalCost.className = 'new';
      var pValuationAmount = document.createElement('p');
      pValuationAmount.textContent = 'Valuation Amount:  ' + savedValuationAmount;
      pValuationAmount.className = 'new';
      var pYearOfManufacture = document.createElement('p');
      pYearOfManufacture.textContent = 'Year of Manufacture:  ' + savedYearOfManufacture;
      pYearOfManufacture.className = 'new';
    
      divTwo.append(pMake);
      divTwo.append(pModelCc);
      divTwo.append(pInsuranceOption);
      divTwo.append(pAssetState);
      divTwo.append(pInvoicePrice);
      divTwo.append(pValuationAmount);
      divTwo.append(pYearOfManufacture);
  
      divTwo.append(pAccessories);
      divTwo.append(pAccessoriesValue);
   
     
      divTwo.append(pDeposit);

      divTwo.append(pDiscounts);
     
      divTwo.append(pBalanceOfCost);
      

      divTwo.append(pNetCost);
      divTwo.append(pTotalCost);
     
     domSix.append(div);

     var credit_details = object.credit_details;
     var creditKeys = Object.keys(credit_details);
     var domSeven = document.getElementById('resultSeven');

     for(var i = 0; i<creditKeys.length;i++){
      var div = document.createElement('div');
      div.className = "col s12 m6 new";
 
     
      var divTwo = document.createElement('div');
      divTwo.className = "card-panel z-depth-3 new";
 
 
 
      div.appendChild(divTwo);

       var k = creditKeys[i];
       var savedCurrentOutstanding = credit_details[k].currentOutstanding;
       var savedFacilityType = credit_details[k].facilityType;
       var savedName = credit_details[k].name;
       var savedSanctionedLimit = credit_details[k].sanctionedLimit;
      

      
       var pCurrentOutstanding = document.createElement('p');
       pCurrentOutstanding.textContent = 'Current Outstanding Balance:  ' + savedCurrentOutstanding;
       pCurrentOutstanding.className = 'new';
       var pFacilityType = document.createElement('p');
       pFacilityType.textContent = 'Facility Type:  ' + savedFacilityType;
       pFacilityType.className = 'new';
       var pName = document.createElement('p');
       pName.textContent = 'Name:  ' + savedName;
       pName.className = 'new';
       var pSanctionedLimit = document.createElement('p');
       pSanctionedLimit.textContent = 'Sanctioned Limit:  ' + savedSanctionedLimit;
       pSanctionedLimit.className = 'new';
    

       divTwo.append(pName);
       divTwo.append(pFacilityType);
      divTwo.append(pCurrentOutstanding)
       divTwo.append(pSanctionedLimit);
  
  
       domSeven.append(div);

    

 

       
     }


     var documents = object.documents;
    
     var domEight = document.getElementById('resultEight');

     var div = document.createElement('div');
     div.className = "col s12 m6 new";
    
     var divTwo = document.createElement('div');
     divTwo.className = "card-panel z-depth-3 new";



     div.appendChild(divTwo);
     var savedDoc1 = documents.id;
     var savedDoc2 = documents.invoice;
     var savedDoc3 = documents.payslip;
     var savedDoc4 = documents.pin;
     var savedDoc5 = documents.contract;
     var savedDoc6 = documents.certificate_reg;
     var savedDoc7 = documents.business_pin;
     var savedDoc8 = documents.bank_statements;
     

     var pDoc1 = document.createElement('a');
     pDoc1.href = savedDoc1;
     pDoc1.textContent = "Document One";
     pDoc1.className = 'new';
     var pDoc2 = document.createElement('a');
     pDoc2.href = savedDoc2;
     pDoc2.textContent = "Document Two";
     pDoc2.className = 'new';
     var pDoc3 = document.createElement('a');
     pDoc3.href = savedDoc3;
     pDoc3.textContent = "Document Three";
     pDoc3.className = 'new';
     var pDoc4 = document.createElement('a');
     pDoc4.href = savedDoc4;
     pDoc4.textContent = "Document Four";
     pDoc4.className = 'new';
     var pDoc5 = document.createElement('a');
     pDoc5.href = savedDoc5;
     pDoc5.textContent = "Document Five";
     pDoc5.className = 'new';
     var pDoc6 = document.createElement('a');
     pDoc6.href = savedDoc6;
     pDoc6.textContent = "Document Six";
     pDoc6.className = 'new';
     var pDoc7 = document.createElement('a');
     pDoc7.href = savedDoc7;
     pDoc7.textContent = "Document Seven";
     pDoc7.className = 'new';
     var pDoc8 = document.createElement('a');
     pDoc8.href = savedDoc8;
     pDoc8.textContent = "Document Eight";
     pDoc8.className = 'new';

     divTwo.append(pDoc1);
     divTwo.append(pDoc2);
    divTwo.append(pDoc3)
     divTwo.append(pDoc4);
     divTwo.append(pDoc5);
     divTwo.append(pDoc6);
    divTwo.append(pDoc7)
     divTwo.append(pDoc8);


       domEight.append(div);

       var signature = object.signature;
       var date = object.date;
       console.log(date);
    
       var domNine = document.getElementById('resultNine');
  
       var div = document.createElement('div');
       div.className = "col s12 m6 new";
      
       var divTwo = document.createElement('div');
       divTwo.className = "card-panel z-depth-3 new";

     div.appendChild(divTwo);
      var pSignText  =  document.createElement('p');
      pSignText.textContent = "Confirmation that the information given is true to the best of applicant's knowledge";
      pSignText.className = "new";
       var pSign = document.createElement('img');
       pSign.src = signature;
       pSign.className = 'new sign';
       var pDate = document.createElement('p');
       pDate.textContent = 'Date completed:  ' + date;
       pDate.className = 'new';
        divTwo.append(pSignText);
       divTwo.append(pSign)
       divTwo.append(pDate);
       
  domNine.append(div);
     
   }

   function errorData(err) {
     console.log('Error!');
     console.log(err);
   }
 }