package com.gabrielkou.remote.model.details

data class SellerAddress(val country: Country,
                         val addressLine: String = "",
                         val searchLocation: SearchLocation,
                         val city: City,
                         val latitude: Double = 0.0,
                         val comment: String = "",
                         val state: State,
                         val id: Int = 0,
                         val zipCode: String = "",
                         val longitude: Double = 0.0)