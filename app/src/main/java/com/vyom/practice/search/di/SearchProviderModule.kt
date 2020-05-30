package com.vyom.practice.search.di

import com.vyom.practice.dagger.NetworkModule
import com.vyom.practice.data.WikiApiService
import com.vyom.practice.search.SearchRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class SearchProviderModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideWikiApiService(retrofit: Retrofit): WikiApiService {
            return retrofit.create(WikiApiService::class.java)
        }
    }

    @Provides
    internal fun provideSearchRepository(service: WikiApiService): SearchRepository {
        return SearchRepository(service)
    }

}