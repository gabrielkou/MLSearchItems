package com.gabrielkou.ml.mapper

import com.gabrielkou.ml.model.ItemViewModel
import com.gabrielkou.presentation.model.ItemView
import javax.inject.Inject

class ItemViewMapper @Inject constructor() :ViewMapper<ItemView, ItemViewModel>{

    override fun mapToView(presentation: ItemView): ItemViewModel {
        return ItemViewModel(presentation.id, presentation.title, presentation.imageUrl)
    }
}