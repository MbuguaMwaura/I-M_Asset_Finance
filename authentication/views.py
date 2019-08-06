from django.shortcuts import render,redirect
from .forms import SignUp

# Create your views here.

def signup(request):
    if request.method == 'POST':
        form = SignUp(request.POST)
        if form.is_valid():
            user = form.save()
            return redirect('/accounts/login/')
    else:
        form = SignUp()
    context = {
        'form':form
    }
    return render(request, 'signup.html',context)
