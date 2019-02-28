package com.gabrielkou.data.mapper

import com.gabrielkou.data.model.ItemEntity
import com.gabrielkou.data.test.ItemFactory
import com.gabrielkou.domain.model.Item
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class ItemMapperTest {

    private val mapper = ItemMapper()

    @Test
    fun mapFromEntityMapsData(){
        val entity = ItemFactory.makeItemEntity()
        val model = mapper.mapFromEntity(entity)

        assertEqualData(entity, model)
    }

    @Test
    fun mapToEntityMapsData(){
        val model = ItemFactory.makeItem()
        val entity = mapper.mapToEntity(model)

        assertEqualData(entity, model)
    }

    private fun assertEqualData(entity: ItemEntity, model: Item){
        assertEquals(entity.id, model.id)
        assertEquals(entity.imageUrl, model.imageUrl)
        assertEquals(entity.title, model.title)
    }
}