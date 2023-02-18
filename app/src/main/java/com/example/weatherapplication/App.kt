package com.example.weatherapplication

import android.app.Application
import androidx.annotation.StringRes
import com.example.weatherapplication.di.weatherModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(weatherModule)
        }
        instance = this
    }

    companion object{
        lateinit var instance: Application
    }
}

fun makeString(@StringRes resourceId: Int) = App.instance.getString(resourceId)