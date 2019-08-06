from django import forms

from .models import *

class ApplicantForm(forms.ModelForm):
    class Meta:
        model = Applicant
        exclude = ['user_id','date_added']
class applicantBankDetailsForm(forms.ModelForm):
    class Meta:
        model = ApplicantBankDetails
        exclude = ["date_added",'applicant']
class PropertiesForm(forms.ModelForm):
    class Meta:
        model = Properties
        exclude = ["date_added",'applicant']

class additonalInfoIndividualForm(forms.ModelForm):
    class Meta:
        model = AdditonalInfoIndividual
        exclude = ["date_added",'applicant','disposable_income']

class InfoCompanyForm(forms.ModelForm):
    class Meta:
        model = additonalInfoCompany

        exclude = ["date_added",'applicant']


class DealerForm(forms.ModelForm):
    class Meta:
        model = Dealer
        exclude = ["date_added",'applicant']
class DealerPostForm(forms.ModelForm):
    class Meta:
        model = DealerSupplier
        exclude = ["date_added",'applicant']


class AssetDetailsForm(forms.ModelForm):
    class Meta:
        model =AssetDetails

        exclude = ["date_added",'applicant']

class OtherCreditForm(forms.ModelForm):
    class Meta:
        model = OtherCredit
        exclude = ["date_added",'applicant']



class DocumentForm(forms.ModelForm):
    class Meta:
        model = Document
        exclude = ["date_added",'applicant']

