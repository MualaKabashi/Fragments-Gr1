package com.cacttus.fragments_gr1.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cacttus.fragments_gr1.R
import com.cacttus.fragments_gr1.databinding.ActivityMainBinding
import com.cacttus.fragments_gr1.fragments.FirstFragment
import com.cacttus.fragments_gr1.fragments.SecondFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var firstFragment = FirstFragment()
        var secondFragment = SecondFragment()
        binding.btnFirstFragment.setOnClickListener {
            setCurrentFragment(firstFragment)
        }

        binding.btnSecondFragment.setOnClickListener {
            setCurrentFragment(secondFragment)
        }
    }

    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
        }.commit()
    }
}

