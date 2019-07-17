from django.db import models
from django.contrib.auth.models import User

Create your models here.

class Applicant(models.Models):
  yourname = models.CharField(_('Yourname'), max_length=50)
  passport = models.CharField(_('ID/passport/inc/cert of REG No.'), max_length=50)
  pin = models.CharField(_('Pin No.'), max_length=50)
  p_o_box = models.CharField(_('P.O.Box '), max_length=50)
  postalcode = = models.CharField(_('postalcode'), max_length=50)
  city/town = models.CharField(_('city'),max_length=50))
  physical/address = models.CharField(_('physical/address'), max_length=50)
  mobile = models.CharField(_('mobile'), max_length=50)
  home/officemobile = models.CharField(_('home/officemobile'), max_length=50)
  owner = models.CharField(_('owner'), max_length=50)
  tenant = models.CharField(_('tenant'), max_length=50)
  tp_o_box = models.CharField(_('tp.o.box'), max_length=50) 
  tpostalcode = models.CharField(_('tpostalcode'), max_length=50)
  tphoneno = models.CharField(_('tphoneno'), max_length=50)
  business = models.CharField(_('business'), max_length=50)
  yrbusiness = models.CharField(_('yrbusiness'), max_length=50)
  introby = models.CharField(_('introduced by'), max-length=50)
  purpose = models.CharField(_('purpose of assets being purchaced'), max_length=50)


class DealerSupplier(models.Models):
  dealername = models.CharField(_('DEALER NAME'),max_length=50)
  postaladdress = models.CharField(_('postal address'), max_length=50)
  telno = models.IntegerField(_('tel phone no'), max_length=50)
  invoiceno_date = models.CharField(_('invoice date'), max_length=50)
  salesperson = models.CharField(_('sales'), max_length=50)

class OtherCredit(models.Models):
  name = models.CharField(_('Name'), max_length=50)
  Facility_type = models.CharField(_('Facility type'), max_length=50)
  sanctioned_limit = models.CharField(_('sanctioned limit'), max_length=50)
  current_outstanding = models.CharField(_('current outstanding'), max_length=50)
  

class Document(models.Model):
    description = models.CharField(max_length=255, blank=True)
    document = models.FileField(upload_to='documents/')
    uploaded_at = models.DateTimeField(auto_now_add=True)

