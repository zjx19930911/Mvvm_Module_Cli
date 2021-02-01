package com.iflytek.mvvm_cli.di

import android.app.Application
import com.iflytek.mvvm_cli.login_module.di.loginAppModule
import com.iflytek.mvvm_cli.main_module.di.mainAppModule
import com.iflytek.mvvm_cli.mine_module.di.mineAppModule
import com.iflytek.mvvm_cli.model.AppMainModel
import com.iflytek.mvvm_cli.viewmodel.AppMainViewModel
import com.iflytek.mvvm_cli.viewmodel.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val AppMainViewModelModule = module {
    viewModel {
            (animal: AppMainModel, application: Application) ->
        AppMainViewModel(animal, application)
//        AppMainViewModel(animal = Animal("dog", 0), application = androidApplication())
    }

}

val SplashViewModel = module {
    viewModel {
        SplashViewModel(application = androidApplication())
    }
}
val viewModelModule = module {
    single {
        AppMainViewModel(appMainModel = AppMainModel("dog", 0), application = androidApplication())
    }

}

val appModuleList by lazy {
    {
        val list: MutableList<Module> = ArrayList();
        list.add(AppMainViewModelModule)
        list.add(SplashViewModel)
        list.addAll(loginAppModule)
        list.addAll(mainAppModule)
        list.addAll(mineAppModule)
        list.toList()
    }
}

var appModule = appModuleList()