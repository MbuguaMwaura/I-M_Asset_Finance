from rest_framework.response import Response
from rest_framework.views import APIView
from .serializer import ApplicantSerializer,ApplicantBankSerializer,PropertiesSerializer,AdditonalIndvInfoSerializer,AdditonalCompInfoSerializer,DealerSerializer,DealerSupplierSerializer,AssetDetailsSerializer,OtherCredit
from .models import Applicant,ApplicantBankDetails,Properties,additionalInfoIndividual,additionalInfoCompany,dealer,DealerSupplier,asset_details,OtherCredit

# Create your views here.

# class ApplicantList(APIView):
    # def get(self,request,format=none):
        # all_applicants = Applicant.objects.all()
        # serializers = ApplicantSerializer(all_applicants, many=true)
        # return Response(serializers.data)