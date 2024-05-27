package com.example.kotlinmvi.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.baselib.base.BaseFragment
import com.example.kotlinmvi.databinding.FragmentHomeBinding
import com.example.kotlinmvi.home.model.HomeViewModel

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    companion object {
        fun creatHomeFragment(bundle: Bundle = Bundle()): HomeFragment {
            var bundle = Bundle()
            return HomeFragment().apply {
                arguments = bundle
            }
        }
    }
}