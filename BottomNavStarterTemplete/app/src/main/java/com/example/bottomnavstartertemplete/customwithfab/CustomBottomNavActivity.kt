package com.example.bottomnavstartertemplete.customwithfab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavstartertemplete.R
import com.example.bottomnavstartertemplete.databinding.ActivityCustomBottomNavBinding

class CustomBottomNavActivity : AppCompatActivity() {

    private var _binding: ActivityCustomBottomNavBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCustomBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.custom_bottom_nav_fcv
        ) as NavHostFragment

        navController = navHostFragment.navController
        binding.customBottomNavBottomNav.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.favouritesFragment,
                R.id.settingsFragment
            )
        )

        setOnClicks()
        setCurrentDestinationListener()
    }

    private fun setOnClicks() {
        binding.customNavHome.setOnClickListener {
            binding.customBottomNavBottomNav.selectedItemId = R.id.homeFragment
        }
        binding.customNavSettings.setOnClickListener {
            binding.customBottomNavBottomNav.selectedItemId = R.id.settingsFragment
        }
        binding.customNavFavouritesFab.setOnClickListener {
            binding.customBottomNavBottomNav.selectedItemId = R.id.favouritesFragment
        }
    }

    private fun setCurrentDestinationListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            deselectAllTabs()
            when (destination.id) {
                R.id.homeFragment -> {
                    binding.customNavHome.isSelected = true
                }
                R.id.settingsFragment -> {
                    binding.customNavSettings.isSelected = true
                }
                R.id.favouritesFragment -> {
                    binding.customNavFavouritesFab.isSelected = true
                }
            }
            when (destination.id) {
                R.id.homeFragment,
                R.id.settingsFragment,
                R.id.favouritesFragment -> {
                    binding.customBottomNavLinearLayout.isVisible = true
                    binding.customNavFavouritesFab.isVisible = true
                }
                else -> {
                    binding.customBottomNavLinearLayout.isVisible = false
                    binding.customNavFavouritesFab.isVisible = false
                }
            }
        }
    }

    private fun deselectAllTabs() {
        binding.customNavHome.isSelected = false
        binding.customNavSettings.isSelected = false
        binding.customNavFavouritesFab.isSelected = false
    }
}