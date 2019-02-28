package com.gabrielkou.data.repository

import com.gabrielkou.data.model.ItemEntity
import io.reactivex.Observable

interface ItemsRemote {

    fun searchItems(query:String): Observable<List<ItemEntity>>
}