from django.db import models
from django.contrib.auth.models import User

# Create your models here.

class Applicant(models.Model):
  User = models.AutoField(primary_key=  True)
  yourname = models.CharField(max_length=50, blank=True)
  passport = models.CharField( max_length=50)
  pin = models.CharField(max_length=50)
  p_o_box = models.CharField( max_length=50)
  postalcode = models.CharField(max_length=50)
  city_town = models.CharField(max_length=50)
  physical_address = models.CharField( max_length=50)
  mobile = models.CharField( max_length=50)
  home_officemobile = models.CharField( max_length=50)
  owner = models.CharField( max_length=50)
  tenant = models.CharField( max_length=50)
  tp_o_box = models.CharField( max_length=50) 
  tpostalcode = models.CharField(max_length=50)
  tphonenumber = models.CharField( max_length=50)
  business = models.CharField( max_length=50)
  business2 = models.CharField( max_length=50)
  business3 = models.CharField( max_length=50)
  yrbusiness = models.CharField( max_length=50)
  introby = models.CharField( max_length=50)
  purpose = models.CharField( max_length=50)
  is_complete = models.BooleanField(default=True)




  def __str__(self):
        return self.yourname


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
    is_complete = models.BooleanField(default=True)

    def __str__(self):
        return self.user_id

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
    is_complete = models.BooleanField(default=True)

    def __str__(self):
        return self.user_id

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
    is_complete = models.BooleanField(default=True)

    def __str__(self):
        return self.user_id



class additonalInfoCompany(models.Model):
    user_id = models.ForeignKey(User)
    shareholders = models.CharField(max_length=100)
    annual_tunover = models.IntegerField()
    annual_profit = models.IntegerField()
    associate_companies = models.CharField(max_length=100)
    is_complete = models.BooleanField(default=True)

    def __str__(self):
        return self.user_id


class dealer(models.Model):
    user_id = models.ForeignKey(User)
    dealer_name = models.CharField( max_length=100)
    postal_address = models.IntegerField()
    telephone_number = models.IntegerField()
    invoice_number = models.IntegerField()
    sales_person = models.CharField(max_length=100)
    is_complete = models.BooleanField(default=True)

    def __str__(self):
        return self.user_id

class DealerSupplier(models.Model):
  user_id = models.ForeignKey(User)
  dealername = models.CharField(max_length=50)
  postaladdress = models.CharField( max_length=50)
  telno = models.IntegerField
  invoiceno_date = models.CharField( max_length=50)
  salesperson = models.CharField( max_length=50)
  is_complete = models.BooleanField(default=True)

  def __str__(self):
    return self.user_id

# def __str__(self):
#         return self.title


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
    is_complete = models.BooleanField(default=True)

    def __str__(self):
        return self.user_id



class OtherCredit(models.Model):
  user_id = models.ForeignKey(User)
  name = models.CharField(max_length=50)
  Facility_type = models.CharField( max_length=50)
  sanctioned_limit = models.CharField( max_length=50)
  current_outstanding = models.CharField(max_length=50)
  is_complete = models.BooleanField(default=True)

  def __str__(self):
    return self.user_id


class Document(models.Model):
    user_id = models.ForeignKey(User)
    description = models.CharField(max_length=255, blank=True)
    document = models.FileField(upload_to='documents/')
    uploaded_at = models.DateTimeField(auto_now_add=True)
    is_complete = models.BooleanField(default=True)

    def __str__(self):
        return self.user_id

