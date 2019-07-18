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


class additonalInfoIndividual(models.Model):
    age = models.IntegerField(_("Age"))
    occupation = models.CharField(_("Occupation"), max_length=100)
    nationality = models.CharField(_("Nationality"), max_length=100)
    name_employer = models.CharField(_("Name of Employer"), max_length = 100)
    address = models.CharField(_("Address"), max_length=300)
    contact = models.IntegerField(_("Phone Number"))
    years = models.IntegerField(_("No of Years in current position"))
    marital_status= models.CharField(_("Marital status"))
    spouse = models.CharField(_("Name of spouse"), max_length=100) 
    occupation = models.CharField(_("Occupation"), max_length = 200)
    income = models.IntegerField(_("Employment income/Net of stautoyy Deductions"))
    spouse_income = models.IntegerField(_("spouse's income"))
    living_expenses = models.IntegerField(_("Living expenses"))
    loan_payment = models.IntegerField(_("Current loan payment"))
    income_business = models.IntegerField(_("Other income business"))
    others=models.ImageField("Others eg rent ,farming")
    disposable_income = models.IntegerField(_("Total net disposable income"))

class additonalInfoCompany(model.Model):
    shareholders = models.CharField(_("Names of the shareholders/Partners "))
    annual_tunover = models.IntegerField(_("Annual Turnover(kes)"))
    annual_profit = models.IntegerField(_("Annual Net Profit"))
    associate_companies = models.CharField(_("Associate Companies (Where applicable)"))

class dealer(models.Model):
    dealer_name = models.CharField(_("Dealer name"), max_length=100)
    postal_address = models.IntegerField(_("Postal Address"))
    telephone_number = models.IntegerField(_("Telephone Number"))
    invoice_number = models.IntegerField(_("Invoice Number/Date"))
    sales_person = models.CharField(_("Sales Person"))

  

class asset_details(models.Model):
    make = models.CharField(_("Make"))
    new_used = models.CharField(_("New/Used"))
    invoice_price = models.IntegerField(_("Invoice Price"))
    rating = models.CharField(_("Model/Cc Rating"))
    less = models.IntegerField(_("Discounts"))
    year = models.IntegerField(_("Year of manufacture"))
    cost = models.IntegerField(_("Net cost"))
    valuation = models.IntegerField(_("Valuation Amount"))
    add = models.CharField(_("Accessories/others(where application)"))
    insurance = models.BooleanField (_("Insurance through I&M Insurance"), default = True)
    interested   =  models.BooleanField (_("Intrested in Insurance Finance(IPF)"), default =True)
    total = models.IntegerField(_("Total Cost"))
    deposit = models.IntegerField(_("Loss:Deposit"))
    balance = models.IntegerField(_("Balance of cost"))
    loan = models.IntegerField(_("Loan amount applied" ))
    pricing = models.IntegerField(_("Pricing Agreed"))
    loan = models.IntegerField(_("Tenor of loan"))
    repayment = models.IntegerField(_("Repayment Frequent"))
    repayment_amount = models.IntegerField(_("Repayment amount"))
    mode_payment = models.IntegerField(_("Mode of payment"))
    guarantor = models.CharField(_("Guarantor's Name(if any)"))
    security = models.CharField(_("Details of security provided by guarantor(If any)"))



    









