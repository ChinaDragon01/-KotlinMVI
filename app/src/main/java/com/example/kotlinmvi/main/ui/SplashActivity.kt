package com.example.kotlinmvi.main.ui

import android.content.Intent
import android.widget.TextView
import com.example.baselib.base.BaseActivity
import com.example.baselib.base.BaseEmptyViewModel
import com.example.baselib.extension.countDown
import com.example.baselib.impl.NoMultiClickListener
import com.example.baselib.utils.LogUtil
import com.example.kotlinmvi.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class SplashActivity : BaseActivity<BaseEmptyViewModel, ActivitySplashBinding>() {
    private var mCountDownJob: CoroutineScope? = null
    private lateinit var tvCountDown: TextView
    override fun initViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun initData() {
        super.initData()
        tvCountDown = binding.tvCountDown
        val second3 = 3
        this.countDown(time = second3, start = {
            tvCountDown.setText("跳过 $second3 秒")
            mCountDownJob = it
        }, end = {
            LogUtil.i("SplashActivity", "倒计时结束了")
            //正式项目里需要判断用户是否已登录 TODO
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()

        }, next = {
            LogUtil.i("SplashActivity", "跳过 $it 秒")
            tvCountDown.setText("跳过 ${it - 1} 秒")

        }, error = {

        })
    }

    override fun initEvent() {
        tvCountDown.setOnClickListener(NoMultiClickListener {
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        })
    }

    override fun onDestroy() {
        mCountDownJob?.let {
            it.cancel()
        }
        super.onDestroy()
    }
}