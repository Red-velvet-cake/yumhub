package com.red_velvet.yumhub.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.Date

@Module
@InstallIn(SingletonComponent::class)
object DateModule {

    @Provides
    fun provideDate(): Date {
        return Date()
    }
}