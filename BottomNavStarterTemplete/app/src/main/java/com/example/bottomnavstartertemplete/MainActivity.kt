package com.example.bottomnavstartertemplete

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomnavstartertemplete.customwithfab.CustomBottomNavActivity
import com.example.bottomnavstartertemplete.customwithoutfab.CustomBottomNavWithoutFabActivity
import com.example.bottomnavstartertemplete.databinding.ActivityMainBinding
import com.example.bottomnavstartertemplete.material.MaterialActivity

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.materialActivityBtn.setOnClickListener {
            Intent(this, MaterialActivity::class.java).also { intent ->
                startActivity(intent)
            }
        }
        binding.customBottomNavBtn.setOnClickListener {
            Intent(this, CustomBottomNavActivity::class.java).also { intent ->
                startActivity(intent)
            }
        }
        binding.customBottomSheetWithoutFab.setOnClickListener {
            Intent(this, CustomBottomNavWithoutFabActivity::class.java).also { intent ->
                startActivity(intent)
            }
        }

    }


}