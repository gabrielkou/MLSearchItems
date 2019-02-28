package com.gabrielkou.data.store

import com.gabrielkou.data.repository.ItemsDataStore
import javax.inject.Inject

open class ItemsDataStoreFactory @Inject constructor(
//    private val itemsCacheDataStore: ItemsCacheDataStore,
    private val itemsRemoteDataStore: ItemsRemoteDataStore) {

    open fun getDataStore() :ItemsDataStore{
//        return if (itemsCached && !cacheExpired){
//            itemsCacheDataStore
//        } else {
        return    itemsRemoteDataStore
        }
    }

//    open fun getCacheDataStore(): ItemsDataStore {
//        return itemsCacheDataStore
//    }
//
//    fun getRemoteDatStore() : ItemsDataStore{
//        return itemsRemoteDataStore
//    }
//}