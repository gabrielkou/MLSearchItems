package com.gabrielkou.remote.model.details

data class ItemsResponse(val originalPrice: Any? = null,
                         val secureThumbnail: String = "",
                         val buyingMode: String = "",
                         val descriptions: List<DescriptionsItem>?,
                         val availableQuantity: Int = 0,
                         val domainId: String = "",
                         val shipping: Shipping,
                         val price: Int = 0,
                         val officialStoreId: Any? = null,
                         val warranty: Any? = null,
                         val sellerContact: SellerContact,
                         val id: String = "",
                         val sellerId: Int = 0,
                         val acceptsMercadopago: Boolean = false,
                         val thumbnail: String = "",
                         val lastUpdated: String = "",
                         val automaticRelist: Boolean = false,
                         val startTime: String = "",
                         val condition: String = "",
                         val subtitle: Any? = null,
                         val siteId: String = "",
                         val permalink: String = "",
                         val differentialPricing: Any? = null,
                         val status: String = "",
                         val stopTime: String = "",
                         val title: String = "",
                         val soldQuantity: Int = 0,
                         val pictures: List<PicturesItem>?,
                         val categoryId: String = "",
                         val basePrice: Int = 0,
                         val initialQuantity: Int = 0,
                         val dateCreated: String = "",
                         val catalogProductId: Any? = null,
                         val health: Any? = null,
                         val listingSource: String = "",
                         val sellerAddress: SellerAddress,
                         val internationalDeliveryMode: String = "",
                         val parentItemId: Any? = null,
                         val location: Location,
                         val attributes: List<AttributesItem>?,
                         val listingTypeId: String = "",
                         val currencyId: String = "",
                         val videoId: Any? = null,
                         val geolocation: Geolocation)