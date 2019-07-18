from django.contrib import admin
from django.conf.urls import url, include
from . import views
from django.conf import settings


urlpatterns = [
 url('^$',views.welcome, name= 'welcome'),]

if settings.DEBUG:
    urlpatterns+= static(settings.MEDIA_URL, document_root = settings.MEDIA_ROOT)