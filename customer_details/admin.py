from django.contrib import admin
from . models import *
from django.utils import timezone


class ApplicantAdmin(admin.ModelAdmin): 
    list_display = ('user','name','identification','pin','p_o_box','postalcode','city','physical_address','mobile','tel_home','owner','tenant ','p_o_box','postalcode','phone_no','business','yr_business','introlduced_by','purpose_of_asset_being_purchased')
    


    
    def set_application_to_complete(self,request,queryset):
        queryset.update(is_draft=false)
    set_application_to_complete.short_description = 'Mark completed forms as complete'


class applicantBankDetailsAdmin(admin.ModelAdmin):
    list_display =('applicant','bank_name','branch','account_number','od_limit','outstanding_loans')



   

    def set_application_to_complete(self,request,queryset):
        queryset.update(is_draft=false)
    set_application_to_complete.short_description = 'Mark completed forms as complete'

class PropertiesAdmin(admin.ModelAdmin):
    list_display = ('applicant','vehicle_reistration','model','loan_balance','financed_by','the_property','size','town','lr_number','approximate_value') 



   
    def set_application_to_complete(self,request,queryset):
        queryset.update(is_draft=false)
    set_application_to_complete.short_description = 'Mark completed forms as complete'

class additonalInfoIndividualAdmin(admin.ModelAdmin):
    list_display = ('applicant','age','occupation','nationality','name_employer','address','contact','years','marital_status','spouse','occupation','income','spouse_income','living_expenses','loan_payment','income_business','others','disposable_income' )


    

    def set_application_to_complete(self,request,queryset):
        queryset.update(is_draft=false)
    set_application_to_complete.short_description = 'Mark completed forms as complete'

class additonalInfoCompanyAdmin(admin.ModelAdmin):
    list_display = ('applicant','shareholders','annual_tunover','annual_profit','associate_companies')

    
   

    def set_application_to_complete(self,request,queryset):
        queryset.update(is_draft=false)
    set_application_to_complete.short_description = 'Mark completed forms as complete'
class dealerAdmin(admin.ModelAdmin):
    list_display = ('applicant','dealer_name','postal_address','telephone_number','invoice_number','sales_person')

    

   

    def set_application_to_complete(self,request,queryset):
        queryset.update(is_draft=false)
    set_application_to_complete.short_description = 'Mark completed forms as complete'
class DealerSupplierAdmin(admin.ModelAdmin):
    list_display = ('applicant' ,'dealername','postaladdress','telno','invoiceno_date','salesperson')

    

   

    def set_application_to_complete(self,request,queryset):
        queryset.update(is_draft=false)
    set_application_to_complete.short_description = 'Mark completed forms as complete'

class AssetDetailsAdmin(admin.ModelAdmin):
    list_display = ('applicant','make','new_used','invoice_price','rating','less','year','cost','valuation','add','insurance','interested','total','deposit','balance','loan','pricing','loan','repayment','repayment_amount','mode_payment','guarantor','security')

    

   

    def set_application_to_complete(self,request,queryset):
        queryset.update(is_draft=false)
    set_application_to_complete.short_description = 'Mark completed forms as complete'

class OtherCreditAdmin(admin.ModelAdmin):
    list_display = ('applicant','name','Facility_type','sanctioned_limit','current_outstanding')

   
   

    def set_application_to_complete(self,request,queryset):
        queryset.update(is_draft=false)
    set_application_to_complete.short_description = 'Mark completed forms as complete'



# Register your models here.
# admin.site.register(Applicant,ApplicantAdmin)
admin.site.register(ApplicantBankDetails,applicantBankDetailsAdmin)
admin.site.register(Properties,PropertiesAdmin)
admin.site.register(AdditonalInfoIndividual,additonalInfoIndividualAdmin)
admin.site.register(additonalInfoCompany,additonalInfoCompanyAdmin)
admin.site.register(dealer, dealerAdmin)
admin.site.register(DealerSupplier, DealerSupplierAdmin)
admin.site.register(AssetDetails,AssetDetailsAdmin)
admin.site.register(OtherCredit,OtherCreditAdmin)



