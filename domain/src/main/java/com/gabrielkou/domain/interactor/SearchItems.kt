package com.gabrielkou.domain.interactor

import com.gabrielkou.domain.executor.PostExecutionThread
import com.gabrielkou.domain.model.Item
import com.gabrielkou.domain.repository.ItemsRepository
import io.reactivex.Observable
import javax.inject.Inject

open class SearchItems @Inject constructor(
    private val itemsRepository: ItemsRepository,
    postExecutionThread: PostExecutionThread)
    :ObservableUseCase<List<Item>, String?>(postExecutionThread){

    public override fun buildUseCaseObservable(params: String?): Observable<List<Item>> {
        return itemsRepository.searchItems(params)
    }

}

