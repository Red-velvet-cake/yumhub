package com.red_velvet.yumhub.ui

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.ActivityMainBinding
import com.red_velvet.yumhub.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val LOG_TAG: String = "nenene"
    private val navController by lazy { findNavController(R.id.nav_host_fragment_content_main) }

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        initNavigationDestinationListener()
        setupActionBarWithNavController(navController)
        binding.bottomNav.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }


    private fun initNavigationDestinationListener() {
        navController.addOnDestinationChangedListener { _, destination, arguments ->
            when (destination.id) {
                R.id.homeFragment,
                R.id.searchFragment -> {
                    supportActionBar?.hide()
                    binding.bottomNav.isVisible = true
                }

                else -> {
                    binding.bottomNav.isVisible = false
                    supportActionBar?.show()
                }
            }
        }
    }

}