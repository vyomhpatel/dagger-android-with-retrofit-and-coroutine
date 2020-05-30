package com.vyom.practice.dagger

import com.vyom.practice.BuildConfig
import com.vyom.practice.data.WikiApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BaseUrl)
            .build()
    }

}