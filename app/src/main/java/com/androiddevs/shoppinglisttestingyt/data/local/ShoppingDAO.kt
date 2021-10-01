package com.androiddevs.shoppinglisttestingyt.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item:ShoppingItem)

    @Delete
    suspend fun deleteItem(item:ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun observeAllItems():LiveData<List<ShoppingItem>>

    @Query("SELECT SUM(price*amount) FROM shopping_items")
    fun observeTotalPrice():LiveData<Float>
}