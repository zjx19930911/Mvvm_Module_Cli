package com.iflytek.mvvm_module_cli.di

import com.iflytek.commonlib.database.AppDatabase
import com.iflytek.commonlib.net.NetManager
import com.iflytek.mvvm_module_cli.login_module.di.loginAppModule
import com.iflytek.mvvm_module_cli.main_module.di.mainAppModule
import com.iflytek.mvvm_module_cli.mine_module.di.mineAppModule
import com.iflytek.mvvm_module_cli.model.AppMainModel
import com.iflytek.mvvm_module_cli.viewmodel.AppMainViewModel
import com.iflytek.mvvm_module_cli.viewmodel.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val AppMainViewModelModule = module {
    viewModel {
//            (appMain: AppMainModel, application: Application) ->
//        AppMainViewModel(appMain, application)
        AppMainViewModel(
            appMainModel = AppMainModel(
                NetManager,
                AppDatabase.getInstance(androidApplication()).userDao()
            ), application = androidApplication()
        )
    }

}

val SplashViewModel = module {
    viewModel {
        SplashViewModel(application = androidApplication())
    }
}
val viewModelModule = module {
    single {
        AppMainViewModel(
            appMainModel = AppMainModel(
                NetManager,
                AppDatabase.getInstance(androidApplication()).userDao()
            ), application = androidApplication()
        )
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