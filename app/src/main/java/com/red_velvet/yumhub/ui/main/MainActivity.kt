package com.red_velvet.yumhub.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.ActivityMainBinding
import com.red_velvet.yumhub.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val LOG_TAG: String = "nenene"
    private val navController by lazy { findNavController(R.id.nav_host_fragment_content_main) }
    private val viewModel: MainViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.black)
        setSupportActionBar(binding.toolbar)
        initNavigationDestinationListener()
        setupActionBarWithNavController(navController)
        binding.bottomNav.setupWithNavController(navController)
        observeUIEvents()
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }


    private fun initNavigationDestinationListener() {
        navController.addOnDestinationChangedListener { _, destination, arguments ->
            when (destination.id) {
                R.id.homeFragment,
                R.id.searchFragment,
                R.id.profileFragment,
                R.id.dietFragment -> {
                    supportActionBar?.hide()
                    binding.bottomNav.isVisible = true
                }

                R.id.signupFragment,
                R.id.onBoardingFragment -> {
                    supportActionBar?.hide()
                    binding.bottomNav.isVisible = false
                }

                else -> {
                    binding.bottomNav.isVisible = false
                    supportActionBar?.show()
                }
            }
        }
    }

    private fun observeUIEvents() {
        lifecycleScope.launch {
            val effect = viewModel.effect.first()
            when (effect) {
                MainUIEffect.NavigateToSignUp -> {
                    navController.navigate(R.id.signupFragment)
                }

                MainUIEffect.NavigateToHome -> {
                    navController.navigate(R.id.homeFragment)
                }
            }
        }
    }

}