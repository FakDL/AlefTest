package com.example.aleftest

import android.app.Application
import com.example.aleftest.di.AppComponent
import com.example.aleftest.di.DaggerAppComponent

class BaseApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent(){
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

}
