package com.example.interviewtask.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.interviewtask.MainActivity
import com.example.interviewtask.R
import com.example.interviewtask.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), AuthHandler {

    private lateinit var authViewModel : AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Binding
        val binding =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        binding.lifecycleOwner = this

        // ViewModel
        this.authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        // Setting binding params
        binding.authViewModel = authViewModel
        binding.handler = this

        // Watching for login result
        authViewModel.getLogInResult().observe(this, Observer { result ->
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        })

        authViewModel.loginSuccess().observe(this, Observer {success ->
            if(success){
                val intentHome = Intent(this@LoginActivity, MainActivity::class.java)
                intentHome.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intentHome)
                finishAffinity()
            }
        })
    }

    override fun onLogInClicked() {
        authViewModel.performValidation()
    }
}