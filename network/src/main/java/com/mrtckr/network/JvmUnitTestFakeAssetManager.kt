package com.mrtckr.network

import androidx.annotation.VisibleForTesting
import com.mrtckr.network.fake.FakeAssetManager
import java.io.File
import java.io.InputStream

@VisibleForTesting
object JvmUnitTestFakeAssetManager : FakeAssetManager {
    private const val ASSETS_DIRECTORY = "src/main/assets"

    override fun open(fileName: String): InputStream {
        val file = File(ASSETS_DIRECTORY, fileName)
        require(file.exists()) { "Asset file not found: $fileName" }
        return file.inputStream()
    }
}
