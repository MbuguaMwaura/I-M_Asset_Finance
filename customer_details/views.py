from django.shortcuts import render,redirect
from .forms import *
from .models import *
from django.contrib.auth.models import User
from django.views import View


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

def properties(request):
    current_user = request.user
    
    if request.method == 'POST':
        form = PropertiesForm(request.POST, request.FILES)
       
 
    else:
        form =PropertiesForm()
    return render(request, 'form3.html', {"form": form})

def additional(request):
    current_user = request.user
    
    if request.method == 'POST':
        form = additonalInfoIndividualForm(request.POST, request.FILES)
       
 
    else:
        form =additonalInfoIndividualForm()
    return render(request, 'form4.html', {"form": form})

def additional1(request):
    current_user = request.user
    
    if request.method == 'POST':
        form = InfoCompanyForm(request.POST, request.FILES)
       
 
    else:
        form = InfoCompanyForm()
    return render(request, 'form5.html', {"form": form})

def dealer(request):
    current_user = request.user
    
    if request.method == 'POST':
        form = dealerForm(request.POST, request.FILES)
       
 
    else:
        form =dealerForm()
    return render(request, 'form6.html', {"form": form})

def dealer1(request):
    current_user = request.user
    
    if request.method == 'POST':
        form = dealerPostForm(request.POST, request.FILES)
       
 
    else:
        form = dealerPostForm()
    return render(request, 'form7.html', {"form": form})

def assetdetails(request):
    current_user = request.user
    
    if request.method == 'POST':
        form = asset_detailsForm(request.POST, request.FILES)
       
 
    else:
        form =asset_detailsForm()
    return render(request, 'form8.html', {"form": form})

def otherdetail(request):
    current_user = request.user
    
    if request.method == 'POST':
        form = OtherCreditForm(request.POST, request.FILES)
       
 
    else:
        form =OtherCreditForm()
    return render(request, 'form9.html', {"form": form})


class BasicUploadView(View):
    def get(self, request):
        photos_list = Photo.objects.all()
        return render(self.request, 'photos/basic_upload/index.html', {'photos': photos_list})

    def post(self, request):
        form = PhotoForm(self.request.POST, self.request.FILES)
        if form.is_valid():
            photo = form.save()
            data = {'is_valid': True, 'name': photo.file.name, 'url': photo.file.url}
        else:
            data = {'is_valid': False}
        return JsonResponse(data)
