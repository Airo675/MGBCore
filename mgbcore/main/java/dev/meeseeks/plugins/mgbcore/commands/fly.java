package dev.meeseeks.plugins.mgbcore.commands;

import dev.meeseeks.plugins.mgbcore.Mgbcore;
import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static dev.meeseeks.plugins.mgbcore.Mgbcore.*;

public class fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
       if (args.length == 0){
           if (!(sender instanceof Player)){
               System.out.println(prefix + onlyplayercommand);
           } else {
               Player player = (Player) sender;
               if (!(player.hasPermission(flyselfperm))){
                   player.sendMessage(Color(noperms));
               } else {
                   if (player.getAllowFlight()){
                       player.setAllowFlight(false);
                       player.setFlying(false);
                       player.sendMessage(Color(flydisabled));
                   } else {
                       player.setAllowFlight(true);
                       player.setFlying(true);
                       player.sendMessage(Color(flyenabled));
                   }
               }
           }
       } else if (args.length == 1){
           if (!(sender instanceof Player)){
               Player target = Bukkit.getPlayer(args[0]);
               if (!(target.isOnline())){
                   sender.sendMessage(Color(prefix + playernotfound + target.getDisplayName()));
               } else {
                   if (target.getAllowFlight()){
                       target.setAllowFlight(false);
                       target.setFlying(false);
                       target.sendMessage(Color(flydisabled));
                       System.out.println(Color(prefix + flydisabledothers + target.getDisplayName()));
                   } else {
                       target.setAllowFlight(true);
                       target.setFlying(true);
                       target.sendMessage(Color(flyenabled));
                       System.out.println(prefix + flyenabledothers + target.getDisplayName());
                   }
               }
           } else {
               Player player = (Player) sender;
               Player target = Bukkit.getPlayer(args[0]);
               if (!(player.hasPermission(flyothersperm))){
                   player.sendMessage(Color(noperms));
               } else {
                   if (!(target.isOnline())){
                       player.sendMessage(Color(playernotfound + target.getDisplayName()));
                   } else {
                       if (target.getAllowFlight()){
                           target.setAllowFlight(false);
                           target.setFlying(false);
                           target.sendMessage(Color(flydisabled));
                           player.sendMessage(Color(flydisabledothers + target.getDisplayName()));
                       } else {
                           target.setAllowFlight(true);
                           target.setFlying(true);
                           target.sendMessage(Color(flyenabled));
                           player.sendMessage(Color(flyenabledothers + target.getDisplayName()));
                       }
                   }
               }
           }
       } else if (args.length >= 2){
           if (!(sender instanceof Player)){
               System.out.println(prefix + invalidsyntax);
           } else {
               Player player = (Player) sender;
               if (!(player.hasPermission(flyselfperm))){
                   player.sendMessage(Color(noperms));
               } else {
                    player.sendMessage(Color(invalidsyntax));
               }
           }
       }

        return false;
    }

    private String Color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
