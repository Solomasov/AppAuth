package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.configuration.ApplicationConfig
import com.example.myapplication.configuration.ApplicationConfigLoader
import com.example.myapplication.databinding.ActivityMainBinding
import net.openid.appauth.AuthState
import net.openid.appauth.AuthorizationServiceConfiguration

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.model = AuthenticationFragmentViewModel(this)
        setContentView(binding.root)

    }

}