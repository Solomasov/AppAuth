package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.configuration.ApplicationConfig
import com.example.myapplication.configuration.ApplicationConfigLoader
import com.example.myapplication.databinding.ActivityMainBinding
import net.openid.appauth.AuthState
import android.net.Uri

import net.openid.appauth.AuthorizationServiceConfiguration




class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.model = AuthenticationFragmentViewModel()
        setContentView(binding.root)

        private val config: ApplicationConfig = ApplicationConfigLoader().load(this)
        private val authState: AuthState
        private val appauth: AppAuthHandler = AppAuthHandler(this.config, app.applicationContext)

        val serviceConfig = AuthorizationServiceConfiguration(
            config.clientID,

        )

    }

}