package com.vyom.practice.dagger

import com.vyom.practice.application.PracticeApplication
import com.vyom.practice.search.di.SearchFeatureModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        AppModule::class,
        SearchFeatureModule::class]
)
interface AppComponent {

    fun inject(app: PracticeApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: PracticeApplication): Builder
        fun build(): AppComponent
    }

}