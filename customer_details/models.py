from django.db import models

# Create your models here.

class applicantBankDetails(models.Model):
    bank_name = models.CharField(_("Bank Name"), max_length = 200)
    branch = models.CharField(_("Branch"), max_length = 100)
    account_number = models.IntegerField(_("Account number"))
    od_limit = models.IntegerField("OD Limit")
    outstanding_loans = models.IntegerField(_("Outsatnding loans"))

class Properties(models.Model):
    vehicle_reistration = models.IntegerField(_("Vehicle registration number"))
    model = models.CharField(_("Model"), max_length=100)
    loan_balance = models.IntegerField(_("Balance of Loan if any"))  
    financed_by = models.CharField(_("Financed by"))
    the_property = models.CharField(_("Property(Residential/Commercial)"),max_length=50) 
    size = models.CharField(_("Size"))
    town = models.CharField(_("Town/Area",max_length = 100))
    lr_number = models.IntegerField("LR NO") 
    approximate_value = models.IntegerField(_("Approximate value"))




