from django import forms
from .models import *

class ApplicantForm(forms.ModelForm):
  class Meta:
    model = Applicant
    fields = ['NAME','IDENTIFICATION','PIN','P_O_BOX','POSTALCODE','CITY','PHYSICAL_ADDRESS','MOBILE','TEL_HOME','OWNER','TENANT','P_O_BOX','POSTALCODE','PHONE_NO','BUSINESS','YR_BUSINESS','INTRODUCED_BY','PURPOSE_OF_ASSET_BEING_PURCHASED']

class applicantBankDetailsForm(forms.ModelForm):
    class Meta:
        model = applicantBankDetails
        fields = ['bank_name','branch','account_number','od_limit','outstanding_loans','bank_name2','branch2','account_number2','od_limit2','outstanding_loans2']

class PropertiesForm(forms.ModelForm):
    class Meta:
        model = Properties
        fields = ['vehicle_reistration','model','loan_balance','financed_by','the_property','size','town','lr_number','approximate_value']

class additonalInfoIndividualForm(forms.ModelForm):
    class Meta:
        model = additonalInfoIndividual
        fields = ['age','occupation','nationality','name_employer','address','contact','years','marital_status','spouse','occupation','income','spouse_income','living_expenses','loan_payment','income_business','others','disposable_income']

class InfoCompanyForm(forms.ModelForm):
    class Meta:
        model = additonalInfoCompany
        fields = ['shareholders','annual_tunover','annual_profit','associate_companies']

class dealerForm(forms.ModelForm):
    class Meta:
        model = dealer
        fields = ['dealer_name','postal_address','telephone_number','invoice_number','sales_person']
class dealerPostForm(forms.ModelForm):
    class Meta:
        model = dealerSupplier
        fields = ['dealername','postaladdress','telno','invoiceno_date','salesperson']       

class asset_detailsForm(forms.ModelForm):
    class Meta:
        model = asset_details
        fields = ['make','new_used','invoice_price','rating','less','year','cost','valuation','add','insurance','interested','total','deposit','balance','loan','pricing','loan','repayment_amount','mode_payment','guarantor','security']

class OtherCreditForm(forms.ModelForm):
    class Meta:
        model = OtherCredit
        fields=['name','Facility_type','sanctioned_limit','current_outstanding']

class PhotoForm(forms.ModelForm):
    class Meta:
        model = Photo
        fields = ('file', )
