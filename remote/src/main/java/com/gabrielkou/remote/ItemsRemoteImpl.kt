package com.gabrielkou.remote

import com.gabrielkou.data.model.ItemEntity
import com.gabrielkou.data.repository.ItemsRemote
import com.gabrielkou.ml.data.model.ResultsItem
import com.gabrielkou.ml.data.model.SearchResponse
import com.gabrielkou.remote.mapper.ItemsResponseModelMapper
import com.gabrielkou.remote.service.SearchService
import io.reactivex.Observable
import javax.inject.Inject

open class ItemsRemoteImpl @Inject constructor(
    private val service:SearchService,
    private val mapper: ItemsResponseModelMapper) : ItemsRemote {

    override fun searchItems(query: String): Observable<List<ItemEntity>> {
        return service.searchProducts(query)
            .map { it.results!! }
            .map {
                val entities = mutableListOf<ItemEntity>()
                it.forEach { entities.add(mapper.mapFromRemote(it)) }
                entities
            }
        }
}