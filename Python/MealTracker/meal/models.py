from django.db import models


class Meal(models.Model):
    name = models.CharField(max_length=40)
    calories = models.IntegerField()
    date = models.DateField()

    def __str__(self):
        return self.name
