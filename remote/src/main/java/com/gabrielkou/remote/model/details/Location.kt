package com.gabrielkou.remote.model.details

data class Location(val country: Country,
                    val addressLine: String = "",
                    val city: City,
                    val latitude: Double = 0.0,
                    val neighborhood: Neighborhood,
                    val state: State,
                    val openHours: String = "",
                    val zipCode: String = "",
                    val longitude: Double = 0.0)