package com.red_velvet.yumhub.di


import com.red_velvet.yumhub.domain.repositories.UserRepository
import com.red_velvet.yumhub.repositories.UserRepositoryImpl
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

}
