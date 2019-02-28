package com.gabrielkou.ml.data.model

data class SearchResponse(val availableSorts: List<AvailableSortsItem>?,
                          val query: String = "",
                          val availableFilters: List<AvailableFiltersItem>?,
                          val siteId: String = "",
                          val paging: Paging,
                          val sort: Sort,
                          val filters: List<FiltersItem>?,
                          val results: List<ResultsItem>?)