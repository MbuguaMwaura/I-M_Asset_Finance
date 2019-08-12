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
   }

   function errorData(err) {
     console.log('Error!');
     console.log(err);
   }
 }