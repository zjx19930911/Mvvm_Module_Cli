package com.iflytek.mvvm_cli.mine_module.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.iflytek.mvvm_cli.mine_module.model.MineModel

/**
 * Created by Jianxin on 2021/1/13.
 */

class MineViewModel(application: Application, var model: MineModel?) :
    AndroidViewModel(application) {
}