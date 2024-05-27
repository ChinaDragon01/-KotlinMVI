package com.example.kotlinmvi.home.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.baselib.https.ApiResposeState
import com.example.baselib.base.BaseViewModel
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiResponse
import com.example.kotlinmvi.home.respository.WXArticleRespository
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/**
 *Author: chinadragon
 *Time: 2024/5/27
 */
class WXArticleViewModel() :
    BaseViewModel<WXArticleRespository>() {

    private val _wxArticleLiveDataUiSate = MutableLiveData<WXArticleUiState>()
    val wxArticleLiveDataUiSate: LiveData<WXArticleUiState> = _wxArticleLiveDataUiSate

    fun wxArticle() {

        launchApiCall({ repository.wxArticle() }, successCallBack = {
            _wxArticleLiveDataUiSate.value =
                WXArticleUiState(it.data ?: emptyList(), ApiResposeState.Success)

        }, errorCallBack = {
            _wxArticleLiveDataUiSate.value = WXArticleUiState(state = ApiResposeState.Fail)

        }, exceptionCallBack = {
            _wxArticleLiveDataUiSate.value = WXArticleUiState(state = ApiResposeState.Fail)

        })

        //演示使用rxjava3
//        wrapObservable(repository.wxArticle2()).subscribe(object :
//            Observer<ApiResponse<List<WXArticleBean>?>> {
//            override fun onSubscribe(d: Disposable) {
//                listDisposable.add(d)
//            }
//
//            override fun onError(e: Throwable) {
//                _wxArticleLiveDataUiSate.value = WXArticleUiState(state = ApiResposeState.Fail)
//            }
//
//            override fun onComplete() {
//            }
//
//            override fun onNext(response: ApiResponse<List<WXArticleBean>?>) {
//                _wxArticleLiveDataUiSate.value =
//                    WXArticleUiState(response.data ?: emptyList(), ApiResposeState.Success)
//
//            }
//
//        })
    }
}

data class WXArticleUiState(
    val wxArticleBeanList: List<WXArticleBean> = emptyList(),
    val state: ApiResposeState
)
