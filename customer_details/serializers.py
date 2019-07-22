from rest_framework import serializers
from .models import Applicant,applicantBankDetails,Properties,additonalInfoIndividual,additonalInfoCompany,dealer,DealerSupplier,asset_details,OtherCredit

class ApplicantSerializer(serializers.ModelSerializer):
    class Meta:
        model = Applicant
        fields = ('yourname','passport','pin','p_o_box','postalcode','city_town','physical_address','mobile','home_officemobile','owner','tenant','tp_o_box','tpostalcode','tphonenumber','business','business2','business3','yrbusiness','introby','purpose')

class ApplicantBankSerializer(serializers.ModelSerializer):
    class Meta:
        model = ApplicantBankDetails
        fields = ('user_id','bank_name','branch','account_number','od_limit','outstanding_loans','bank_name2','branch2','account_number2','od_limit2','outstanding_loans2')

class PropertiesSerializer(serializer.ModelSerializer):
    class Meta:
        model = Properties
        fields = ('user_id','vehicle_registration','model','loan_balance','financed_by','the_property','size','town','lr_number','approximate_value')

class AdditonalIndvInfoSerializer(serializers.ModelSerializer):
    class Meta:
        model = additonalInfoIndividual
        fields = ('user_id','age','occupation','nationality','name_employer','address','contact','years','marital_status','spouse','occupation','income','spouse_income','living_expenses','loan_payment','income_business','others','disposable_income')

class AdditonalCompInfoSerializer(serializers.ModelSerializer):
    class Meta:
        model = additonalInfoCompany
        fields = ('user_id','shareholder','annual_turnover','annual_profit','associate_companies')

class DealerSerializer(serializers.ModelSerializer):
    class Meta:
        model = dealer
        fields = ('user_id','dealer_name','postal_address','telephone_number','invoice_number','sales_person')

class DealerSupplierSerializer(serializers.modelSerializer):
    class Meta:
        model =  DealerSupplier
        fields = ('dealername','postaladdress','telno','invoiceno_date','salesperson')

class AssetDetailsSerializer(serializers.modelSerializer):
    class Meta:
        model = asset_details
        fields = ('user_id','make','new_used','invoice_price','rating','less','year','cost','valuation','add','insurance','interested','total','deposit','balance','loan','repayment','repayment_amount','mode_payment','guarantor','security')

class OtherCredit(serializers.modelSerializer):
    class Meta:
        model = OtherCredit
        fields =('name','Facility_type','sanctioned_limit','current_outstanding')


