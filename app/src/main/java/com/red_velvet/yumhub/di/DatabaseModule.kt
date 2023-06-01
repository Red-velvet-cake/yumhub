package com.red_velvet.yumhub.di

import android.content.Context
import androidx.room.Room
import com.red_velvet.yumhub.data.local.FoodDatabase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

        fun provideFoodDatabase(@ApplicationContext context: Context) =
            Room.databaseBuilder(
                context,
                FoodDatabase::class.java,
                "foodDatabase"
            ).build()

}