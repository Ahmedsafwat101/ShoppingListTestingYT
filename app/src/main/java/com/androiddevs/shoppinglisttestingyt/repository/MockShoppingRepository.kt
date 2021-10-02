package com.androiddevs.shoppinglisttestingyt.repository

import androidx.lifecycle.LiveData
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingDAO
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingItem
import com.androiddevs.shoppinglisttestingyt.data.remote.PixabayAPI
import com.androiddevs.shoppinglisttestingyt.data.remote.responses.ImageResponse
import com.androiddevs.shoppinglisttestingyt.util.DataState

class MockShoppingRepository(
    private val shoppingDAO: ShoppingDAO,
    private val pixabayAPI: PixabayAPI
):ShoppingRepository {
    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        TODO("Not yet implemented")
    }

    override fun observeAllItems(): LiveData<List<ShoppingItem>> {
        TODO("Not yet implemented")
    }

    override fun observeTotalPrice(): LiveData<Float> {
        TODO("Not yet implemented")
    }

    override suspend fun searchForImage(): DataState<ImageResponse> {
        TODO("Not yet implemented")
    }
}