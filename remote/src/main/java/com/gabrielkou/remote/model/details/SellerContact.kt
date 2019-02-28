package com.gabrielkou.remote.model.details

data class SellerContact(val areaCode: String = "",
                         val countryCode: String = "",
                         val otherInfo: String = "",
                         val phone: String? = "",
                         val contact: String? = "",
                         val webpage: String = "",
                         val email: String = "")