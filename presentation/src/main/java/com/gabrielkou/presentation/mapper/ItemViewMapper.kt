package com.gabrielkou.presentation.mapper

import com.gabrielkou.domain.model.Item
import com.gabrielkou.presentation.model.ItemView
import javax.inject.Inject

open class ItemViewMapper @Inject constructor() :Mapper<ItemView, Item> {
    override fun mapToView(type: Item): ItemView {
        return ItemView(type.id, type.title, type.imageUrl)
    }
}