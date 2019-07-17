from django.db import models

# Create your models here.

class applicantBankDetails(models.Model):
    bank_name = models.CharField(_("Bank Name"), max_length = 200)
    branch = models.CharField(_("Branch"), max_length = 100)
    account_number = models.IntegerField(_("Account number"))
    od_limit = models.IntegerField("OD Limit")
    outstanding_loans = models.IntegerField(_("Outsatnding loans"))




