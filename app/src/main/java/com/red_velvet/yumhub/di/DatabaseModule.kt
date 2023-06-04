package com.red_velvet.yumhub.di

import android.content.Context
import androidx.room.Room
import com.red_velvet.yumhub.data.local.FoodDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideFoodDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            FoodDatabase::class.java,
            "foodDatabase"
        ).build()

    @Singleton
    @Provides
    fun provideRecipeDao(foodDatabase: FoodDatabase) = foodDatabase.recipeDao()

    @Provides
    @Singleton
    fun providesMealsDao(foodDatabase: FoodDatabase) = foodDatabase.mealsDao()
}