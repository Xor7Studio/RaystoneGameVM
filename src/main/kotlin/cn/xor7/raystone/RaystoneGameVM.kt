package cn.xor7.raystone

import cn.xor7.raystone.event.Subscribe
import cn.xor7.raystone.event.lifecycle.ChannelInitializeEvent
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class RaystoneGameVM : JavaPlugin(), cn.xor7.raystone.event.Listener {
    override fun onEnable() {
        Raystone.init()
        Raystone.registerListener(this)
        Bukkit.getPluginManager().registerEvents(BukkitEventListener, this)
        logger.info("Raystone Game VM Enabled.")
    }

    @Subscribe
    fun onChannelInitialize(event: ChannelInitializeEvent) {
        logger.info("Connect with client uuid: ${event.clientUuid} .")
    }
}