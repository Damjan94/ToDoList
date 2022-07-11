package com.example.libstoragei2p.storage_i2p

interface Storage<T> {

    suspend fun put(value: T)
    suspend fun putAll(values: List<T>)
    suspend fun getAll(): List<T>
}