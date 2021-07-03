package com.example.jacocoproject.application

import android.app.Application
import com.example.jacocoproject.di.appModule
import org.koin.core.context.startKoin

class HelpApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}