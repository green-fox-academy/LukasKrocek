from rest_framework import viewsets
from .models import Meal
from .serializers import MealSerializer


class MealView(viewsets.ModelViewSet):
    queryset = Meal.objects.all()
    serializer_class = MealSerializer

