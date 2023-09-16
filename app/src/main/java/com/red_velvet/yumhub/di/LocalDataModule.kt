package com.red_velvet.yumhub.di

import com.red_velvet.yumhub.domain.repositories.MealRepository
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import com.red_velvet.yumhub.domain.repositories.UserRepository
import com.red_velvet.yumhub.local.LocalDataSourceImpl
import com.red_velvet.yumhub.remote.RemoteDataSourceImpl
import com.red_velvet.yumhub.repositories.MealRepositoryImpl
import com.red_velvet.yumhub.repositories.RecipesRepositoryImpl
import com.red_velvet.yumhub.repositories.UserRepositoryImpl
import com.red_velvet.yumhub.repositories.datasources.LocalDataSource
import com.red_velvet.yumhub.repositories.datasources.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataModule {

    @Binds
    @Singleton
    abstract fun bindLocalDataSources(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    @Singleton
    abstract fun bindRecipeRepository(recipesRepositoryImpl: RecipesRepositoryImpl): RecipesRepository

    @Binds
    @Singleton
    abstract fun bindRemoteDataSourceRepository(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @Singleton
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    abstract fun bindMealRepository(mealRepositoryImpl: MealRepositoryImpl): MealRepository
}