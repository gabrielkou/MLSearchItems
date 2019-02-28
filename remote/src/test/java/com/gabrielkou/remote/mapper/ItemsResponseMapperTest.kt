package com.gabrielkou.remote.mapper

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ItemsResponseMapperTest {
    private lateinit var mapper: ItemsResponseModelMapper

    @Before
    fun setUp(){
        mapper = ItemsResponseModelMapper()
    }

    @Test
    fun mapFromRemoteMapsData(){
//        val resultsItem = ResultItemFactory.makeResultItem
//        val itemEntity = mapper.mapFromRemote(resultsItem)
    }
}