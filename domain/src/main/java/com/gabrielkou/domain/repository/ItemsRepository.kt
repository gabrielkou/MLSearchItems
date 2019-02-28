package com.gabrielkou.domain.repository

import com.gabrielkou.domain.model.Item
import com.gabrielkou.domain.model.ItemDetail
import io.reactivex.Observable

interface ItemsRepository {
    fun searchItems(query:String?): Observable<List<Item>>

    fun getItemDetails(itemId:String): Observable<ItemDetail>
}