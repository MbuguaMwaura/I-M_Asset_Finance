from django.db import models
from django.contrib.auth.models import User
from django.utils import timezone


class Applicant(models.Model):
  name = models.CharField(default="NULL",max_length=50)
  identification= models.CharField(default="NULL", max_length=50, help_text='ID/PASSPORT/UNC/CERT. OF REG NO.')
  pin = models.CharField(default="NULL",max_length=50, help_text='PIN NUMBER')
  po_box = models.CharField(default="NULL", max_length=50, help_text='P.O.BOX NUMBER')
  postal_code = models.CharField(default="NULL",max_length=50)
  city = models.CharField(default="NULL",max_length=50,help_text='CITY/TOWN')
  physical_address = models.CharField(default="NULL", max_length=50,help_text='LOACTION/ROAD')
  mobile = models.IntegerField(default=0 ,help_text='TEL. MOBILE')
  tel_home = models.IntegerField(default=0 ,help_text='TEL. HOME/OFFICE NO.')
  owner = models.CharField(default="NULL", max_length=50, help_text='OWNER/TENANT')
  tenant = models.CharField(default="NULL", max_length=50,help_text='IF TENANT:NAME OF LANDLORD')
  po_box = models.CharField(default="NULL", max_length=50,help_text='TENANT P.O.BOX') 
  postal_code= models.CharField(default="NULL",max_length=50,help_text='TENANT POSTAL CODE')
  phone_no = models.IntegerField(default=0 ,help_text='TENANT PHONE NUMBER')
  business = models.CharField(default="NULL", max_length=50, help_text='NATURE OF BUSINESS')
  year_business = models.CharField(default="NULL", max_length=50, help_text='YEAR OF BUSINESS ESTABLISHED')
  introduced_by = models.CharField(default="NULL", max_length=50)
  purpose_of_asset_being_purchased = models.CharField(default="NULL", max_length=50)
  user_id = models.ForeignKey(User, default = 0)
  date_added = models.DateField(auto_now_add=True)



  def __str__(self):
      return self.name



class ApplicantBankDetails(models.Model):
    applicant = models.ForeignKey(Applicant, on_delete=models.CASCADE,default=0)
    bank_name = models.CharField(default="NULL",max_length = 200)
    branch = models.CharField(default="NULL", max_length = 100)
    account_number = models.IntegerField(default=0 )
    od_limit = models.IntegerField(default=0 )
    outstanding_loans = models.IntegerField(default=0 )
    date_added = models.DateField(auto_now_add=True)

    def __str__(self):
        return self.bank_name

    class Meta:
        verbose_name_plural="ApplicantBankDetails"

class Properties(models.Model): 
    applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,default=0)
    vehicle_registration = models.CharField(default="NULL",max_length = 15)
    model = models.CharField(default="NULL", max_length=100)
    loan_balance = models.IntegerField(default=0 ,help_text='amount in ksh')
    financed_by = models.CharField(default="NULL",max_length=100) 
    the_property = models.CharField(default="NULL",max_length=100) 
    size = models.CharField(default="NULL",max_length=100)
    town = models.CharField(default="NULL",max_length = 100)
    lr_number = models.IntegerField(default=0 )
    approximate_value = models.IntegerField(default=0 ,help_text='amount in ksh')
    date_added = models.DateField(auto_now_add=True)

    def __str__(self):
        return self.model

    class Meta:
        verbose_name_plural="Properties"


class AdditonalInfoIndividual(models.Model):
    applicant= models.OneToOneField(Applicant, on_delete=models.CASCADE,default=0)
    age = models.IntegerField(default = 0,) 
    occupation = models.CharField(default = "NULL", max_length=100)
    nationality = models.CharField(default = "NULL", max_length=100)
    name_employer = models.CharField(default = "NULL", max_length = 100)
    address = models.CharField(default = "NULL", max_length=300)
    contact = models.IntegerField(default = 0,)
    years = models.IntegerField(default = 0,)
    marital_status= models.CharField(default = "NULL",max_length=100)
    spouse = models.CharField(default = "NULL", max_length=100) 
    occupation = models.CharField(default = "NULL", max_length = 200)
    income = models.IntegerField(default = 0,help_text="Your income in kshs.")
    spouse_income = models.IntegerField(default = 0,help_text="Amount in kshs.")
    living_expenses = models.IntegerField(default = 0,help_text="Amount in kshs.")
    loan_payment = models.IntegerField(default = 0,help_text="Amount in kshs.")
    income_business = models.IntegerField(default = 0,help_text="Amount in kshs.")
    others=models.IntegerField(default = 0,help_text="Amount in kshs.")
    disposable_income = models.IntegerField(default = 0,help_text="Amount in kshs.")
    is_complete = models.BooleanField(default=True)
    date_added = models.DateField(auto_now_add=True)

    def __str__(self):
        return self.occupation

    class Meta:
        verbose_name_plural=" AdditonalInfoIndividual"



