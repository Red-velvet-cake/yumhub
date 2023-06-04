package com.red_velvet.yumhub.di

import android.content.Context
import android.content.SharedPreferences
import com.red_velvet.yumhub.data.local.SharedPreferenceImpl
import com.red_velvet.yumhub.data.local.SharedPreferenceService
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
    fun provideFoodSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)


    @Provides
    @Singleton
    fun provideSharedPrefService(sharedPreferenceImpl: SharedPreferenceImpl): SharedPreferenceService {
        return sharedPreferenceImpl
    }
}
