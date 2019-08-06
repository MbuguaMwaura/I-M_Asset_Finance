from django.conf.urls import url
from .views import signup


urlpatterns = [
    url(r'^account/$',signup, name = 'signup')
]