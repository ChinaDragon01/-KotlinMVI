package com.example.baselib.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.baselib.utils.GenericsUtil

/**
 *Author: chinadragon
 *Time: 2024/5/18
 */
abstract class BaseFragment<VM : BaseViewModel<*>, VB : ViewBinding> :
    Fragment() {
    protected lateinit var mViewModel: VM
    protected lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = initViewBinding(inflater, container)
        return binding.root
    }

    abstract fun initViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initBefore(savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initData()
        initView(savedInstanceState)
        loadData()
        initEvent()
    }

    open fun initBefore(savedInstanceState: Bundle?) {

    }

    private fun initViewModel() {
        mViewModel = GenericsUtil.getInstant(this)
    }

    /**
     * Called before {@link #initView(savedInstanceState: Bundle?)}
     */
    open fun initData() {

    }

    open fun initView(savedInstanceState: Bundle?) {

    }

    open fun loadData() {

    }

    open fun initEvent() {

    }
}