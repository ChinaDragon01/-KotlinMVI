package com.example.kotlinmvi.main.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.baselib.base.BaseViewModel
import com.example.baselib.bean.UserInfoBean
import com.example.baselib.https.ApiResposeState
import com.example.kotlinmvi.main.respository.LoginRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *Author: chinadragonz
 *Time: 2024/5/19
 */
class LoginViewModel :
    BaseViewModel<LoginRepository>() {
    private val _loginLiveDataUiSate = MutableLiveData<LoginUiState>()
    val loginLiveDataUiSate: LiveData<LoginUiState> = _loginLiveDataUiSate

    fun emitloginIntent(loginIntent: LoginIntent) {
        when (loginIntent) {
            is LoginIntent.LoginAction -> {
                login(loginIntent.username, loginIntent.pwd)
            }
        }

    }

    private fun login(username: String, pwd: String) {
        _loginLiveDataUiSate.value = LoginUiState(state = ApiResposeState.Loading)

        //模拟登录成功
        viewModelScope.launch {
            delay(400)
            _loginLiveDataUiSate.value = LoginUiState(state = ApiResposeState.Success)
        }

        return

        val map = mapOf("username" to username, "password" to pwd)
        launchApiCall({ repository.login(map) }, {
            _loginLiveDataUiSate.value = LoginUiState(it.data, ApiResposeState.Success)
        }, {
            _loginLiveDataUiSate.value = LoginUiState(it.data, ApiResposeState.Fail)
        }, {
            _loginLiveDataUiSate.value = LoginUiState(state = ApiResposeState.Fail)
        })

    }
}

data class LoginUiState(val userInfoBean: UserInfoBean? = null, val state: ApiResposeState)

sealed class LoginIntent {
    data class LoginAction(
        val username: String,
        val pwd: String,
    ) : LoginIntent()
}