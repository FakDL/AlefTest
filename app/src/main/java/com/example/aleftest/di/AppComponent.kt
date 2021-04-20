package com.example.aleftest.di

import android.app.Application
import com.example.aleftest.MainActivity
import com.example.aleftest.di.modules.MainModule
import com.example.aleftest.di.modules.NetworkModule
import com.example.aleftest.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        MainModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(activity: MainActivity)
}