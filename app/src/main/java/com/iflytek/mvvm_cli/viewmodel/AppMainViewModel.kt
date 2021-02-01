package com.iflytek.mvvm_cli.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.iflytek.mvvm_cli.model.AppMainModel

/**
 * 页面描述：AppMainViewModel
 * @param animal 数据源Model(MVVM 中的M),负责提供ViewModel中需要处理的数据
 * Created by Jianxin on 2021/1/6.
 */

class AppMainViewModel(
    val appMainModel: AppMainModel,
    application: Application
) : AndroidViewModel(application) {
    //////////////////data//////////////
    val info = MutableLiveData<String>()
    val toast = MutableLiveData<String>()

    //////////////////binding//////////////
    fun shout() {
        appMainModel.shoutCount++
        info.value = "${appMainModel.name} 叫了 ${appMainModel.shoutCount}声.."
    }



}