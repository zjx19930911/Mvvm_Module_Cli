package com.iflytek.mvvm_cli.login_module.di

import com.iflytek.commonlib.database.AppDatabase
import com.iflytek.commonlib.net.NetManager
import com.iflytek.mvvm_cli.login_module.model.LoginModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import com.iflytek.mvvm_cli.login_module.viewmodel.LoginViewModel
import org.koin.dsl.module


val LoginViewModel = module {
    viewModel {
        LoginViewModel(
            application = androidApplication(),
            model = LoginModel(NetManager)
        )
    }
}


val loginAppModule = listOf(LoginViewModel)