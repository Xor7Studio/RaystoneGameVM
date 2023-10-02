package cn.xor7.raystone

import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.block.BlockEvent
import org.bukkit.event.entity.EntityEvent
import org.bukkit.event.hanging.HangingEvent
import org.bukkit.event.inventory.InventoryEvent
import org.bukkit.event.player.PlayerEvent

object BukkitEventListener : org.bukkit.event.Listener {
    @EventHandler
    fun onEvent(event: Event) {
        when(event) {
            is PlayerEvent -> {
                // TODO
            }
            is BlockEvent -> {
                // TODO
            }
            is InventoryEvent -> {
                // TODO
            }
            is HangingEvent -> {
                // TODO
            }
            is EntityEvent -> {
                // TODO
            }
        }
        Raystone.emitEvent(event, Raystone.Channel.LOCAL)
    }
}