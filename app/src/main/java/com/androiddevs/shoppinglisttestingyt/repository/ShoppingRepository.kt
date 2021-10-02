package com.androiddevs.shoppinglisttestingyt.repository

import androidx.lifecycle.LiveData
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingItem
import com.androiddevs.shoppinglisttestingyt.data.remote.responses.ImageResponse
import com.androiddevs.shoppinglisttestingyt.util.DataState

interface ShoppingRepository {

    //RoomDB functions

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllItems():LiveData<List<ShoppingItem>>

    fun observeTotalPrice():LiveData<Float>

    //Retrofit functions

    suspend fun searchForImage():DataState<ImageResponse>



}