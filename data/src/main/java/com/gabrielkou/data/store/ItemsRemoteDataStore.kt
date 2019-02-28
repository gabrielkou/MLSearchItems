package com.gabrielkou.data.store

import com.gabrielkou.data.model.ItemDetailEntity
import com.gabrielkou.data.model.ItemEntity
import com.gabrielkou.data.repository.ItemsDataStore
import com.gabrielkou.data.repository.ItemsRemote
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

open class ItemsRemoteDataStore @Inject constructor(
    private val itemsRemote:ItemsRemote) :ItemsDataStore {
    override fun clearItems(): Completable {
        throw UnsupportedOperationException("Clearing items isn't supported here...")
    }

    override fun saveItems(projects: List<ItemEntity>): Completable {
        throw UnsupportedOperationException("Clearing items isn't supported here...")
    }

    override fun searchItems(query: String): Observable<List<ItemEntity>> {
        return itemsRemote.searchItems(query)
    }

    override fun getItemDetails(itemId:String): Observable<ItemDetailEntity>{
        return itemsRemote.getItemDetails(itemId)
    }
}