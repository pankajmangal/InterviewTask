package com.example.interviewtask.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.interviewtask.utils.Constant
import com.example.interviewtask.utils.isValidEmail

class AuthViewModel : ViewModel() {

    /**
     * Two way bind-able fields
     */
    var email: String = ""
    var password: String = ""

    /**
     * To pass login result to activity
     */
    private val logInResult = MutableLiveData<String>()
    private val loginSuccessResult = MutableLiveData<Boolean>()

    fun getLogInResult(): LiveData<String> = logInResult
    fun loginSuccess(): LiveData<Boolean> = loginSuccessResult

    /**
     * Called from activity on login button click
     */
    fun performValidation() {

        if (email.isEmpty()) {
            logInResult.value = "Enter email address"
            loginSuccessResult.value = false
            return
        }

        if (!isValidEmail(email)) {
            logInResult.value = "Invalid email address"
            loginSuccessResult.value = false
            return
        }

        if (password.isEmpty()) {
            logInResult.value = "Enter password"
            loginSuccessResult.value = false
            return
        }

        if (password.length < 8) {
            logInResult.value = "Password length should be 8 char"
            loginSuccessResult.value = false
            return
        }

        if(!email.equals(Constant.validEmail) && !password.equals(Constant.validPass)){
            logInResult.value = "Email and Password not matched"
            loginSuccessResult.value = false
            return
        }

        logInResult.value = "Valid credentials :)"
        loginSuccessResult.value = true
    }

}