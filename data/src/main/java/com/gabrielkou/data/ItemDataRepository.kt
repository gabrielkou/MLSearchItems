package com.gabrielkou.data

import com.gabrielkou.data.mapper.ItemDetailMapper
import com.gabrielkou.data.mapper.ItemMapper
import com.gabrielkou.data.store.ItemsDataStoreFactory
import com.gabrielkou.domain.model.Item
import com.gabrielkou.domain.model.ItemDetail
import com.gabrielkou.domain.repository.ItemsRepository
import io.reactivex.Observable
import javax.inject.Inject

class ItemDataRepository @Inject constructor(
    private val mapper: ItemMapper,
    private val itemDetailMapper: ItemDetailMapper,
    private val factory: ItemsDataStoreFactory) : ItemsRepository{

    override fun getItemDetails(itemId: String): Observable<ItemDetail> {
        return  factory.getDataStore().getItemDetails(itemId)
            .map {
                itemDetailMapper.mapFromEntity(it)
            }
    }

    override fun searchItems(query: String?): Observable<List<Item>> {
        return factory.getDataStore().searchItems(query!!)
            .map{
                it.map {
                    mapper.mapFromEntity(it)
                }
            }
    }

}