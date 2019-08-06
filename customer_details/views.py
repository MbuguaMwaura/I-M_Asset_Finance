from django.shortcuts import render,redirect
from .forms import *
from .models import *
from django.contrib.auth.models import User
from django.views import View
from django.contrib.auth.decorators import login_required



def welcome(request):
   return render(request, 'index.html')

@login_required(login_url='/accounts/login/')
def applicant(request):
   current_user = request.user
   if request.method =='POST':
       form = ApplicantForm(request.POST, request.FILES)
       print(form)
       if form.is_valid():
           print(form)
           applicant = form.save(commit=False)
           print(applicant)
           applicant.user_id = current_user

           try:
               exists = AppliedUsers.objects.filter(user_id=current_user)
               if not exists:
                   new_applied_user = AppliedUsers(user_id=current_user)
                   new_applied_user.save()
           except:
                print("Error occured!")


           
           applicant.save()
           latest_application = Applicant.objects.latest('id')
           return redirect(applicantbankdetails ,latest_application.id)
   else:
       form = ApplicantForm()
   return render(request, 'form.html', {"form":form})

@login_required(login_url='/accounts/login/')
def applicantbankdetails(request, id):
   current_user = request.user
   applicant_id = Applicant.objects.get(id=id)
   if request.method =='POST':
       form = applicantBankDetailsForm(request.POST, request.FILES)
       if form.is_valid():
           
           applicant = form.save(commit=False)
           applicant.applicant=applicant_id
           applicant.save()
           return redirect(properties, id)
   else:
       form = applicantBankDetailsForm()
   return render(request, 'form2.html', {"form":form, 'id': id})


@login_required(login_url='/accounts/login/')
def properties(request,id):
   current_user = request.user
   applicant_id = Applicant.objects.get(id=id)
   if request.method =='POST':
       form = PropertiesForm(request.POST, request.FILES)
       if form.is_valid():
           
           applicant = form.save(commit=False)
           applicant.applicant=applicant_id
           applicant.save()
           return redirect(additional, id)
   else:
       form = PropertiesForm()
   return render(request, 'form3.html', {"form":form, 'id':id})


@login_required(login_url='/accounts/login/')
def additional(request,id):
   current_user = request.user
   applicant_id = Applicant.objects.get(id=id)
   

   if request.method =='POST':
       form = additonalInfoIndividualForm(request.POST, request.FILES)
       if form.is_valid():
           
           applicant = form.save(commit=False)
           applicant.applicant=applicant_id
           applicant.disposable_income = (int(request.POST.get('income')) + int(request.POST.get('spouse_income')) + int(request.POST.get('income_business'))+ int(request.POST.get('others'))) - (int(request.POST.get('loan_payment')) + int(request.POST.get('living_expenses')))
           applicant.save()
           
           return redirect('additional1', id)
   else:
       form = additonalInfoIndividualForm()
   return render(request, 'form4.html', {"form":form, 'id':id})


@login_required(login_url='/accounts/login/')
def additional1(request, id):
   current_user = request.user
   applicant_id = Applicant.objects.get(id=id)
   if request.method =='POST':
       form = InfoCompanyForm(request.POST, request.FILES)
       if form.is_valid():
           
           applicant = form.save(commit=False)
           applicant.applicant=applicant_id
           applicant.save()
           return redirect( dealer,id)
   else:
       form = InfoCompanyForm()
   return render(request, 'form5.html', {"form":form, 'id':id})

@login_required(login_url='/accounts/login/')
def dealer(request,id):
   current_user = request.user
   applicant_id= Applicant.objects.get(id=id)
   if request.method =='POST':
       form = DealerForm(request.POST, request.FILES)
       if form.is_valid():
           applicant = form.save(commit=False)
           applicant.applicant=applicant_id

           applicant.save()
           return redirect(dealer1,id)
   else:
       form = DealerForm()
   return render(request, 'form6.html', {"form":form ,'id':id})

