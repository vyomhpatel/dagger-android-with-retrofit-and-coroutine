package com.vyom.practice.application

import android.app.Activity
import android.app.Application
import com.vyom.practice.dagger.AppComponent
import com.vyom.practice.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class PracticeApplication : Application(), HasActivityInjector {
    private lateinit var appComponent: AppComponent

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }
}