package net.aruneko.chaindigger

import net.aruneko.chaindigger.listeners.ChainDiggerListener
import org.bukkit.plugin.java.JavaPlugin

class ChainDigger : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(ChainDiggerListener(this, server), this)
    }

    override fun onDisable() {}
}