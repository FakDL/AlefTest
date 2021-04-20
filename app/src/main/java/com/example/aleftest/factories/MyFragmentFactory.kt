package com.example.aleftest.factories


import androidx.fragment.app.FragmentFactory
import com.example.aleftest.ui.ListFragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.aleftest.ui.DetailsFragment
import javax.inject.Inject

class MyFragmentFactory
@Inject constructor(
    private val viewModelFactory: ViewModelProvider.Factory,
    private val requestManager: RequestManager
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {

            ListFragment::class.java.name -> {
                ListFragment(viewModelFactory, requestManager)
            }

            DetailsFragment::class.java.name -> {
                DetailsFragment(requestManager)
            }


            else -> {
                ListFragment(viewModelFactory, requestManager)
            }
        }
}

