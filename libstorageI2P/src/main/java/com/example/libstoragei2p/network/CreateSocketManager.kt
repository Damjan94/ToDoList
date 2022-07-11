package StorageI2P

import net.i2p.client.streaming.I2PSocketManager
import net.i2p.client.streaming.I2PSocketManagerFactory
import net.i2p.data.PrivateKeyFile
import java.io.File


private const val privateKeyFileName = "private_key_file.dat"

fun createSocketManager(keyFileDirectory: File): I2PSocketManager {
    val keyFile = File(keyFileDirectory.path + File.pathSeparator + privateKeyFileName)
    val privateKeyFile = PrivateKeyFile(keyFile)
    privateKeyFile.createIfAbsent()
    return I2PSocketManagerFactory.createDisconnectedManager(keyFile.inputStream(), null, 0, null)

}