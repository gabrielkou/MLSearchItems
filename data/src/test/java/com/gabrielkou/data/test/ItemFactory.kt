package com.gabrielkou.data.test

import com.gabrielkou.data.model.ItemEntity
import com.gabrielkou.domain.model.Item

object ItemFactory {

    fun makeItemEntity(): ItemEntity{
        return ItemEntity(DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString())
    }

    fun makeItem(): Item{
        return Item(DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString())
    }
}