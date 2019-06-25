from django.http import HttpResponse

def profile(request, username='Default User'):
    return HttpResponse('this is profile page! The user is {}'.format(username))
