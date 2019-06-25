from django.db import models
import urllib.request
import json


class Movie(models.Model):
    name = models.CharField(max_length=40)
    description = models.TextField()
    imdb_rating = models.CharField(max_length=10, blank=True, editable=False)

    def __str__(self):
        return self.name

    def save(self, *args, **kwargs):
        self.imdb_rating = self.get_rating(self.name)
        super().save(*args, **kwargs)  # Call the "real" save() method.

    @staticmethod
    def get_rating(name):
        req = urllib.request.Request('http://www.omdbapi.com/?apikey=ba7d2770&t={}'.format(name))
        with urllib.request.urlopen(req) as response:
            the_page = response.read()
            rating = json.loads(the_page)
            return rating['Ratings'][0]['Value']
