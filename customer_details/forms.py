from django import forms
from .models import CustomerDetails, Document

class ApplicantPostForm(forms.ModelForm):
  class Meta:
    model = Applicant
    fields = ['yourname','passport','pin','p_o_box','postalcode','city/town','physicaladdress','mobile','home/officemobile','owner','tenant','tp_o_box','tpostalcode','tphonenumber','business','yrbusiness','introby','purpose']

class DealerPostForm(forms.ModelForm):
  class Meta:
    models = DealerSupplier
    fields = ['dealername','postaladdress','telno','invoiceno_date','salesperson']

class DocumentForm(forms.ModelForm):
    class Meta:
        model = Document
        fields = ['description', 'document', ]