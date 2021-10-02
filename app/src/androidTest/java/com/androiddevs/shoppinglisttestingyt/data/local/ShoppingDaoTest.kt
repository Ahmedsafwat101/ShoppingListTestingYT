package com.androiddevs.shoppinglisttestingyt.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.androiddevs.shoppinglisttestingyt.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 *  RunWith(AndroidJUnit4::class) Use to test java or kotlin code
 *  but we are not in such a plain java or kotlin directory
 *  SmallTest  -> UnitTest
 *  MiddleTest -> Integrated Test
 *  LargeTest  -> UI Test
 * **/


@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ShoppingDatabase
    private lateinit var shoppingDAO: ShoppingDAO

    @Before
    fun setUp(){
        /**
         * inMemoryDatabaseBuilder holding database on RAM
         * allowMainThreadQueries() we need to run test on MainThread not in background thread**/
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShoppingDatabase::class.java
        ).allowMainThreadQueries().build()
        shoppingDAO = database.shoppingDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    /**
     * runBlockingTest a modified version of runBlocking that allow you to run suspend functions
     * in main thread an block it till if finish
     * **/
    @Test
    fun insertShoppingItemTest()= runBlockingTest {
        val shoppingItem = ShoppingItem(1,"Item1","url",10,10f)
        shoppingDAO.insertItem(shoppingItem)

        val allShoppingItem = shoppingDAO.observeAllItems().getOrAwaitValue()

        assertThat(allShoppingItem).contains(shoppingItem)
    }


    @Test
    fun deleteShoppingItemTest()= runBlockingTest {
        val shoppingItem = ShoppingItem(1,"Item1","url",10,10f)
        shoppingDAO.deleteItem(shoppingItem)

        val allShoppingItem = shoppingDAO.observeAllItems().getOrAwaitValue()

        assertThat(allShoppingItem).doesNotContain(shoppingItem)
    }


    @Test
    fun observerAllTotalPricesTest()= runBlockingTest {
        val shoppingItem1 = ShoppingItem(1,"Item1","url",10,10f)
        val shoppingItem2 = ShoppingItem(2,"Item2","url",5,8f)
        val shoppingItem3 = ShoppingItem(3,"Item3","url",3,100f)

        shoppingDAO.insertItem(shoppingItem1)
        shoppingDAO.insertItem(shoppingItem2)
        shoppingDAO.insertItem(shoppingItem3)

        val totalPriceShoppingItem = shoppingDAO.observeTotalPrice().getOrAwaitValue()

        assertThat(totalPriceShoppingItem).isEqualTo(10*10f+5*8f+3*100f)
    }







}












