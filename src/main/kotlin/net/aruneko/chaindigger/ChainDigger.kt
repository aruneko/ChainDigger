package net.aruneko.chaindigger

import net.aruneko.chaindigger.listeners.ChainDiggerListener
import org.bukkit.plugin.java.JavaPlugin

class ChainDigger : JavaPlugin() {
    override fun onEnable() {
        val config = this.config
        val defaultRange = 5

        config.addDefault("range", defaultRange)
        config.options().copyDefaults(true)
        saveConfig()

        val range = config.getInt("range", defaultRange)

        server.pluginManager.registerEvents(ChainDiggerListener(this, server, range), this)
    }

    override fun onDisable() {}
}
