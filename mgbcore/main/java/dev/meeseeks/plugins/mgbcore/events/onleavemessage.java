package dev.meeseeks.plugins.mgbcore.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import static dev.meeseeks.plugins.mgbcore.Mgbcore.*;

public class onleavemessage implements Listener {

    @EventHandler
    void onPlayerQuit(PlayerQuitEvent e){

        Player player = e.getPlayer();
        e.setQuitMessage(Color(leavemessage) + player.getDisplayName());

    }

    private String Color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
