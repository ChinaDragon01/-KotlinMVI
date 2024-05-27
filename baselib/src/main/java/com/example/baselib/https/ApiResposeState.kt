package com.example.baselib.https

/**
 *Author: chinadragon
 *Time: 2024/5/27
 */
sealed class ApiResposeState {
    object Success : ApiResposeState()
    object Fail : ApiResposeState()
    object Loading : ApiResposeState()
}
