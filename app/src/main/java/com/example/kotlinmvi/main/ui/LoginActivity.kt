package com.example.kotlinmvi.main.ui

import android.content.Intent
import android.os.Bundle
import com.example.baselib.base.BaseActivity
import com.example.baselib.impl.NoMultiClickListener
import com.example.baselib.utils.ToastUtil
import com.example.kotlinmvi.databinding.ActivityLoginBinding
import com.example.kotlinmvi.home.ui.WXArticleActivity
import com.example.kotlinmvi.main.model.LoginIntent
import com.example.kotlinmvi.main.model.LoginViewModel

/**
 *Author: chinadragon
 *Time: 2024/5/19
 */
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override fun initViewBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
    }

    override fun initData() {
        super.initData()
    }

    override fun initEvent() {
        super.initEvent()
        with(binding) {
            btnLogin.setOnClickListener(NoMultiClickListener {
                val account = etUserName.text.toString()
                val pwd = etPwd.text.toString()
//                if (account.isNullOrBlank() || pwd.isNullOrBlank()) {
//                    ToastUtil.show(com.example.baselib.R.string.login_error_tip)
//                    return@NoMultiClickListener
//                }
                mViewModel.emitloginIntent(LoginIntent.LoginAction(account, pwd))
            })

            btnLookWXArticle.setOnClickListener(NoMultiClickListener {
                startActivity(Intent(this@LoginActivity, WXArticleActivity::class.java))
                finish()
            })
        }
    }

    override fun initUiSate() {
        mViewModel.loginLiveDataUiSate.observe(this) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
    }
}