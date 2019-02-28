package com.gabrielkou.data.repository

import com.gabrielkou.data.model.ItemEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface ItemsCache {

    fun clearItems(): Completable

    fun saveItems(projects: List<ItemEntity>): Completable

    fun searchItems(query:String): Observable<List<ItemEntity>>

    fun areItemsCached(): Single<Boolean>

    fun isItemsCacheExpired(): Single<Boolean>

}