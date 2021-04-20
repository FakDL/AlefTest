package com.example.aleftest.di.modules

import android.app.Application
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.aleftest.R
import com.example.aleftest.factories.MyFragmentFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object MainModule {


    @Singleton
    @Provides
    fun provideFragmentFactory(
        viewModelFactory: ViewModelProvider.Factory,
        requestManager: RequestManager
    ): FragmentFactory {
        return MyFragmentFactory(
            viewModelFactory,
            requestManager
        )
    }

    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
    }

    @Singleton
    @Provides
    fun provideGlideInstance(
        application: Application,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

}