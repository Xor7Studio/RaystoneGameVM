package cn.xor7.raystone

import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.util.jar.JarFile


object GameLoader {
    private const val GAME_CONFIG_FILE_NAME = "raystone-game.toml"

    fun loadGameJar(jar: File) {
        try {
            val jarFile = JarFile(jar)
            val entry = jarFile.getJarEntry(GAME_CONFIG_FILE_NAME)
                ?: throw FileNotFoundException("$GAME_CONFIG_FILE_NAME not found in jar ${jar.absolutePath}")
            val inputStream: InputStream = jarFile.getInputStream(entry)
            var data: Int
            while (inputStream.read().also { data = it } != -1) {
                print(data.toChar())
            }
            inputStream.close()
            jarFile.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}