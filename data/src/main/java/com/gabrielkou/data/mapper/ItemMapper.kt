package com.gabrielkou.data.mapper

import com.gabrielkou.data.model.ItemEntity
import com.gabrielkou.domain.model.Item
import javax.inject.Inject

open class ItemMapper @Inject constructor() :EntityMapper<ItemEntity, Item> {
    override fun mapFromEntity(entity: ItemEntity): Item {
        return Item(entity.id, entity.title, entity.imageUrl)
    }

    override fun mapToEntity(domain: Item): ItemEntity {
        return ItemEntity(domain.id, domain.title, domain.imageUrl)
    }
}