package com.dwiki.viewpagerappp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dwiki.viewpagerappp.databinding.ActivityMainBinding
import com.dwiki.viewpagerappp.fragment.ChatFragment
import com.dwiki.viewpagerappp.fragment.PanggilanFragment
import com.dwiki.viewpagerappp.fragment.StatusFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Whyapp"
        supportActionBar?.elevation = 0.0f
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = TabAdapter(supportFragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        binding.viewPager.adapter = adapter
        binding.tlLayout.setupWithViewPager(binding.viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_appbar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    class TabAdapter (fm:FragmentManager, behavior:Int): FragmentStatePagerAdapter(fm, behavior) {
        private val tabName:Array<String> = arrayOf("Chat","Status","Panggilan")

        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment =
            when(position) {
                0 -> ChatFragment()
                1 -> StatusFragment()
                2 -> PanggilanFragment()
                else -> ChatFragment()
            }

        override fun getPageTitle(position: Int): CharSequence? = tabName[position]

    }
}



