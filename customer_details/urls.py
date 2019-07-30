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

   
]
if settings.DEBUG:
        urlpatterns += static(settings.MEDIA_URL, document_root = settings.MEDIA_ROOT)

 
]




