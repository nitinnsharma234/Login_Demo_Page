package com.example.login_demo_page.ui.theme

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel:ViewModel() {
    private val _email= MutableStateFlow("")
    val email = _email.asStateFlow()




    private val _password= MutableStateFlow("")
    val password = _password.asStateFlow()
    fun setValue(it:String)
    {
        _email.value=it
    }
    fun setPassword(it:String)
    {
        _password.value=it
    }
    var error:String="Submitted Sucessfully"
    fun submit ():String
    {
        if(_email.value.isEmpty())
        {
            error="Email Field Cannot be Empty"
        }

        else if(!Patterns.EMAIL_ADDRESS.matcher(_email.value).matches()){
            Log.d("DOG","${_email.value}")
            error="Please enter a valid email"
        }

        else if (_password.value.isEmpty())
        {
            error="Password field Cannot be Empty"
        }


        else if (_password.value.length<8)
        {
            Log.d("DOG","${_password.value}---Password is shorter than 8 digits")

            error="Password is shorter than 8 digits"
        }
        else if(_password.value.length>=8 )
        {
           if(_password.value.any{it.isDigit()} && _password.value.any{it.isLetter()})
           {
               Log.d("DOG","${_password.value}")

               return "Submitted Sucessfully";
           }
            else{
               Log.d("DOG","${_password.value}, --Password must contain letters and digits")

               error="Password must contain letters and digits"
           }
        }
        return error;
    }
}