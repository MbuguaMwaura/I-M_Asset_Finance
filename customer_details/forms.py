from django import forms

from .models import *

class ApplicantForm(forms.ModelForm):
    class Meta:
        model = Applicant
        fields = ['name' ,'identification','pin','p_o_box' ,'postalcode','city','physical_address' ,'mobile','tel_home','owner','tenant','p_o_box','postalcode','phone_no','business','yr_business','introlduced_by','purpose_of_asset_being_purchased']

class applicantBankDetailsForm(forms.ModelForm):
    class Meta:
        model = ApplicantBankDetails
        fields = ['bank_name','branch','account_number','od_limit','outstanding_loans']

class PropertiesForm(forms.ModelForm):
    class Meta:
        model = Properties
        fields = ['vehicle_reistration','model','loan_balance','financed_by','the_property','size','town','lr_number','approximate_value']

class additonalInfoIndividualForm(forms.ModelForm):
    class Meta:
        model = AdditonalInfoIndividual
        fields = ['age','occupation','nationality','name_employer','address','contact','years','marital_status','spouse','occupation','income','spouse_income','living_expenses','loan_payment','income_business','others','disposable_income']

class InfoCompanyForm(forms.ModelForm):
    class Meta:
        model = additonalInfoCompany

        fields = ['shareholders' ,'annual_tunover','annual_profit','associate_companies']


class dealerForm(forms.ModelForm):
    class Meta:
        model = dealer
        fields = ['dealer_name','postal_address','telephone_number','invoice_number','sales_person']
class dealerPostForm(forms.ModelForm):
    class Meta:
        model = DealerSupplier
        fields = ['dealername','postaladdress','telno','invoiceno_date','salesperson']       


class AssetDetailsForm(forms.ModelForm):
    class Meta:
        model =AssetDetails

        fields = ['make','new_used','invoice_price','rating','less','year','cost','valuation','add','insurance','interested','total','deposit','balance','loan','pricing','loan','repayment_amount','mode_payment','guarantor','security']

class OtherCreditForm(forms.ModelForm):
    class Meta:
        model = OtherCredit
        fields=['name','Facility_type','sanctioned_limit','current_outstanding']



class PhotoForm(forms.ModelForm):
    class Meta:
        model = Photo
        fields = ('file', )

