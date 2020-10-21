package com.example.interviewtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.interviewtask.auth.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handleScreenForHome()
    }

    private fun handleScreenForHome(){
        Handler().postDelayed({
            val intentLogin = Intent(this@SplashActivity, LoginActivity::class.java)
            intentLogin.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intentLogin)
            finishAffinity()
        }, 2000)
    }
}