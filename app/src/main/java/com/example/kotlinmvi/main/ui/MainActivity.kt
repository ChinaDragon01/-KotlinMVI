package com.example.kotlinmvi.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.baselib.base.BaseActivity
import com.example.baselib.extension.initDefeaultUI
import com.example.kotlinmvi.community.ui.CommunityFragment
import com.example.kotlinmvi.databinding.ActivityMainBinding
import com.example.kotlinmvi.home.ui.HomeFragment
import com.example.kotlinmvi.main.adpater.MainPageAdapter
import com.example.kotlinmvi.main.model.MainViewModel
import com.example.kotlinmvi.mine.ui.MineFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    private lateinit var mMainVp2Content: ViewPager2
    private lateinit var mainPageAdapter: MainPageAdapter
    private lateinit var mBottomNavigation: BottomNavigationView
    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initData() {
        super.initData()
        val fragmentList =
            listOf<Fragment>(HomeFragment.creatHomeFragment(), CommunityFragment(), MineFragment())
        mainPageAdapter = MainPageAdapter(this, fragmentList)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        mMainVp2Content = binding.vp2MainContent.apply {
            offscreenPageLimit = if (mainPageAdapter.pages.isNotEmpty()) mainPageAdapter.pages.size else 1
            initDefeaultUI(mainPageAdapter)
        }

        mBottomNavigation = binding.bottomNavigation.apply {
            itemIconTintList = null
            setOnItemSelectedListener { item ->
                when(item.itemId){
                    com.example.baselib.R.id.nav_home ->{  mMainVp2Content.currentItem = 0}
                    com.example.baselib.R.id.nav_commounity ->{  mMainVp2Content.currentItem = 1}
                    else ->{  mMainVp2Content.currentItem = 2}
                }
                return@setOnItemSelectedListener true
            }
        }
    }

    override fun initEvent() {
        super.initEvent()
    }


}