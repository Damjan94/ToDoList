package com.example.libstoragei2p.network.connection_manager

interface ConnectionManager<T> {

    fun put(value: T)

    fun putAll(values: List<T>)


}