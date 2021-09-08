package net.aruneko.chaindigger.listeners

import net.aruneko.chaindigger.extensions.findChunk
import net.aruneko.chaindigger.extensions.isDiggable
import org.bukkit.Server
import org.bukkit.Tag.MINEABLE_SHOVEL
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.plugin.Plugin

class ChainDiggerListener(private val plugin: Plugin, private val server: Server, private val range: Int) : Listener {
    @EventHandler
    fun onBreakBlock(event: BlockBreakEvent) {
        val player = event.player
        val mainHandItem = player.inventory.itemInMainHand

        if (!player.isSneaking) {
            // スニークしてなかったらやめる
            return
        }

        val block = event.block

        if (!block.isPreferredTool(mainHandItem) || !MINEABLE_SHOVEL.isTagged(block.type)) {
            // 適正ツールじゃなかったらやめる
            return
        }

        if (!block.isDiggable()) {
            return
        }

        val chunk = block.findChunk(range)
        chunk.forEach { it.breakNaturally(mainHandItem) }
    }
}
