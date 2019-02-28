package com.gabrielkou.data

import com.gabrielkou.data.mapper.ItemMapper
import com.gabrielkou.data.repository.ItemsCache
import com.gabrielkou.data.store.ItemsDataStoreFactory
import com.gabrielkou.domain.model.Item
import com.gabrielkou.domain.repository.ItemsRepository
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class ItemDataRepository @Inject constructor(
    private val mapper: ItemMapper,
    private val cache: ItemsCache,
    private val factory: ItemsDataStoreFactory) : ItemsRepository{

    override fun searchItems(query: String?): Observable<List<Item>> {
        return Observable.zip(cache.areItemsCached().toObservable(),
            cache.isItemsCacheExpired().toObservable(),
            BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> {
                areCached, isExpired -> Pair(areCached, isExpired)
            })
            .flatMap {
                factory.getDataStore(it.first, it.second).searchItems(query!!)
            }
            .flatMap { items ->
                factory.getCacheDataStore()
                    .saveItems(items)
                    .andThen(Observable.just(items))
            }
            .map{
                it.map {
                    mapper.mapFromEntity(it)
                }
            }
    }

}