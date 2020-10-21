package com.example.interviewtask.utils

fun isValidEmail(email:String): Boolean = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()