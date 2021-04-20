package com.example.aleftest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.NavHostFragment
import com.example.aleftest.di.AppComponent
import com.example.aleftest.di.DaggerAppComponent
import com.example.aleftest.factories.MyNavHostFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var navHost: NavHostFragment

    @Inject
    lateinit var fragmentFactory: FragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        createNavHost()
    }

    private fun inject() {
        (application as BaseApplication).appComponent.inject(this)
    }

    private fun createNavHost(){
        navHost = MyNavHostFragment.create(
            R.navigation.main_nav_graph
        )
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_fragments_container,
                navHost,
                getString(R.string.MainNavHost)
            )
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }

}