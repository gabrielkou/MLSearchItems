package com.gabrielkou.ml.data.model

data class ResultsItem(val seller: Seller,
                       val originalPrice: Any? = null,
                       val stopTime: String = "",
                       val buyingMode: String = "",
                       val title: String = "",
                       val soldQuantity: Int = 0,
                       val availableQuantity: Int = 0,
                       val shipping: Shipping,
                       val categoryId: String = "",
                       val reviews: Reviews,
                       val installments: Installments,
                       val price: Int = 0,
                       val officialStoreId: Any? = null,
                       val id: String = "",
                       val acceptsMercadopago: Boolean = false,
                       val thumbnail: String = "",
                       val address: Address,
                       val catalogProductId: Any? = null,
                       val sellerAddress: SellerAddress,
                       val tags: List<String>?,
                       val condition: String = "",
                       val siteId: String = "",
                       val attributes: List<AttributesItem>?,
                       val listingTypeId: String = "",
                       val permalink: String = "",
                       val currencyId: String = "")