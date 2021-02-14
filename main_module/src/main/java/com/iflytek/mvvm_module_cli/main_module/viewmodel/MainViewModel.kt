package com.iflytek.mvvm_module_cli.main_module.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.iflytek.mvvm_module_cli.main_module.model.MainModel

/**
 * Created by Jianxin on 2021/1/13.
 */

class MainViewModel(application: Application, var model: MainModel?) :
    AndroidViewModel(application) {

}