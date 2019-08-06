from django.contrib import admin
from django.conf.urls import url, include
from . import views

from django.contrib.auth.decorators import login_required
from django.views.generic import TemplateView
urlpatterns = [
    url('^$',views.welcome, name= 'welcome'),
    url(r'^new/applicant/$', views.applicant, name='applicant'),
    url(r'^new/applicantbank/(\d+)/$', views.applicantbankdetails, name='applicantbankdetails'),
    url(r'^new/additional/(\d+)/$', views.additional, name='additional'),
    url(r'^new/properties/(\d+)/$', views.properties, name='properties'),
    url(r'^new/additional1/(\d+)/$', views.additional1, name='additional1'),
    url(r'^new/dealer/(\d+)/$', views.dealer, name='dealer'),
    url(r'^new/dealer1/(\d+)/$', views.dealer1, name='dealer1'),
    url(r'^new/assetdetails/(\d+)/$', views.assetdetails, name='assetdetails'),
    url(r'^new/otherdetail/(\d+)/$', views.otherdetail, name='otherdetail'),
    # url(r'^basic-upload/(\d+)/$', views.BasicUploadView.as_view(), name='basic_upload'),
    url(r'^upload_documents/(\d+)/$' ,views.documents, name='documents'),
    url(r'^administrator/$',views.admin_dashboard),
    url(r'^administrator/single/(\d+)/$',views.single_user_admin,name="single"),


]


