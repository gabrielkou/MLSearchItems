package com.gabrielkou.data.mapper

import com.gabrielkou.data.model.ItemDetailEntity
import com.gabrielkou.domain.model.ItemDetail
import javax.inject.Inject

open class ItemDetailMapper @Inject constructor(): EntityMapper<ItemDetailEntity, ItemDetail> {
    override fun mapFromEntity(entity: ItemDetailEntity): ItemDetail {
        return ItemDetail(entity.title, entity.price, entity.seller)
    }

    override fun mapToEntity(domain: ItemDetail): ItemDetailEntity {
        return ItemDetailEntity(domain.title, domain.price, domain.seller)
    }
}