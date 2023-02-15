package com.bolt.onevone;

import org.bukkit.plugin.java.JavaPlugin

class OneVOne : JavaPlugin() {

    override fun onEnable() {
        logger.info("1v1 has been enabled!")
    }

    override fun onDisable() {
        logger.info("1v1 has been disabled!")
    }
}
