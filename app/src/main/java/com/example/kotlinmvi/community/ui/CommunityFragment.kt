package com.example.kotlinmvi.community.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.baselib.base.BaseFragment
import com.example.kotlinmvi.community.model.CommunityViewModel
import com.example.kotlinmvi.databinding.FragmentCommunityBinding

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class CommunityFragment : BaseFragment<CommunityViewModel, FragmentCommunityBinding>() {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCommunityBinding {
        return FragmentCommunityBinding.inflate(inflater, container, false)
    }
}