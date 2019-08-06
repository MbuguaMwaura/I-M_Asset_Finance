from django.conf.urls import url

from .views import dashboard, user_details

urlpatterns=[
    url(r'^$',dashboard , name = 'dashboard'),
    url(r'^applicant/details/(\d+)/$', user_details, name='user_details')

]
