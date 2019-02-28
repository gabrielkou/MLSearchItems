package com.gabrielkou.remote.service

import com.gabrielkou.ml.data.model.SearchResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Defines the abstract methods used for interacting with the ML API
 */
interface SearchService {

    @GET("/sites/MLU/search")
    fun searchProducts(@Query("q") query:String):Observable<SearchResponse>
}