package com.example.bottomnavstartertemplete.customwithoutfab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavstartertemplete.R
import com.example.bottomnavstartertemplete.databinding.ActivityCustomBottomNavWithoutFabBinding

class CustomBottomNavWithoutFabActivity : AppCompatActivity() {

    private var _binding: ActivityCustomBottomNavWithoutFabBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCustomBottomNavWithoutFabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.custom_without_fab_fcv
        ) as NavHostFragment

        navController = navHostFragment.navController
        binding.customBottomNavWithoutFabBottomNav.setupWithNavController(navController)

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
            binding.customBottomNavWithoutFabBottomNav.selectedItemId = R.id.homeFragment
        }
        binding.customNavFavourite.setOnClickListener {
            binding.customBottomNavWithoutFabBottomNav.selectedItemId = R.id.favouritesFragment
        }
        binding.customNavSettings.setOnClickListener {
            binding.customBottomNavWithoutFabBottomNav.selectedItemId = R.id.settingsFragment
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
                    binding.customNavFavourite.isSelected = true
                }
            }
            when (destination.id) {
                R.id.homeFragment,
                R.id.settingsFragment,
                R.id.favouritesFragment -> {
                    binding.customBottomNavWithoutFabLinearLayout.isVisible = true
                }
                else -> {
                    binding.customBottomNavWithoutFabLinearLayout.isVisible = false
                }
            }
        }
    }

    private fun deselectAllTabs() {
        binding.customNavHome.isSelected = false
        binding.customNavSettings.isSelected = false
        binding.customNavFavourite.isSelected = false
    }
}