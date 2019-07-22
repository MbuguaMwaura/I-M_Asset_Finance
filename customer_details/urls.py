from django.contrib import admin
from django.conf.urls import url, include
from customer_details import views
from django.conf import settings
from django.conf.urls.static import static


urlpatterns = [
    path('admin/', admin.site.urls),
    url(r'^api/customer_details/$',views.ApplicantList.as_view()),
 
 ]

if settings.DEBUG:
    urlpatterns+= static(settings.MEDIA_URL, document_root = settings.MEDIA_ROOT)
