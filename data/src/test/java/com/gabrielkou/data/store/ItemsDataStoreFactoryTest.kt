package com.gabrielkou.data.store

import com.gabrielkou.data.repository.ItemsCache
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ItemsDataStoreFactoryTest {

    private lateinit var itemCache: ItemsCache

    private val cacheStore = mock<ItemsCacheDataStore>()
    private val remoteStore = mock<ItemsRemoteDataStore>()
    private val factory = ItemsDataStoreFactory(cacheStore, remoteStore)


    @Test
    fun getDataStoreReturnsRemoteStoreWhenCacheExpired(){
        assertEquals(remoteStore, factory.getDataStore(true, true))
    }

    @Test
    fun getDataStoreReturnsRemoteStoreWhenItemsNotCached() {
        assertEquals(remoteStore, factory.getDataStore(false, false))
    }

    @Test
    fun getDataStoreReturnsCacheStore() {
        assertEquals(cacheStore, factory.getDataStore(true, false))
    }

    @Test
    fun getCacheDataStoreReturnsCacheStore() {
        assertEquals(cacheStore, factory.getCacheDataStore())
    }

}