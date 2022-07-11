package com.example.libstoragei2p.storage_i2p

import com.example.libstoragei2p.network.connection_manager.ConnectionManager

class StorageImpl<T>(
    private val connectionManager: ConnectionManager<T>
    ): Storage<T>{
    override suspend fun put(value: T) {
        connectionManager.put(value)
    }

    override suspend fun putAll(values: List<T>) {
        connectionManager.putAll(values)
    }

    override suspend fun getAll(): List<T> {
        TODO("Not yet implemented")
    }
}