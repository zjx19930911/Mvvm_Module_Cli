package com.iflytek.mvvm_module_cli.viewmodel

import android.app.Application
import com.iflytek.commonlib.base.BaseViewModel
import com.iflytek.commonlib.database.User
import com.iflytek.commonlib.extens.postResult
import com.iflytek.commonlib.extens.subscribeFilter
import com.iflytek.commonlib.liveData.MyMutableLiveData
import com.iflytek.mvvm_module_cli.model.AppMainModel

/**
 * 页面描述：AppMainViewModel
 * @param appMainModel(MVVM 中的M),负责提供ViewModel中需要处理的数据
 * Created by Jianxin on 2021/1/6.
 */

open class AppMainViewModel(val appMainModel: AppMainModel, application: Application) :
    BaseViewModel(application) {
    val detailResult = MyMutableLiveData<User>()

    fun detail() {
        appMainModel.getUserDetail()?.subscribeFilter(this,{
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