@login_required(login_url='/accounts/login/')
def dealer1(request,id):
   current_user = request.user
   applicant_id= Applicant.objects.get(id=id)
   if request.method =='POST':
       form = DealerPostForm(request.POST, request.FILES)
       if form.is_valid():
          
           applicant = form.save(commit=False)
           applicant.applicant=applicant_id
           applicant.save()
           return redirect(assetdetails,id)
   else:
       form = DealerPostForm()
   return render(request, 'form7.html', {"form":form,'id':id})

@login_required(login_url='/accounts/login/')
def assetdetails(request,id):
   current_user = request.user
   applicant_id = Applicant.objects.get(id=id)
   if request.method =='POST':
       form =  AssetDetailsForm(request.POST, request.FILES)
       if form.is_valid():
           applicant = form.save(commit=False)
           applicant.applicant=applicant_id


           applicant.save()
           return redirect(otherdetail,id)
   else:
       form =  AssetDetailsForm()
   return render(request, 'form8.html', {"form":form,'id':id})

@login_required(login_url='/accounts/login/')
def otherdetail(request,id):
   current_user = request.user
   applicant_id = Applicant.objects.get(id=id)
   if request.method =='POST':
       form = OtherCreditForm(request.POST, request.FILES)
       if form.is_valid():
           applicant = form.save(commit=False)
           applicant.applicant=applicant_id

           applicant.save()
           return redirect(documents,id)
   else:
       form = OtherCreditForm()
   return render(request, 'form9.html', {"form":form,'id':id})


@login_required(login_url='/accounts/login/')
def documents(request,id):
   current_user = request.user
   applicant_id = Applicant.objects.get(id=id)
   
   
   if request.method =='POST':
       form =  DocumentForm(request.POST, request.FILES)
       if form.is_valid():
           applicant = form.save(commit=False)
           applicant.applicant=applicant_id
           
           applicant.save()
           applicant=Applicant.objects.latest('id')
           bank_details = ApplicantBankDetails.objects.latest('id')
           properties = Properties.objects.latest('id')
           individual = AdditonalInfoIndividual.objects.latest('id')
           company = additonalInfoCompany.objects.latest('id')
           dealer = Dealer.objects.latest('id')
           supplier = DealerSupplier.objects.latest('id')
           asset_details = AssetDetails.objects.latest('id')
           other_credit = OtherCredit.objects.latest('id')
           document = Document.objects.latest('id')
           new_combined_forms = CombinedForms(applicant = applicant,bank_details=bank_details,properties = properties,individual= individual,company = company,dealer = dealer,  supplier = supplier,asset_details = asset_details,other_credit = other_credit,document = document)
           new_combined_forms.save()
           return redirect(welcome)
   else:
       form =  DocumentForm()
   return render(request, 'form10.html', {"form":form,'id':id})

# @login_required(login_url='/accounts/login/')
# def combined(request,id):




def admin_dashboard(request):
    applicants=Applicant.objects.all()
    users = User.objects.all()
    return render(request,'admin_dashboard.html',{'applicants':applicants,'users':users})

def single_user_admin(request,id):
    try:

        application=Applicant.objects.filter(user_id=id)
        properties = Properties.objects.filter(applicant=id)
        details =  ApplicantBankDetails.objects.filter(applicant=id)
        addInfo =  AdditonalInfoIndividual.objects.filter(applicant=id)
        addCompany =  additonalInfoCompany.objects.filter(applicant=id)
        dealer = Dealer.objects.filter(applicant=id)
        supplier =  DealerSupplier.objects.filter(applicant=id)
        asset =  AssetDetails.objects.filter(applicant=id)
        otherCredit = OtherCredit.objects.filter(applicant=id)
    except:
        print("Does not exist")
    # print(application)
    
    # print(details)
    
    
    

   
    return render(request,'single_user.html',{'application':application,'details':details,'properties':properties,'addInfo':addInfo,'addCompany':addCompany,'dealer':dealer,'supplier':supplier,'asset':asset,'otherCredit':otherCredit})
