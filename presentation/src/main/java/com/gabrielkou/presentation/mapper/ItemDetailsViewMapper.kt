package com.gabrielkou.presentation.mapper

import com.gabrielkou.domain.model.ItemDetail
import com.gabrielkou.presentation.model.ItemDetailsView
import javax.inject.Inject

open class ItemDetailsViewMapper @Inject constructor():Mapper<ItemDetailsView, ItemDetail> {
    override fun mapToView(type: ItemDetail): ItemDetailsView {
        return ItemDetailsView(type.title, type.price, type.condition, type.thumbnail)
    }
}