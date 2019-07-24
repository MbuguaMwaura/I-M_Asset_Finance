from django.shortcuts import render,redirect
from .forms import ApplicantForm,applicantBankDetailsForm
from .models import Applicant,DealerSupplier,OtherCredit,applicantBankDetails
from django.contrib.auth.models import User


# Create your views here.

def welcome(request):
    return render(request, 'index.html')

def applicant(request):
    current_user = request.user
    if request.method =='POST':
        form = ApplicantForm(request.POST, request.FILES)

        if form.is_valid():
            Applicant = form.save(commit=False)
            
            Applicant.save()
            return redirect('welcome')


    else:
        form = ApplicantForm()
    return render(request, 'form.html', {"form":form})

def applicantbankdetails(request):
    current_user = request.user
    if request.method =='POST':
        form = applicantBankDetailsForm(request.POST, request.FILES)

        if form.is_valid():
            Applicant = form.save(commit=False)
            
            Applicant.save()
            return redirect('welcome')


    else:
        form = applicantBankDetailsForm()
    return render(request, 'form2.html', {"form":form})
