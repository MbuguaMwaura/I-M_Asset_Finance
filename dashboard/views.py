from django.shortcuts import render,redirect
from django.contrib.auth.models import User
from django.contrib.auth.decorators import login_required
from customer_details.models import CombinedForms, AppliedUsers, Applicant,ApplicantBankDetails,Properties,AdditonalInfoIndividual,additonalInfoCompany,Dealer,DealerSupplier,AssetDetails,OtherCredit,Document
from django.core.exceptions import ObjectDoesNotExist

# Create your views here.
@login_required(login_url='/accounts/login/')
def dashboard(request):
    current_user = request.user 
    # list_of_forms = CombinedForms.objects.select_related()
    all_users = AppliedUsers.objects.all()
    # all_users = set(all_users)
    # all_users = list(all_users)
    print(all_users)
    
    if not current_user.is_superuser:
        return redirect('/')
    # print('-' * 30)
    # print(list_of_forms)
    return render(request,'all_users.html', {'all_users':all_users})

@login_required(login_url='/accounts/login/')
def user_details(request,id):
    user_applicant = Applicant.objects.filter(user_id=id)
    username = User.objects.get(id=id)
    applicant_form_id = []
    for i in user_applicant:
        applicant_form_id.append(i.id)
    print('-' * 30)
    print(user_applicant)
    print(applicant_form_id)
    all_bank_details = []
    all_properties = []
    all_individual = []
    all_company = []
    all_dealer = []
    all_supplier = []
    all_asset = []
    
    all_document = []
    all_credit= []

    for i in applicant_form_id:
        applicant_id = Applicant.objects.get(id=i) 
        # all_details.append(user_applicant)
        try:
            bank_details = ApplicantBankDetails.objects.filter(applicant = i)
            all_bank_details.append(bank_details)
        except ObjectDoesNotExist:
            print("Does not exist")
            bank = ApplicantBankDetails(applicant=applicant_id)
            bank.save()
            bank_details = ApplicantBankDetails.objects.filter(applicant = i)
            all_bank_details.append(bank_details)

        try:
            properties = Properties.objects.filter(applicant = i)
            all_properties.append(properties)
        except ObjectDoesNotExist:
            prop = Properties(applicant=applicant_id)
            prop.save()
            properties = Properties.objects.filter(applicant = i)
            all_properties.append(properties)

        try:
            individual = AdditonalInfoIndividual.objects.filter(applicant = i)
            all_individual.append(individual)
        except ObjectDoesNotExist:
            individuals = AdditonalInfoIndividual(applicant = applicant_id)
            individuals.save()
            individual = AdditonalInfoIndividual.objects.filter(applicant = i)
            all_individual.append(individual)


        try:
            company = additonalInfoCompany.objects.filter(applicant = i)
            all_company.append(company)
        except ObjectDoesNotExist:
            companies = additonalInfoCompany(applicant = applicant_id)
            companies.save()
            company = additonalInfoCompany.objects.filter(applicant = i)
            all_company.append(company)



        try:
            dealer = Dealer.objects.filter(applicant = i)
            all_dealer.append(dealer)
        except ObjectDoesNotExist:
            dealers = Dealer(applicant = applicant_id)
            dealers.save()
            dealer = Dealer.objects.filter(applicant = i)
            all_dealer.append(dealer)

        try:
            supplier = DealerSupplier.objects.filter(applicant = i)
            all_supplier.append(supplier)
        except ObjectDoesNotExist:
            suppliers = DealerSupplier(applicant = applicant_id)
            suppliers.save()
            supplier = DealerSupplier.objects.filter(applicant = i)
            all_supplier.append(supplier)

        try:
            asset_details = AssetDetails.objects.filter(applicant = i)
            all_asset.append(asset_details)
        except ObjectDoesNotExist:
            assets = AssetDetails(applicant = applicant_id)
            assets.save()
            asset_details = AssetDetails.objects.filter(applicant = i)
            all_asset.append(asset_details)

        try:
            other_credit = OtherCredit.objects.filter(applicant = i)
            all_credit.append(other_credit)
        except ObjectDoesNotExist:
            others = OtherCredit(applicant = applicant_id)
            others.save()
            other_credit = OtherCredit.objects.filter(applicant = i)
            all_credit.append(other_credit)
        
        try:
            document = Document.objects.filter(applicant = i)
            all_document.append(document)
        except ObjectDoesNotExist:
            documents = Document(applicant = applicant_id)
            documents.save()
            document = Document.objects.filter(applicant = i)
            all_document.append(document)




        
    print(all_company)
    # for i in all_company:
    #     for t in i:
    #         print("Shareholders")
    #         print(t.shareholders)

    context = {
        "all_bank_details":all_bank_details ,











        
        
        
        
        
        
        
        "all_properties" :all_properties,
        "all_individual" :all_individual,
        "all_company" :all_company,
        "all_dealer" : all_dealer,
        "all_supplier" : all_supplier,
        "all_asset" : all_asset,
        
        "all_document" :all_document,
        "all_credit": all_credit,
        "user_applicant": user_applicant, 
        "username":username,
    }
    return render(request,'applicant_detail.html',context)


