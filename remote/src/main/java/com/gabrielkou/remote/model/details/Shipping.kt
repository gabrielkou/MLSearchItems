package com.gabrielkou.remote.model.details

data class Shipping(val mode: String = "",
                    val freeShipping: Boolean = false,
                    val localPickUp: Boolean = false,
                    val dimensions: Any? = null,
                    val logisticType: Any? = null,
                    val storePickUp: Boolean = false)