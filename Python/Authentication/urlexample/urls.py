from django.urls import path, include
from . import views

urlpatterns = [
    path('profile/<username>/', views.profile),
    path('profile/', views.profile)
]
