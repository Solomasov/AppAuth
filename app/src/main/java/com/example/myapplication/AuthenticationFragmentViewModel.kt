package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel

class AuthenticationFragmentViewModel: ViewModel() {

    val TAG = "RenaultAuth"
    var error = ""

    fun startLogin() {

        error = ""

        Log.d(TAG, "start login...")



    }

}
