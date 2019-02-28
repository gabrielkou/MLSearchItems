package com.gabrielkou.ml.mapper

interface ViewMapper<in P, out V> {

    fun mapToView(presentation: P): V

}