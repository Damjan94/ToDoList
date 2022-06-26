package StorageI2P

import net.i2p.client.streaming.I2PSocketManagerFactory
import net.i2p.data.PrivateKeyFile
import java.io.File


class StorageHandler {

    private val privateKeyFileName = "private_key_file.dat"

    fun getStorage(keyFileDirectory: File) {
        val keyFile = File(keyFileDirectory.path + File.pathSeparator + privateKeyFileName)
        val privateKeyFile = PrivateKeyFile(keyFile)
        privateKeyFile.createIfAbsent()
        val session = I2PSocketManagerFactory.createDisconnectedManager(keyFile.inputStream(), null, 0, null)

    }
}