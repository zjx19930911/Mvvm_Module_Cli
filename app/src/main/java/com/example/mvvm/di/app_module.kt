package com.example.mvvm.di

import com.example.mvvm.login_module.di.loginAppModule
import com.example.mvvm.main_module.di.mainAppModule
import com.example.mvvm.mine_module.di.mineAppModule
import com.example.mvvm.model.Animal
import com.example.mvvm.viewmodel.AnimalViewModel
import com.example.mvvm.viewmodel.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val AnimalViewModelModule = module {
    viewModel {
//            (animal: Animal, application: Application) ->
//        AnimalViewModel(animal, application)
        AnimalViewModel(animal = Animal("dog", 0), application = androidApplication())
    }

}

val SplashViewModel = module {
    viewModel {
        SplashViewModel(application = androidApplication())
    }
}
val viewModelModule = module {
    single {
        AnimalViewModel(animal = Animal("dog", 0), application = androidApplication())
    }

}

val appModuleList by lazy {
    {
        val list: MutableList<Module> = ArrayList();
        list.add(AnimalViewModelModule)
        list.add(SplashViewModel)
        list.addAll(loginAppModule)
        list.addAll(mainAppModule)
        list.addAll(mineAppModule)
        list.toList()
    }
}

var appModule = appModuleList()