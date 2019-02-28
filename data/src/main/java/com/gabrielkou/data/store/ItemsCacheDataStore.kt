package com.gabrielkou.data.store

import com.gabrielkou.data.model.ItemEntity
import com.gabrielkou.data.repository.ItemsCache
import com.gabrielkou.data.repository.ItemsDataStore
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

open class ItemsCacheDataStore @Inject constructor(
    private val itemsCache: ItemsCache): ItemsDataStore {
    override fun clearItems(): Completable {
        return itemsCache.clearItems()
    }

    override fun saveItems(projects: List<ItemEntity>): Completable {
        return itemsCache.saveItems(projects)
    }

    override fun searchItems(query: String): Observable<List<ItemEntity>> {
        return itemsCache.searchItems(query)
    }
}