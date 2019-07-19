from django.contrib import admin
from . models import applicantBankDetails, Properties,additonalInfoIndividual,additonalInfoCompany,dealer,asset_details

# Register your models here.
admin.site.register(applicantBankDetails)
admin.site.register(Properties)
admin.site.register(additonalInfoIndividual)
admin.site.register(additonalInfoCompany)
admin.site.register(dealer)
admin.site.register(asset_details)

