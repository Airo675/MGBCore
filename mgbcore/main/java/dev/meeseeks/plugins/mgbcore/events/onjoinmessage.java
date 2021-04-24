package dev.meeseeks.plugins.mgbcore.events;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import static dev.meeseeks.plugins.mgbcore.Mgbcore.*;

public class onjoinmessage implements Listener {

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();
        e.setJoinMessage(Color(joinmessage) + player.getDisplayName());

    }

    private String Color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
