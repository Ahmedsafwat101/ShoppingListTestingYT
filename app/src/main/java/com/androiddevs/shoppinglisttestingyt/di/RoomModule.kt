package com.androiddevs.shoppinglisttestingyt.di

import android.content.Context
import androidx.room.Room
import com.androiddevs.shoppinglisttestingyt.Constants.DATABASE_NAME
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingDAO
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideShoppingSDatabase(@ApplicationContext context: Context):ShoppingDatabase{
        return Room.databaseBuilder(
            context,
            ShoppingDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun providesShoppingDAO(shoppingDatabase: ShoppingDatabase):ShoppingDAO{
        return shoppingDatabase.shoppingDao()
    }



}