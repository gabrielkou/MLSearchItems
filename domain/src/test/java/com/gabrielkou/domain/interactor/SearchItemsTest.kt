package com.gabrielkou.domain.interactor

import com.gabrielkou.domain.executor.PostExecutionThread
import com.gabrielkou.domain.model.Item
import com.gabrielkou.domain.repository.ItemsRepository
import com.gabrielkou.domain.test.factory.DataFactory
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchItemsTest {
    private lateinit var searchItems: SearchItems
    @Mock lateinit var mockItemsRepository: ItemsRepository
    @Mock lateinit var mockPostExecutionThread: PostExecutionThread

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        searchItems = SearchItems(mockItemsRepository, mockPostExecutionThread)
    }

    @Test
    fun searchItemsCompletes(){
        stubItemsRepositorySearchItems(Observable.just(ItemsFactory.makeItemsList(3)))
        val testObserver = searchItems.buildUseCaseObservable(DataFactory.randomUuid()).test()
        testObserver.assertComplete()
    }

    @Test
    fun buildUseCaseObservableCallsRepository(){
        searchItems.buildUseCaseObservable(null)
        verify(mockItemsRepository).searchItems(null)
    }

    @Test
    fun buildUseCaseObservableReturnsData(){
        val items = ItemsFactory.makeItemsList(5)
        stubItemsRepositorySearchItems(Observable.just(items))
        val testObserver = searchItems.buildUseCaseObservable(DataFactory.randomUuid()).test()
        testObserver.assertValue(items)
    }


    private fun stubItemsRepositorySearchItems(list : Observable<List<Item>>){
        whenever(mockItemsRepository.searchItems(any())).thenReturn(list)
    }


}