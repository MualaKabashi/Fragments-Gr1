package com.cacttus.fragments_gr1.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cacttus.fragments_gr1.R
import com.cacttus.fragments_gr1.databinding.ActivityInstagramBinding
import com.cacttus.fragments_gr1.fragments.ProfileFragment
import com.cacttus.fragments_gr1.fragments.ReelsFragment
import com.cacttus.fragments_gr1.fragments.SearchFragment

class InstagramActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInstagramBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstagramBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleBottomNavigationClick()
    }


    private fun handleBottomNavigationClick() {
        var profileFragment = ProfileFragment()
        var reelsFragment = ReelsFragment()
        var searchFragment = SearchFragment()
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> setCurrentFragment(reelsFragment)
                R.id.search -> setCurrentFragment(searchFragment)
                R.id.profile -> setCurrentFragment(profileFragment)

            }
            true
        }
    }


    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}