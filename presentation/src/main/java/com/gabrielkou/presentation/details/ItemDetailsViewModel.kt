package com.gabrielkou.presentation.details

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.gabrielkou.domain.interactor.GetItemDetails
import com.gabrielkou.domain.model.ItemDetail
import com.gabrielkou.ml.presentation.data.Resource
import com.gabrielkou.ml.presentation.data.ResourceState
import com.gabrielkou.presentation.mapper.ItemDetailsViewMapper
import com.gabrielkou.presentation.model.ItemDetailsView
import com.gabrielkou.presentation.model.ItemView
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

open class ItemDetailsViewModel @Inject constructor(
    private val getItemDetails: GetItemDetails,
    private val itemDetailsMapper: ItemDetailsViewMapper):ViewModel() {

    private val liveData: MutableLiveData<Resource<ItemDetailsView>> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
    }

    fun getItem(): LiveData<Resource<ItemDetailsView>>{
        return liveData
    }

    fun getItemDetails(itemId:String){
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        getItemDetails.execute(ItemDetailSubscriber(), itemId)
    }

    inner class ItemDetailSubscriber: DisposableObserver<ItemDetail>() {
        override fun onComplete() {
        }

        override fun onNext(t: ItemDetail) {
            liveData.postValue(Resource(ResourceState.SUCCESS, itemDetailsMapper.mapToView(t), null))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, null))
        }
    }

}