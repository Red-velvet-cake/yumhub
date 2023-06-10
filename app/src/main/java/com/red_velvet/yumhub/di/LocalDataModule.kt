package com.red_velvet.yumhub.di

import com.red_velvet.yumhub.data.local.LocalDataSourceImpl
import com.red_velvet.yumhub.data.repositories.LocalDataSource
import com.red_velvet.yumhub.data.repositories.RecipesRepositoryImpl
import com.red_velvet.yumhub.domain.RecipesRepository
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
}