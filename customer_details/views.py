from django.shortcuts import render,redirect
from .forms import *
from .models import *
from django.contrib.auth.models import User
from django.contrib.auth.decorators import login_required
# Create your views here

@login_required(login_url='/accounts/login/')
def TemplateView(request):
    super_user = request.user
    all_Applicant = Applicant.objects.filter.all()
    all_applicantBankDetails = applicantBankDetails.objects.filter.all()
    all_Properties = Properties.objects.filter.all()
    all_additonalInfoIndividual = additonalInfoIndividual.objects.filter.all()
    all_additonalInfoCompany =additonalInfoCompany.objects.filter.all()
    all_dealer = dealer.objects.filter.all()
    all_DealerSupplier = DealerSupplier.objects.filter.all()
    all_asset_details = asset_details.objects.filter.all()
    all_OtherCredit = OtherCredit.objects.filter.all()
    all_Document = Document.objects.filter.all()

    return render(request,'admin.html',{"Applicant":all_Applicant, "applicantBankDetails":all_applicantBankDetails,"Properties":Properties," additonalInfoIndividual":all_additonalInfoIndividual,"additonalInfoCompany": all_additonalInfoCompany,"dealer":all_dealer,"DealerSupplier":all_DealerSupplier ,"asset_details":all_asset_details,"OtherCredit":all_OtherCredit,"Document":all_Document})

    


def welcome(request):
   return render(request, 'index.html')
   
def applicant(request):
   current_user = request.user
   if request.method =='POST':
       form = ApplicantForm(request.POST, request.FILES)
       if form.is_valid():
           Applicant = form.save(commit=False)
           applicant=current_user
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
def properties(request):
   current_user = request.user
   if request.method =='POST':
       form = PropertiesForm(request.POST, request.FILES)
       if form.is_valid():
           Applicant = form.save(commit=False)
           Applicant.save()
           return redirect('welcome')
   else:
       form = PropertiesForm()
   return render(request, 'form3.html', {"form":form})
def additional(request):
   current_user = request.user
   if request.method =='POST':
       form = additonalInfoIndividualForm(request.POST, request.FILES)
       if form.is_valid():
           Applicant = form.save(commit=False)
           Applicant.save()
           return redirect('welcome')
   else:
       form = additonalInfoIndividualForm()
   return render(request, 'form4.html', {"form":form})
def additional1(request):
   current_user = request.user
   if request.method =='POST':
       form = additonalInfoCompanyForm(request.POST, request.FILES)
       if form.is_valid():
           Applicant = form.save(commit=False)
           Applicant.save()
           return redirect('welcome')
   else:
       form = additonalInfoCompanyForm()
   return render(request, 'form5.html', {"form":form})
def dealer(request):
   current_user = request.user
   if request.method =='POST':
       form = dealerForm(request.POST, request.FILES)
       if form.is_valid():
           Applicant = form.save(commit=False)
           Applicant.save()
           return redirect('welcome')
   else:
       form = dealerForm()
   return render(request, 'form6.html', {"form":form})
def dealer1(request):
   current_user = request.user
   if request.method =='POST':
       form = DealerPostForm(request.POST, request.FILES)
       if form.is_valid():
           Applicant = form.save(commit=False)
           Applicant.save()
           return redirect('welcome')
   else:
       form = DealerPostForm()
   return render(request, 'form7.html', {"form":form})
def assetdetails(request):
   current_user = request.user
   if request.method =='POST':
       form = asset_detailsForm(request.POST, request.FILES)
       if form.is_valid():
           Applicant = form.save(commit=False)
           Applicant.save()
           return redirect('welcome')
   else:
       form = asset_detailsForm()
   return render(request, 'form8.html', {"form":form})
def otherdetail(request):
   current_user = request.user
   if request.method =='POST':
       form = OtherCreditForm(request.POST, request.FILES)
       if form.is_valid():
           Applicant = form.save(commit=False)
           Applicant.save()
           return redirect('welcome')
   else:
       form = OtherCreditForm()
   return render(request, 'form9.html', {"form":form})