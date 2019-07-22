from django import forms
from .models import Applicant,applicantBankDetails,Properties,additonalInfoIndividual,additonalInfoCompany,dealer,DealerSupplier,asset_details,OtherCredit,Document

class ApplicantPostForm(forms.ModelForm):
  class Meta:
    model = Applicant
    fields = ['yourname','passport','pin','p_o_box','postalcode','city_town','physical_address','mobile','home_officemobile','owner','tenant','tp_o_box','tpostalcode','tphonenumber','business','business2','business3','yrbusiness','introby','purpose']

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

class additonalInfoCompanyForm(forms.ModelForm):
    class meta:
        model = additonalInfoCompany
        field = ['user_id' ,'shareholders' ,'annual_tunover','annual_profit','associate_companies']


class dealerForm(forms.ModelForm):
    class meta:
        model = dealer
        fields = ['dealer_name','postal_address','telephone_number','invoice_number','sales_person']
class DealerPostForm(forms.ModelForm):
    class Meta:
        models = DealerSupplier
        fields = ['dealername','postaladdress','telno','invoiceno_date','salesperson']       

class asset_detailsForm(forms.ModelForm):
    class meta:
        model = asset_details
        fields = ['make','new_used','invoice_price','rating','less','year','cost','valuation','add','insurance','interested','total','deposit','balance','loan','pricing','loan','repayment_amount','mode_payment','guarantor','security']
        labels = {'make':'','new_used':'','invoice_price':'','rating':'','less':'','year':'','cost':'','valuation':'','add':'','insurance':'label for insurance','interested':'label for interested','total':'','deposit':'','balance':'','loan':'','pricing':'','loan':'','repayment_amount':'','mode_payment':'','guarantor':'','security':''}

class OtherCreditForm(forms.ModelForm):
    class meta:
        model = OtherCredit
        fields=['name','Facility_type','sanctioned_limit','current_outstanding']
class DocumentForm(forms.ModelForm):
    class Meta:
        model = Document
        fields = ['description', 'document']
