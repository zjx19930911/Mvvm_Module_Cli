package com.example.mvvm.main_module.di

import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import com.example.mvvm.main_module.model.MainModel
import com.example.mvvm.main_module.viewmodel.MainViewModel
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