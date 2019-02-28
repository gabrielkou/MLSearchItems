package com.gabrielkou.ml.data.model

data class SellerAddress(val country: Country,
                         val addressLine: String = "",
                         val city: City,
                         val latitude: String = "",
                         val comment: String = "",
                         val id: String = "",
                         val state: State,
                         val zipCode: String = "",
                         val longitude: String = "")