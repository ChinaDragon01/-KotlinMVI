package com.example.kotlinmvi.mine.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.baselib.base.BaseFragment
import com.example.kotlinmvi.databinding.FragmentMineBinding
import com.example.kotlinmvi.mine.model.MineViewModel

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class MineFragment : BaseFragment<MineViewModel, FragmentMineBinding>() {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMineBinding {
        return FragmentMineBinding.inflate(inflater, container, false)
    }
}