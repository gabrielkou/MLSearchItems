package com.gabrielkou.data.store

import com.gabrielkou.data.model.ItemEntity
import com.gabrielkou.data.repository.ItemsRemote
import com.gabrielkou.data.test.DataFactory
import com.gabrielkou.data.test.ItemFactory
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import io.reactivex.Observable

@RunWith(JUnit4::class)
class ItemsRemoteDataStoreTest {

    private val remote = mock<ItemsRemote>()
    private val store = ItemsRemoteDataStore(remote)

    @Test
    fun searchItemsCompletes(){
        stubRemoteSearchProjects(Observable.just(listOf(ItemFactory.makeItemEntity())))
        val testObserver = store.searchItems(DataFactory.randomString()).test()
        testObserver.assertComplete()
    }

    @Test
    fun searchItemsReturnsData(){
        val response = listOf(ItemFactory.makeItemEntity())
        stubRemoteSearchProjects(Observable.just(response))
        val testObserver = store.searchItems(DataFactory.randomString()).test()
        testObserver.assertValue(response)
    }


    private fun stubRemoteSearchProjects(observable: Observable<List<ItemEntity>>){
        whenever(remote.searchItems(any())).thenReturn(observable)
    }

}