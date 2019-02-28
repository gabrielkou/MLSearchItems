package com.gabrielkou.remote

import com.gabrielkou.data.model.ItemDetailEntity
import com.gabrielkou.data.model.ItemEntity
import com.gabrielkou.data.repository.ItemsRemote
import com.gabrielkou.remote.mapper.ItemDetailsResponseModelMapper
import com.gabrielkou.remote.mapper.ItemsResponseModelMapper
import com.gabrielkou.remote.service.ItemsService
import io.reactivex.Observable
import javax.inject.Inject

open class ItemsRemoteImpl @Inject constructor(
    private val service:ItemsService,
    private val itemDetailsResponseMapper: ItemDetailsResponseModelMapper,
    private val itemsResponseMapper: ItemsResponseModelMapper) : ItemsRemote {

    override fun getItemDetails(itemId: String): Observable<ItemDetailEntity> {
        return service.getItemDetails(itemId)
            .map {
                itemDetailsResponseMapper.mapFromRemote(it) }
    }

    override fun searchItems(query: String): Observable<List<ItemEntity>> {
        return service.searchProducts(query)
            .map { it.results!! }
            .map {
                val entities = mutableListOf<ItemEntity>()
                it.forEach { entities.add(itemsResponseMapper.mapFromRemote(it)) }
                entities
            }
        }
}