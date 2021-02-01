package com.iflytek.mvvm_cli.login_module.di

import com.iflytek.mvvm_cli.login_module.model.LoginModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import com.iflytek.mvvm_cli.login_module.viewmodel.LoginViewModel
import org.koin.dsl.module


val LoginViewModel = module {
    viewModel {
        LoginViewModel(
            application = androidApplication(),
            model = LoginModel()
        )
    }
}


val loginAppModule = listOf(LoginViewModel)