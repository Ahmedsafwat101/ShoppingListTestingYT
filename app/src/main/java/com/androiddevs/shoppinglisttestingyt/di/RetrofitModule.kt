package com.androiddevs.shoppinglisttestingyt.di

import com.androiddevs.shoppinglisttestingyt.Constants.BASE_URL
import com.androiddevs.shoppinglisttestingyt.data.remote.PixabayAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit.Builder{
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun providePixabayAPI(retrofit: Retrofit.Builder):PixabayAPI {
        return retrofit
            .build()
            .create(PixabayAPI::class.java)
    }

}