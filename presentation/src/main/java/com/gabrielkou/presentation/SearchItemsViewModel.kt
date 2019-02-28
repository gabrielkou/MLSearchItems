package com.gabrielkou.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.gabrielkou.domain.interactor.SearchItems
import com.gabrielkou.domain.model.Item
import com.gabrielkou.ml.presentation.data.Resource
import com.gabrielkou.ml.presentation.data.ResourceState
import com.gabrielkou.presentation.mapper.ItemViewMapper
import com.gabrielkou.presentation.model.ItemView
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

open class SearchItemsViewModel @Inject constructor(
    private val searchItems: SearchItems,
    private val mapper:ItemViewMapper) : ViewModel(){

    private val liveData: MutableLiveData<Resource<List<ItemView>>> = MutableLiveData()

    override fun onCleared() {
        searchItems.dispose()
        super.onCleared()
    }

    fun getItems() : LiveData<Resource<List<ItemView>>> {
        return liveData
    }

    fun searchItems(query:String){
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        searchItems.execute(SearchSubscriber(), query)
    }

    inner class SearchSubscriber: DisposableObserver<List<Item>>(){
        override fun onComplete() {
        }

        override fun onNext(t: List<Item>) {
            liveData.postValue(Resource(ResourceState.SUCCESS, t.map { mapper.mapToView(it)}, null))
        }

        override fun onError(t: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, t.message))
        }


    }
}