package com.iflytek.mvvm_module_cli.mine_module.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.iflytek.mvvm_module_cli.mine_module.model.MineModel

/**
 * Created by Jianxin on 2021/1/13.
 */

class MineViewModel(application: Application, var model: MineModel?) :
    AndroidViewModel(application) {
}