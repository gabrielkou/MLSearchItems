package com.gabrielkou.domain.interactor

import com.gabrielkou.domain.executor.PostExecutionThread
import com.gabrielkou.domain.model.ItemDetail
import com.gabrielkou.domain.repository.ItemsRepository
import io.reactivex.Observable
import javax.inject.Inject

open class GetItemDetails @Inject constructor(
    private val itemsRepository: ItemsRepository,
    postExecutionThread: PostExecutionThread): ObservableUseCase<ItemDetail, String>(postExecutionThread) {

    override fun buildUseCaseObservable(params: String?): Observable<ItemDetail> {
        return itemsRepository.getItemDetails(params!!)
    }

}