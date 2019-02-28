package com.gabrielkou.ml.mapper

import com.gabrielkou.ml.model.ItemDetailViewModel
import com.gabrielkou.presentation.model.ItemDetailsView
import javax.inject.Inject

open class ItemDetailViewMapper @Inject constructor():ViewMapper<ItemDetailsView, ItemDetailViewModel> {
    override fun mapToView(presentation: ItemDetailsView): ItemDetailViewModel {
        return ItemDetailViewModel(presentation.title, "$"+presentation.price, "Condition: " + presentation.conition, presentation.thumbnail)
    }
}