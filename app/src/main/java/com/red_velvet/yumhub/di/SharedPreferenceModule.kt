package com.red_velvet.yumhub.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {

    @Provides
    @Singleton
    fun provideFoodSharedPreference(@ApplicationContext context: Context) =
        context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
}