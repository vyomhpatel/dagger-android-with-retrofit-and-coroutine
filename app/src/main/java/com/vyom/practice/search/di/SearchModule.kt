package com.vyom.practice.search.di

import androidx.lifecycle.ViewModel
import com.vyom.practice.search.SearchActivityViewModel
import com.vyom.practice.util.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [SearchProviderModule::class])
abstract class SearchModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchActivityViewModel::class)
    internal abstract fun bindMainActivityViewModel(viewModel: SearchActivityViewModel): ViewModel

}