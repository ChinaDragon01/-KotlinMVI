package com.example.baselib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.baselib.utils.GenericsUtil

/**
 *Author: chinadragon
 *Time: 2024/5/7
 */
abstract class BaseActivity<VM : BaseViewModel<*>, VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var mViewModel: VM
    protected lateinit var binding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        initBefore(savedInstanceState)
        super.onCreate(savedInstanceState)
        initContentView()
        initViewModel()
        initData()
        initView(savedInstanceState)
        loadData()
        initEvent()
        initUiSate()
    }

    private fun initContentView() {
        binding = initViewBinding()
        setContentView(binding.root)
    }

    abstract fun initViewBinding(): VB

    open fun initBefore(savedInstanceState: Bundle?) {}

    open fun initView(savedInstanceState: Bundle?) {}

    /**
     * Called before {@link #initView(savedInstanceState: Bundle?)}
     */
    open fun initData() {}

    private fun initViewModel() {
        mViewModel = GenericsUtil.getInstant(this)
    }

    open fun loadData() {}

    open fun initEvent() {}

    open fun initUiSate() {}
}