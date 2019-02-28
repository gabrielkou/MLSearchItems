package com.gabrielkou.remote.mapper

import com.gabrielkou.data.model.ItemEntity
import com.gabrielkou.ml.data.model.ResultsItem
import com.gabrielkou.ml.data.model.SearchResponse

open class ItemsResponseModelMapper : EntityMapper<ResultsItem, ItemEntity> {

    override fun mapFromRemote(model: ResultsItem): ItemEntity {
        return ItemEntity(model.id, model.title, model.thumbnail)
    }


}