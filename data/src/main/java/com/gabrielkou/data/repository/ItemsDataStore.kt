package com.gabrielkou.data.repository

import com.gabrielkou.data.model.ItemDetailEntity
import com.gabrielkou.data.model.ItemEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface ItemsDataStore {

    fun clearItems(): Completable

    fun saveItems(projects: List<ItemEntity>): Completable

    fun searchItems(query:String): Observable<List<ItemEntity>>

    fun getItemDetails(itemId:String): Observable<ItemDetailEntity>

}