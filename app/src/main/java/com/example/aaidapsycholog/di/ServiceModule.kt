package com.example.aaidapsycholog.di

import com.example.aaidapsycholog.data.api.ApiService
import com.example.aaidapsycholog.repo.MainRepository
import com.example.aaidapsycholog.repo.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideAaidaService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(api: ApiService) = MainRepository(api) as Repository

}