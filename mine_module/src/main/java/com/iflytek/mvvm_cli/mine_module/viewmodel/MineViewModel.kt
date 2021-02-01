package com.iflytek.mvvm_cli.mine_module.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.iflytek.commonlib.net.MyObserver
import com.iflytek.mvvm_cli.mine_module.model.MineModel

/**
 * Created by Jianxin on 2021/1/13.
 */

class MineViewModel(application: Application, var model: MineModel?) :
    AndroidViewModel(application) {
    val loginSuccess = MutableLiveData<MineModel>()
    val loginFailed = MutableLiveData<String>()

    fun login(acc: String, pwd: String) {
        model?.login(acc, pwd)?.subscribe(object : MyObserver<MineModel>() {
            override fun onSuccess(data: MineModel?) {
                loginSuccess.value = data;
            }

            override fun onFailed(message: String, code: Int) {
                loginFailed.value = message
            }

        })

    }
}