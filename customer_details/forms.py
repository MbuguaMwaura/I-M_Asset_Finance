from django import forms
from .models import additonalInfo

class additonalInfoIndividual(forms.ModelForm):
    class Meta:
        model = additonalInfo
        fields = ['age','occupation','nationality','name_employer','address','contact','years','marital_status','spouse','occupation','income'.'spouse_income','living_expenses'.'loan_payment','income_business','others','disposable_income']
        