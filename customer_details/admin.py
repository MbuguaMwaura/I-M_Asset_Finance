from django.contrib import admin
from . models import *


class ApplicantAdmin(admin.ModelAdmin): 
    list_display = ('User','yourname','passport','pin','p_o_box','postalcode','city_town','physical_address','mobile','home_officemobile','owner','tenant','tp_o_box' ,'tpostalcode','tphonenumber','business','business2','business3','yrbusiness','introby','purpose','is_complete')
    list_filter = ('is_complete',)
    search_fields = ('User_exact',)
    

    


class applicantBankDetailsAdmin(admin.ModelAdmin):
    list_display =('user_id','bank_name','branch','account_number','od_limit','outstanding_loans','bank_name2','branch2','account_number2','od_limit2','outstanding_loans2','is_complete'
)

class PropertiesAdmin(admin.ModelAdmin):
    list_display = ('user_id','vehicle_reistration','model','loan_balance','financed_by','the_property','size','town','lr_number','approximate_value','is_complete' 
)

class additonalInfoIndividualAdmin(admin.ModelAdmin):
    list_display = ('user_id','age','occupation','nationality','name_employer','address','contact','years','marital_status','spouse','occupation','income','spouse_income','living_expenses','loan_payment','income_business','others','disposable_income' ,'is_complete'
)

class additonalInfoCompanyAdmin(admin.ModelAdmin):
    list_display = ('user_id','shareholders','annual_tunover','annual_profit','associate_companies','is_complete'
)

class dealerAdmin(admin.ModelAdmin):
    list_display = ('user_id','dealer_name','postal_address','telephone_number','invoice_number','sales_person','is_complete'
)

class DealerSupplierAdmin(admin.ModelAdmin):
    list_display = ('user_id' ,'dealername','postaladdress','telno','invoiceno_date','salesperson','is_complete'
)

class asset_detailsAdmin(admin.ModelAdmin):
    list_display = ('user_id','make','new_used','invoice_price','rating','less','year','cost','valuation','add','insurance','interested','total','deposit','balance','loan','pricing','loan','repayment','repayment_amount','mode_payment','guarantor','security','is_complete'
)

class OtherCreditAdmin(admin.ModelAdmin):
    list_display = ('user_id','name','Facility_type','sanctioned_limit','current_outstanding','is_complete'
)

# class DocumentAdmin(admin.ModelAdmin):
#     list_display = ('user_id','description','document','uploaded_at','is_complete')

# # Register your models here.
# admin.site.register(Applicant,ApplicantAdmin)
# admin.site.register(applicantBankDetails,applicantBankDetailsAdmin)
# admin.site.register(Properties,PropertiesAdmin)
# admin.site.register(additonalInfoIndividual,additonalInfoIndividualAdmin)
# admin.site.register(additonalInfoCompany,additonalInfoCompanyAdmin)
# admin.site.register(dealer,dealerAdmin)
# admin.site.register(DealerSupplier, DealerSupplierAdmin)
# admin.site.register(asset_details,asset_detailsAdmin)
# admin.site.register(OtherCredit,OtherCreditAdmin)
# admin.site.register(Document,DocumentAdmin)

