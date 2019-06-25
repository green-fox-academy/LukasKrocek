from django.shortcuts import render, redirect
from django.views.decorators.http import require_POST
from .models import Todo
from .forms import TodoForm, NewTodoForm
import datetime


def index(request):
    todo_list = Todo.objects.order_by('id')
    newform = NewTodoForm()
    mydate = datetime.datetime.now()
    context = {'todo_list': todo_list, 'form': newform, 'mydate': mydate}
    return render(request, 'todo/index.html', context)


@require_POST
def addTodo(request):
    new_todoform = NewTodoForm(request.POST)
    if new_todoform.is_valid():
        Todo = new_todoform.save()
    return redirect('index')


def completeTodo(request, todo_id):
    todo = Todo.objects.get(pk=todo_id)
    todo.complete = True
    todo.save()
    return redirect('index')


def deleteCompleted(request):
    Todo.objects.filter(complete__exact=True).delete()
    return redirect('index')


def deleteAll(request):
    Todo.objects.all().delete()
    return redirect('index')


def modifyTodo(request, todo_id):
    modified_todo = Todo.objects.get(pk=todo_id)
    new_todoform = NewTodoForm(request.POST, instance=modified_todo)
    if new_todoform.is_valid():
        new_todo = new_todoform.save()
    return redirect('index')
