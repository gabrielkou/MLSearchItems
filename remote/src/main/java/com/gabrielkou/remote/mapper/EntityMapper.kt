package com.gabrielkou.remote.mapper

interface EntityMapper<in M, out E> {

    fun mapFromRemote(model: M): E

}