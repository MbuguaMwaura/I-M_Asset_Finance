from django.contrib import admin
from . models import *

# Register your models here.
admin.site.register(Applicant)
admin.site.register(applicantBankDetails)
admin.site.register(Properties)
admin.site.register(additonalInfoIndividual)
admin.site.register(additonalInfoCompany)
admin.site.register(dealer)
admin.site.register(dealerSupplier)
admin.site.register(asset_details)
admin.site.register(OtherCredit)



