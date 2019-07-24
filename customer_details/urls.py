from django.contrib import admin
from django.conf.urls import url, include
from . import views
from django.conf import settings
from django.conf.urls.static import static


urlpatterns = [
    
    url('^$',views.welcome, name= 'welcome'),
    url(r'^new/applicant$', views.applicant, name='applicant'),
    url(r'^new/applicantbank$', views.applicantbankdetails, name='applicantbankdetails'),
 
]



