from rest_framework import serializers
from .models import Meal


class MealSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Meal
        fields = ('id', 'url', 'name', 'calories', 'date')
