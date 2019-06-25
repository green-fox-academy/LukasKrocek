import urllib.request
import json

req = urllib.request.Request('http://www.omdbapi.com/?apikey=ba7d2770&t=Alien')
with urllib.request.urlopen(req) as response:
    the_page = response.read()
    movie = json.loads(the_page)
    rating = movie['Ratings'][0]['Value']

print(rating)
