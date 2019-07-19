from django.db import models
from django.contrib.auth.models import User

# Create your models here.

class applicantBankDetails(models.Model):
    user_id = models.ForeignKey(User)
    bank_name = models.CharField(max_length = 200)
    branch = models.CharField( max_length = 100)
    account_number = models.IntegerField()
    od_limit = models.IntegerField()
    outstanding_loans = models.IntegerField()
    # Forms 2
    bank_name2 = models.CharField( max_length = 200, default='Add another bank name')
    branch2 = models.CharField( max_length = 100)
    account_number2 = models.IntegerField()
    od_limit2 = models.IntegerField()
    outstanding_loans2 = models.IntegerField()
class Properties(models.Model):
    user_id = models.ForeignKey(User)
    vehicle_reistration = models.IntegerField()
    model = models.CharField( max_length=100)
    loan_balance = models.IntegerField()
    financed_by = models.CharField(max_length=100) 
    the_property = models.CharField(max_length=100) 
    size = models.CharField(max_length=100)
    town = models.CharField(max_length = 100)
    lr_number = models.IntegerField()
    approximate_value = models.IntegerField()

class additonalInfoIndividual(models.Model):
    user_id = models.ForeignKey(User)
    age = models.IntegerField()
    occupation = models.CharField( max_length=100)
    nationality = models.CharField( max_length=100)
    name_employer = models.CharField( max_length = 100)
    address = models.CharField( max_length=300)
    contact = models.IntegerField()
    years = models.IntegerField()
    marital_status= models.CharField(max_length=100)
    spouse = models.CharField( max_length=100) 
    occupation = models.CharField( max_length = 200)
    income = models.IntegerField()
    spouse_income = models.IntegerField()
    living_expenses = models.IntegerField()
    loan_payment = models.IntegerField()
    income_business = models.IntegerField()
    others=models.IntegerField()
    disposable_income = models.IntegerField()

class additonalInfoCompany(models.Model):
    user_id = models.ForeignKey(User)
    shareholders = models.CharField(max_length=100)
    annual_tunover = models.IntegerField()
    annual_profit = models.IntegerField()
    associate_companies = models.CharField(max_length=100)

class dealer(models.Model):
    user_id = models.ForeignKey(User)
    dealer_name = models.CharField( max_length=100)
    postal_address = models.IntegerField()
    telephone_number = models.IntegerField()
    invoice_number = models.IntegerField()
    sales_person = models.CharField(max_length=100)

  

class asset_details(models.Model):
    user_id = models.ForeignKey(User)
    make = models.CharField(max_length=100)
    new_used = models.CharField(max_length=100)
    invoice_price = models.IntegerField()
    rating = models.CharField(max_length = 100)
    less = models.IntegerField()
    year = models.IntegerField()
    cost = models.IntegerField()
    valuation = models.IntegerField()
    add = models.CharField(max_length=100)
    insurance = models.BooleanField ( default = True)
    interested   =  models.BooleanField ( default =True)
    total = models.IntegerField()
    deposit = models.IntegerField()
    balance = models.IntegerField()
    loan = models.IntegerField()
    pricing = models.IntegerField()
    loan = models.IntegerField()
    repayment = models.IntegerField()
    repayment_amount = models.IntegerField()
    mode_payment = models.IntegerField()
    guarantor = models.CharField(max_length=100)
    security = models.CharField(max_length=100)



    








class Applicant(models.Models):
  yourname = models.CharField(max_length=50, blank=True)
  passport = models.CharField(_('ID/passport/inc/cert of REG No.'), max_length=50)
  pin = models.CharField(_('Pin No.'), max_length=50)
  p_o_box = models.CharField(_('P.O.Box '), max_length=50)
  postalcode = models.CharField(_('postalcode'), max_length=50)
  city_town = models.CharField(max_length=50)
  physical_address = models.CharField(_('physical/address'), max_length=50)
  mobile = models.CharField(_('mobile'), max_length=50)
  home_officemobile = models.CharField(_('home/officemobile'), max_length=50)
  owner = models.CharField(_('owner'), max_length=50)
  tenant = models.CharField(_('tenant'), max_length=50)
  tp_o_box = models.CharField(_('tp.o.box'), max_length=50) 
  tpostalcode = models.CharField(_('tpostalcode'), max_length=50)
  tphoneno = models.CharField(_('tphoneno'), max_length=50)
  business = models.ManyToManyField(_('business'), max_length=50)
  yrbusiness = models.CharField(_('yrbusiness'), max_length=50)
  introby = models.CharField( max_length=50)
  purpose = models.CharField(_('purpose of assets being purchaced'), max_length=50)

  def __str__(self):
        return self.title

class DealerSupplier(models.Models):
  dealername = models.CharField(_('DEALER NAME'),max_length=50)
  postaladdress = models.CharField(_('postal address'), max_length=50)
  telno = models.IntegerField(_('tel phone no'), max_length=50)
  invoiceno_date = models.CharField(_('invoice date'), max_length=50)
  salesperson = models.CharField(_('sales'), max_length=50)
# def __str__(self):
#         return self.title

class OtherCredit(models.Models):
  name = models.CharField(_('Name'), max_length=50)
  Facility_type = models.CharField(_('Facility type'), max_length=50)
  sanctioned_limit = models.CharField(_('sanctioned limit'), max_length=50)
  current_outstanding = models.CharField(_('current outstanding'), max_length=50)
  

class Document(models.Model):
    description = models.CharField(max_length=255, blank=True)
    document = models.FileField(upload_to='documents/')
    uploaded_at = models.DateTimeField(auto_now_add=True)

