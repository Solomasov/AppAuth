package com.example.myapplication

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.configuration.ApplicationConfig
import com.example.myapplication.configuration.ApplicationConfigLoader
import net.openid.appauth.AuthorizationServiceConfiguration
import net.openid.appauth.ResponseTypeValues
import net.openid.appauth.AuthorizationRequest
import androidx.core.app.ActivityCompat.startActivityForResult
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import net.openid.appauth.AuthorizationService

class AuthenticationFragmentViewModel(context: Context): ViewModel() {

    val TAG = "RenaultAuth"
    var error = ""
    val config: ApplicationConfig = ApplicationConfigLoader().load(context)

    fun startLogin(context: Context) {

        error = ""

        Log.d(TAG, "start login...")

        val serviceConfig = AuthorizationServiceConfiguration(
            Uri.parse(config.auth_uri),
            Uri.parse(config.token_uri)
        )

        val authRequestBuilder = AuthorizationRequest.Builder(
            serviceConfig,  // the authorization service configuration
            config.clientID,  // the client ID, typically pre-registered and static
            ResponseTypeValues.CODE,  // the response_type value: we want a code
            Uri.parse(config.redirectUri)
        )

        val authRequest = authRequestBuilder
            .setScope("openid email")
            //.setLoginHint("jdoe@user.example.com")
            .build();

        val authService = AuthorizationService(context)
        val authIntent = authService.getAuthorizationRequestIntent(authRequest)

    }

}
