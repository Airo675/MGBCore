package dev.meeseeks.plugins.mgbcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static dev.meeseeks.plugins.mgbcore.Mgbcore.*;

public class god implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((args.length == 0)){
            if (!(sender instanceof Player)){
                System.out.println(Color(prefix + onlyplayercommand));
            } else {
                Player player = (Player) sender;
                if (!(player.hasPermission(godselfperm))){
                    player.sendMessage(Color(noperms));
                } else {
                    if (!(player.isInvulnerable())){
                        player.setInvulnerable(true);
                        player.sendMessage(Color(godenabled));
                    } else {
                        player.setInvulnerable(false);
                        player.sendMessage(Color(goddisabled));
                    }
                }
            }
        } else if (args.length == 1){
            Player target = Bukkit.getPlayer(args[0]);
            if (!(sender instanceof Player)){
                if (!(target.isOnline())){
                    System.out.println(Color(prefix + playernotfound));
                } else {
                    if (!(target.isInvulnerable())){
                        target.setInvulnerable(true);
                        target.sendMessage(Color(godenabled));
                        System.out.println(Color(prefix + godenabledothers + target.getDisplayName()));
                    } else {
                        target.setInvulnerable(false);
                        target.sendMessage(Color(goddisabled));
                        System.out.println(Color(prefix + goddisabledothers + target.getDisplayName()));
                    }
                }
            } else {
                Player player = (Player) sender;
                if (!(player.hasPermission(godothersperm))){
                    player.sendMessage(Color(noperms));
                } else {
                    if (!(target.isOnline())){
                        player.sendMessage(Color(playernotfound));
                    } else {
                        if (!(target.isInvulnerable())){
                            target.setInvulnerable(true);
                            target.sendMessage(Color(godenabled));
                            player.sendMessage(Color(godenabledothers + target.getDisplayName()));
                        } else {
                            target.setInvulnerable(false);
                            target.sendMessage(Color(goddisabled));
                            player.sendMessage(Color(goddisabledothers + target.getDisplayName()));
                        }
                    }
                }
            }
        } else if (args.length >= 2){
            if (!(sender instanceof Player)){
                System.out.println(Color(prefix + invalidsyntax));
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
