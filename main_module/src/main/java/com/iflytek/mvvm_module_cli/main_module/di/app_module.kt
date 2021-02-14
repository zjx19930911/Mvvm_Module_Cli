package com.iflytek.mvvm_module_cli.main_module.di

import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import com.iflytek.mvvm_module_cli.main_module.model.MainModel
import com.iflytek.mvvm_module_cli.main_module.viewmodel.MainViewModel
import org.koin.dsl.module


val mainViewModel = module {
    viewModel {
        MainViewModel(
            application = androidApplication(),
            model = MainModel()
        )
    }
}


val mainAppModule = listOf(mainViewModel)