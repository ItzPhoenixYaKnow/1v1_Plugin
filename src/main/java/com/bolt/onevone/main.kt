package com.bolt.onevone

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerChatEvent

class oenvone : JavaPlugin(), CommandExecutor, Listener {

    override fun onEnable() {
        // Registers the event listener
        server.pluginManager.registerEvents(MyListener(), this)
        server.pluginManager.registerEvents(this, this)
        getCommand("1v1").executor = this
        }
    }

override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            val message = args.joinToString(separator = " ")
            val event = PlayerChatEvent(sender, message)
            server.pluginManager.callEvent(event)
        }
        return true
    }

    @EventHandler
    fun onPlayerChat(event: PlayerChatEvent) {
        event.player.sendMessage("&c[TEST] &eYou said: &c${event.message}")
    }

    private class MyListener : Listener {
        @EventHandler
        fun onPlayerJoin(event: PlayerJoinEvent) {
            val player = event.player
            player.sendMessage("&l&eWelcome to the server, &l&b${player.name}!")
        }
    }
}
