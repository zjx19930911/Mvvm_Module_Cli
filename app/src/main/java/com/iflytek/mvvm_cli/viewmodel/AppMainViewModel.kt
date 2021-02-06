package com.iflytek.mvvm_cli.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.iflytek.commonlib.database.User
import com.iflytek.commonlib.extens.postResult
import com.iflytek.commonlib.extens.subscribeFilter
import com.iflytek.commonlib.liveData.MyMutableLiveData
import com.iflytek.mvvm_cli.model.AppMainModel

/**
 * 页面描述：AppMainViewModel
 * @param appMainModel(MVVM 中的M),负责提供ViewModel中需要处理的数据
 * Created by Jianxin on 2021/1/6.
 */

open class AppMainViewModel(val appMainModel: AppMainModel, application: Application) :
    AndroidViewModel(application) {
    val detailResult = MyMutableLiveData<User>()

    fun detail() {
        appMainModel.getUserDetail()?.subscribeFilter({
            println("成功啦:" + it?.name)
            detailResult.postResult(true, it)
        }, { message, code ->
            println("错误信息：$message")
            detailResult.postResult(isSuccess = false, errorMessage = message, code = code)
        })
    }

    fun insert(user: User) {
        appMainModel.insertUser(user)
    }

}