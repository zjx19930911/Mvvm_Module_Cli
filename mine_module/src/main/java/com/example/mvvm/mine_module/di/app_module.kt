package com.example.mvvm.mine_module.di

import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import com.example.mvvm.mine_module.model.MineModel
import com.example.mvvm.mine_module.viewmodel.MineViewModel
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