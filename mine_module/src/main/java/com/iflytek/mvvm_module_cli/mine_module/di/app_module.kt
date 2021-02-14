package com.iflytek.mvvm_module_cli.mine_module.di

import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import com.iflytek.mvvm_module_cli.mine_module.model.MineModel
import com.iflytek.mvvm_module_cli.mine_module.viewmodel.MineViewModel
import org.koin.dsl.module


val mineViewModel = module {
    viewModel {
        MineViewModel(
            application = androidApplication(),
            model = MineModel()
        )
    }
}


val mineAppModule = listOf(mineViewModel)