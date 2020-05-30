package com.vyom.practice.dagger

import androidx.lifecycle.ViewModelProvider
import com.vyom.practice.util.viewmodel.ProvidingViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindViewModelProviderFactory(factory: ProvidingViewModelFactory): ViewModelProvider.Factory


}