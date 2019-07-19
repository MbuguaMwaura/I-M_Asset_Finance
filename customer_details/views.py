from django.shortcuts import render
# from uploads.core.models import Document
# from uploads.core.forms import DocumentForm
from .forms import ApplicantPostForm, DealerPostForm, DocumentForm
from .models import Applicant,DealerSupplier,Document,OtherCredit
# Create your views here.

# def applicant_create_view(request):
#     form = ApplicantPostForm()
#     if form.is_valid():
#         form.save()

def welcome(request):
    form = ApplicantPostForm()
    return render(request,'forms.html',{"forms": forms})



def model_form_upload(request):
    if request.method == 'POST':
        form = DocumentForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            return redirect('home')
    else:
        form = DocumentForm()
    return render(request, '', {
        'form': form
    }) 
