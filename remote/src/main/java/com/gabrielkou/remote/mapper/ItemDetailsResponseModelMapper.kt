package com.gabrielkou.remote.mapper

import com.gabrielkou.data.model.ItemDetailEntity
import com.gabrielkou.remote.model.details.ItemsResponse
import javax.inject.Inject

open class ItemDetailsResponseModelMapper @Inject constructor(): EntityMapper<ItemsResponse, ItemDetailEntity>{
    override fun mapFromRemote(model: ItemsResponse): ItemDetailEntity {
        return ItemDetailEntity(model.title, model.price.toString(), model.condition)
    }
}