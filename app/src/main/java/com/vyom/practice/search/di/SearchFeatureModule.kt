package com.vyom.practice.search.di

import com.vyom.practice.search.SearchActivity
import com.vyom.practice.dagger.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
* This class will contain all the activities and fragments related to search feature.
 */
@Module
abstract class SearchFeatureModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun contributeMainActivity(): SearchActivity

}