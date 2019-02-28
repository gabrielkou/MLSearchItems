package com.gabrielkou.ml.data.model

data class Shipping(val mode: String = "",
                    val freeShipping: Boolean = false,
                    val logisticType: String = "",
                    val storePickUp: Boolean = false)