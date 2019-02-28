package com.gabrielkou.domain.repository

import com.gabrielkou.domain.model.Item
import io.reactivex.Observable

interface ItemsRepository {
    fun searchItems(query:String?): Observable<List<Item>>
}