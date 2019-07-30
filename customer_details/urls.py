from django.contrib import admin
from django.conf.urls import url, include
from . import views
from django.conf import settings
from django.conf.urls.static import static
from django.contrib.auth.decorators import login_required
from django.views.generic import TemplateView
urlpatterns = [
    url('^$',views.welcome, name= 'welcome'),
    url(r'^new/applicant$', views.applicant, name='applicant'),
    url(r'^new/applicantbank$', views.applicantbankdetails, name='applicantbankdetails'),

    url(r'^new/additional$', views.additional, name='additional'),
    url(r'^new/properties$', views.properties, name='properties'),
    url(r'^new/additional1$', views.additional1, name='additional1'),
    url(r'^new/dealer$', views.dealer, name='dealer'),
    url(r'^new/dealer1$', views.dealer1, name='dealer1'),
    url(r'^new/assetdetails$', views.assetdetails, name='assetdetails'),
    url(r'^new/otherdetail$', views.otherdetail, name='otherdetail'),
    url(r'^basic-upload/$', views.BasicUploadView.as_view(), name='basic_upload'),




]
if settings.DEBUG:
        urlpatterns += static(settings.MEDIA_URL, document_root = settings.MEDIA_ROOT)

 


