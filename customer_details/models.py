from django.db import models
from django.contrib.auth.models import User
from django.utils import timezone


class Applicant(models.Model):

  user=models.OneToOneField(User,on_delete=models.CASCADE, related_name="applicant",null=True)
  name = models.CharField(max_length=50, blank=True)
  identification= models.CharField( max_length=50, help_text='ID/PASSPORT/UNC/CERT. OF REG NO.')
  pin = models.CharField(max_length=50, help_text='PIN NUMBER')
  p_o_box = models.CharField( max_length=50, help_text='P.O.BOX NUMBER')
  postalcode = models.CharField(max_length=50)
  city = models.CharField(max_length=50,help_text='CITY/TOWN')
  physical_address = models.CharField( max_length=50,help_text='LOACTION/ROAD')
  mobile = models.IntegerField(help_text='TEL. MOBILE')
  tel_home = models.IntegerField(help_text='TEL. HOME/OFFICE NO.')
  owner = models.CharField( max_length=50, help_text='OWNER/TENANT')
  tenant = models.CharField( max_length=50,help_text='IF TENANT:NAME OF LANDLORD')
  p_o_box = models.CharField( max_length=50,help_text='TENANT P.O.BOX') 
  postalcode= models.CharField(max_length=50,help_text='TENANT POSTAL CODE')
  phone_no = models.IntegerField(help_text='TENANT PHONE NUMBER')
  business = models.CharField( max_length=50, help_text='NATURE OF BUSINESS')
  yr_business = models.CharField( max_length=50, help_text='YEAR OF BUSINESS ESTABLISHED')
  introlduced_by = models.CharField( max_length=50)
  purpose_of_asset_being_purchased = models.CharField( max_length=50)


  def __int__(self):
        return self.user_id

  def __str__(self):
      return self.user.username



class ApplicantBankDetails(models.Model):
    applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,null=True)
    bank_name = models.CharField(max_length = 200)
    branch = models.CharField( max_length = 100)
    account_number = models.IntegerField()
    od_limit = models.IntegerField()
    outstanding_loans = models.IntegerField()
    def __int__(self):
        return self.user_id

    class Meta:
        verbose_name_plural="ApplicantBankDetails"

class Properties(models.Model):
    applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,null=True)
    vehicle_reistration = models.IntegerField()
    model = models.CharField( max_length=100)
    loan_balance = models.IntegerField()
    financed_by = models.CharField(max_length=100) 
    the_property = models.CharField(max_length=100) 
    size = models.CharField(max_length=100)
    town = models.CharField(max_length = 100)
    lr_number = models.IntegerField()
    approximate_value = models.IntegerField()

    def __int__(self):
        return self.user_id

    class Meta:
        verbose_name_plural="Properties"


class AdditonalInfoIndividual(models.Model):
    applicant= models.OneToOneField(Applicant, on_delete=models.CASCADE,null=True)
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

    def __int__(self):
        return self.user_id

    class Meta:
        verbose_name_plural=" AdditonalInfoIndividual"



class additonalInfoCompany(models.Model):
    applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,null=True)
    shareholders = models.CharField(max_length=100)
    annual_tunover = models.IntegerField()
    annual_profit = models.IntegerField()
    associate_companies = models.CharField(max_length=100)
    is_complete = models.BooleanField(default=True)

    def __int__(self):
        return self.user_id

    class Meta:
        verbose_name_plural="additonalInfoCompany"


class dealer(models.Model):
    applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,null=True)
    dealer_name = models.CharField( max_length=100)
    postal_address = models.IntegerField()
    telephone_number = models.IntegerField()
    invoice_number = models.IntegerField()
    sales_person = models.CharField(max_length=100)
    is_complete = models.BooleanField(default=True)

    def __int__(self):
        return self.user_id


class DealerSupplier(models.Model):
  applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,null=True)

  dealername = models.CharField(max_length=50)
  postaladdress = models.CharField( max_length=50)
  telno = models.IntegerField()
  invoiceno_date = models.CharField( max_length=50)
  salesperson = models.CharField( max_length=50)

  def __int__(self):
    return self.user_id

  class Meta:
        verbose_name_plural="DealerSupplier"



class AssetDetails(models.Model):
    applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,null=True)
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

    def __int__(self):
        return self.user_id

    class Meta:
         verbose_name_plural ="AssetDetails"



class OtherCredit(models.Model):
  applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,null=True)
  name = models.CharField(max_length=50)
  Facility_type = models.CharField( max_length=50)
  sanctioned_limit = models.CharField( max_length=50)
  current_outstanding = models.CharField(max_length=50)


  def __int__(self):
    return self.user_id
    class Meta:
        verbose_name_plural=" OtherCredit"



  
class Photo(models.Model):
    title = models.CharField(max_length=255, blank=True)
    file = models.FileField(upload_to='photos/')
    uploaded_at = models.DateTimeField(auto_now_add=True)



