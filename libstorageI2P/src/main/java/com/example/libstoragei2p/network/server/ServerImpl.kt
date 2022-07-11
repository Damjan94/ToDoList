package com.example.libstoragei2p.network.server

import net.i2p.client.streaming.I2PSocket
import net.i2p.client.streaming.I2PSocketManager

class ServerImpl(private val socketManager: I2PSocketManager): Server {

    @Volatile
    var isListening = true

    suspend fun listenToConnections() {
        socketManager.session.connect()
        while (isListening) {
            handleClient(socketManager.serverSocket.accept())
        }

    }

    suspend fun handleClient(client: I2PSocket) {

    }

    override fun listenForClients() {
        TODO("Not yet implemented")
    }

}