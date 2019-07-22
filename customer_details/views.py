from django.shortcuts import render

from .forms import  ApplicantPostForm, applicantBankDetailsForm,PropertiesForm, additonalInfoIndividualForm, additonalInfoCompanyForm,dealerForm,DealerPostForm, asset_detailsForm,OtherCreditForm, DocumentForm
from .models import Applicant,applicantBankDetails,Properties,additonalInfoIndividual,additonalInfoCompany,dealer, DealerSupplier,asset_details,OtherCredit,Document
# Create your views here.


def welcome(request):
    form = ApplicantPostForm()
    return render(request,'forms/forms.html',{"forms": form})



def model_form_upload(request):
    if request.method == 'POST':
        form = DocumentForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            return redirect('welocme')
    else:
        form = DocumentForm()
    return render(request, '', {
        'form': form
    }) 
