package com.example.interviewtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.interviewtask.databinding.ActivityLoginBinding
import com.example.interviewtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.tvWelcomeText.text = "Well done \n\nPankaj Mangal\n\nYou have done your task !!"
    }
}