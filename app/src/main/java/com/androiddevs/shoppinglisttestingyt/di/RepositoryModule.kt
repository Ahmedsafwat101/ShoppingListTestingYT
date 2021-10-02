package com.androiddevs.shoppinglisttestingyt.di

import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingDAO
import com.androiddevs.shoppinglisttestingyt.data.remote.PixabayAPI
import com.androiddevs.shoppinglisttestingyt.repository.DefaultShoppingRepository
import com.androiddevs.shoppinglisttestingyt.repository.MockShoppingRepository
import com.androiddevs.shoppinglisttestingyt.repository.ShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDefaultRepository(
        retrofit:PixabayAPI ,
        shoppingDao:ShoppingDAO,
    ):DefaultShoppingRepository{
       return DefaultShoppingRepository(
           pixabayAPI =  retrofit,
           shoppingDAO = shoppingDao
       )
    }

    @Singleton
    @Provides
    fun provideMockRepository(
        retrofit:PixabayAPI ,
        shoppingDao:ShoppingDAO,
    ):MockShoppingRepository{
        return MockShoppingRepository(
            pixabayAPI =  retrofit,
            shoppingDAO = shoppingDao
        )
    }
}