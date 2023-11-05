package cn.xor7.raystone

import cn.xor7.raystone.event.Listener
import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.plugin.java.JavaPlugin
import org.reflections.Reflections
import java.io.File
import java.io.FileNotFoundException
import java.lang.reflect.Method

class RaystoneGameVM : JavaPlugin(), Listener {
    private val bukkitEventListener = object : org.bukkit.event.Listener {}

    override fun onEnable() {
        Raystone.init()

        val eventClasses = Reflections("org.bukkit.event").getSubTypesOf(Event::class.java)
        for (eventClass in eventClasses) {
            val methods: Array<Method> = eventClass.methods
            for (method in methods) {
                if (method.name == "getHandlerList") {
                    Bukkit.getPluginManager()
                        .registerEvent(eventClass, bukkitEventListener, EventPriority.NORMAL, { _, event: Event ->
                            Raystone.emitEvent(event, Raystone.Channel.LOCAL)
                        }, this)
                }
            }
        }

        Raystone.registerListener(this, this)
        logger.info("Raystone Game VM Enabled.")
        scanGames()
    }

    private fun scanGames() {
        logger.info("scanning games")
        val directory = File("games")

        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                println("Failed to create games directory")
                return
            }
        }

        if (directory.isDirectory) {
            val jarFiles = directory.listFiles { _, name -> name.endsWith(".jar") }

            if (jarFiles != null) {
                for (jarFile in jarFiles) {
                    try {
                        GameLoader.loadGameJar(jarFile)
                    } catch (ignored: FileNotFoundException) {
                        logger.warning("jar file: ${jarFile.name} is not a Raystone Game! ignored!")
                    }
                }
            }
        }
    }
}