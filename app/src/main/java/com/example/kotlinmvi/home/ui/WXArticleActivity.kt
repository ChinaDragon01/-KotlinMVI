package com.example.kotlinmvi.home.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baselib.base.BaseActivity
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiResposeState
import com.example.baselib.impl.NoMultiClickListener
import com.example.kotlinmvi.databinding.ActivityWxarticleBinding
import com.example.kotlinmvi.home.adapter.WXArticleAdapter
import com.example.kotlinmvi.home.model.WXArticleViewModel
import com.example.kotlinmvi.main.ui.LoginActivity

/**
 *Author: chinadragon
 *Time: 2024/5/27
 */
class WXArticleActivity : BaseActivity<WXArticleViewModel, ActivityWxarticleBinding>() {
    private lateinit var wxArticleAdapter: WXArticleAdapter
    override fun initViewBinding(): ActivityWxarticleBinding {
        return ActivityWxarticleBinding.inflate(layoutInflater)
    }

    override fun initData() {
        wxArticleAdapter = WXArticleAdapter { wxArticleBean ->

        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.rvData.apply {
            layoutManager = LinearLayoutManager(this@WXArticleActivity)
            adapter = wxArticleAdapter
        }
    }

    override fun loadData() {
        binding.swipeRefresh.isRefreshing = true
        mViewModel.wxArticle()
    }

    override fun initEvent() {
        with(binding) {
            swipeRefresh.setOnRefreshListener {
                loadData()
            }

            tvLogin.setOnClickListener(NoMultiClickListener {
                startActivity(Intent(this@WXArticleActivity, LoginActivity::class.java))
                finish()
            })
        }

    }

    override fun initUiSate() {
        mViewModel.wxArticleLiveDataUiSate.observe(this) {
            binding.swipeRefresh.isRefreshing = false
            when (it.state) {
                ApiResposeState.Loading -> {}

                ApiResposeState.Success -> {
                    wxArticleAdapter.setData(it.wxArticleBeanList)
                }

                ApiResposeState.Fail -> {}
            }
        }
    }

}