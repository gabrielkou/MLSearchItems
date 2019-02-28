package com.gabrielkou.ml.data.model

data class Paging(val total: Int = 0,
                  val offset: Int = 0,
                  val limit: Int = 0,
                  val primaryResults: Int = 0)