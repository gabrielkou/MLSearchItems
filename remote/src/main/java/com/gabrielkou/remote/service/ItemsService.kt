package com.gabrielkou.remote.service

import com.gabrielkou.ml.data.model.SearchResponse
import com.gabrielkou.remote.model.details.ItemsResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Defines the abstract methods used for interacting with the ML API
 */
interface ItemsService {

    @GET("/sites/MLU/search")
    fun searchProducts(@Query("q") query:String):Observable<SearchResponse>

    @GET("/items/{id}")
    fun getItemDetails(@Path("id") itemId:String):Observable<ItemsResponse>
}