class additonalInfoCompany(models.Model):
    applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,default=0)
    shareholders = models.CharField(default = "NULL",max_length=100)
    annual_tunover = models.IntegerField(default = 0,help_text="Amount in kshs.")
    annual_profit = models.IntegerField(default = 0,help_text="Amount in kshs.")
    associate_companies = models.CharField(default = "NULL",max_length=100)
    is_complete = models.BooleanField(default=True)
    date_added = models.DateField(auto_now_add=True)

    def __str__(self):
        return self.shareholders

    class Meta:
        verbose_name_plural="additonalInfoCompany"


class Dealer(models.Model):
    applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,default=0)
    dealer_name = models.CharField(default = "NULL", max_length=100)
    postal_address = models.IntegerField(default = 0,)
    telephone_number = models.IntegerField(default = 0,)
    invoice_number = models.IntegerField(default = 0,)
    sales_person = models.CharField(default = "NULL",max_length=100)
    is_complete = models.BooleanField(default=True)
    date_added = models.DateField(auto_now_add=True)

    def __str__(self):
        return self.dealer_name


class DealerSupplier(models.Model):
  applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,default=0)

  dealer_name = models.CharField(default = "NULL",max_length=50)
  postal_address = models.CharField(default = "NULL", max_length=50)
  telno = models.IntegerField(default = 0,)
  invoice_no_date = models.CharField(default = "NULL", max_length=50)
  sales_person = models.CharField(default = "NULL", max_length=50)
  date_added = models.DateField(auto_now_add=True)

  def __str__(self):
    return self.dealer_name

  class Meta:
        verbose_name_plural="DealerSupplier"



class AssetDetails(models.Model):
    applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,default=0)
    make = models.CharField(default = "NULL",max_length=100)
    new_used = models.CharField(default = "NULL",max_length=100)
    invoice_price = models.IntegerField(default = 0,)
    rating = models.CharField(default = "NULL",max_length = 100)
    less = models.IntegerField(default = 0,)
    year = models.IntegerField(default = 0,)
    cost = models.IntegerField(default = 0,help_text="Amount in kshs.")
    valuation = models.IntegerField(default = 0,)
    add = models.CharField(default = "NULL",max_length=100)
    insurance = models.BooleanField ( default = False)
    interested   =  models.BooleanField ( default =False)
    total = models.IntegerField(default = 0,help_text="Amount in kshs.")
    deposit = models.IntegerField(default = 0,help_text="Amount in kshs.")
    balance = models.IntegerField(default = 0,help_text="Amount in kshs.")
    loan = models.IntegerField(default = 0,help_text="Amount in kshs.")
    pricing = models.IntegerField(default = 0,help_text="Amount in kshs.")
    loan = models.IntegerField(default = 0,help_text="Amount in kshs.")
    repayment = models.IntegerField(default = 0,help_text="Amount in kshs.")
    repayment_amount = models.IntegerField(default = 0,help_text="Amount in kshs.")
    mode_payment = models.CharField(default = "NULL",max_length=100)
    guarantor = models.CharField(default = "NULL",max_length=100)
    security = models.CharField(default = "NULL",max_length=100)
    is_complete = models.BooleanField(default=True)
    date_added = models.DateField(auto_now_add=True)

    def __str__(self):
        return self.make 

    class Meta:
         verbose_name_plural ="AssetDetails"



class OtherCredit(models.Model):
  applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,default=0)
  name = models.CharField(default = "NULL",max_length=50)
  Facility_type = models.CharField(default = "NULL", max_length=50)
  sanctioned_limit = models.FloatField(default = "NULL",)
  current_outstanding = models.CharField(default = "NULL",max_length=50)
  date_added = models.DateField(auto_now_add=True)


  def __str__(self):
    return self.name
    class Meta:
        verbose_name_plural="OtherCredit"



  
class Document(models.Model):
   applicant= models.ForeignKey(Applicant, on_delete=models.CASCADE,default=0)
   description = models.TextField(default="NULL",)
   document = models.FileField(default="NULL",upload_to='documents/')
   image = models.ImageField(default="NULL",upload_to="image/")
   uploaded_at = models.DateTimeField(auto_now_add=True)
   date_added = models.DateField(auto_now_add=True)
   def __str__(self):
        return "document"

class CombinedForms(models.Model):
    applicant = models.ForeignKey(Applicant)
    bank_details = models.ForeignKey(ApplicantBankDetails)
    properties = models.ForeignKey(Properties)
    individual = models.ForeignKey(AdditonalInfoIndividual)
    company = models.ForeignKey(additonalInfoCompany)
    dealer = models.ForeignKey(Dealer)
    supplier = models.ForeignKey(DealerSupplier)
    asset_details = models.ForeignKey(AssetDetails) 
    other_credit = models.ForeignKey(OtherCredit)
    document = models.ForeignKey(Document)
    date_added = models.DateField(auto_now_add=True)

    

class AppliedUsers(models.Model):
    user_id  = models.ForeignKey(User)
    date_added = models.DateField(auto_now_add=True)

    def __str__(self):
        return str(self.user_id)
    