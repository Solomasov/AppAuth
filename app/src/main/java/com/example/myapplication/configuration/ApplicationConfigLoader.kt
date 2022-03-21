package com.example.myapplication.configuration

import android.content.Context
import com.example.myapplication.R
import com.google.gson.Gson
import okio.Buffer
import okio.buffer
import okio.source
import java.nio.charset.Charset

class ApplicationConfigLoader {

    fun load(context: Context): ApplicationConfig {

        val stream = context.resources.openRawResource(R.raw.config)
        val configSource = stream.source().buffer()

        val configBuffer = Buffer()
        configSource.readAll(configBuffer)
        val configJson = configBuffer.readString(Charset.forName("UTF-8"))

        // Deserialize it into objects
        return Gson().fromJson(configJson, ApplicationConfig::class.java)

    }

}