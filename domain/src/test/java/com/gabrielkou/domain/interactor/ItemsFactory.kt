package com.gabrielkou.domain.interactor

import com.gabrielkou.domain.model.Item
import com.gabrielkou.domain.test.factory.DataFactory.Companion.randomUuid

class ItemsFactory {

    companion object {

        fun makeItemsList(count:Int) : List<Item>{
            val items = mutableListOf<Item>()
            repeat(count){
                items.add(makeItem())
            }
            return items
        }

        fun makeItem():Item {
            return Item(randomUuid(), randomUuid(), randomUuid())
        }
    }
}