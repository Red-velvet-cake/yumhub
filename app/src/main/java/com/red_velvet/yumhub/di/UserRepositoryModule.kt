package com.red_velvet.yumhub.di


import com.red_velvet.yumhub.data.repositories.RecipesRepository
import com.red_velvet.yumhub.data.repositories.RecipesRepositoryImpl
import com.red_velvet.yumhub.data.repositories.UserRepository
import com.red_velvet.yumhub.data.repositories.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserRepositoryModule {

    @Provides
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository {
        return userRepositoryImpl
    }
    @Provides
    fun provideRecipeRepository(recipesRepositoryImpl: RecipesRepositoryImpl): RecipesRepository {
        return recipesRepositoryImpl
    }

}
