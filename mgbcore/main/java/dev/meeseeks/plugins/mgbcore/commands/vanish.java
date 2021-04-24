package dev.meeseeks.plugins.mgbcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static dev.meeseeks.plugins.mgbcore.Mgbcore.*;

public class vanish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0){
            if (!(sender instanceof Player)){
                System.out.println(Color(prefix + onlyplayercommand));
            } else {
                Player player = (Player) sender;
                if (!(player.hasPermission(vanishselfperm))){
                    player.sendMessage(Color(noperms));
                } else {
                    if (!(player.isInvisible())){
                        player.setInvisible(true);
                        player.sendMessage(Color(vanishenabled));
                        if (!(player.isFlying())){
                            player.setAllowFlight(true);
                            player.setFlying(true);
                        } else {
                            return true;
                        }
                    } else {
                        player.setInvisible(false);
                        player.sendMessage(Color(vanishdisabled));
                        if (player.isFlying()){
                            player.setAllowFlight(false);
                            player.setFlying(false);
                        } else {
                            return true;
                        }
                    }
                }
            }
        } else if (args.length == 1){
            Player target = Bukkit.getPlayer(args[0]);
            if (!(sender instanceof Player)){
                if (!(target.isOnline())){
                    System.out.println(Color(prefix + playernotfound + target.getDisplayName()));
                } else {
                    if (!(target.isInvisible())){
                        target.setInvisible(true);
                        target.sendMessage(Color(vanishenabled));
                        System.out.println(Color(prefix + vanishenabledothers + target.getDisplayName()));
                        if (!(target.isFlying())){
                            target.setAllowFlight(true);
                            target.setFlying(true);
                        } else {
                            return true;
                        }
                    } else {
                        target.setInvisible(false);
                        target.sendMessage(Color(vanishdisabled));
                        System.out.println(Color(prefix + vanishdisabledothers + target.getDisplayName()));
                        if (target.isFlying()){
                            target.setAllowFlight(false);
                            target.setFlying(false);
                        } else {
                            return true;
                        }
                    }
                }
            } else {
                Player player = (Player) sender;
                if (!(player.hasPermission(vanishothersperm))){
                    player.sendMessage(Color(noperms));
                } else {
                    if (!(target.isOnline())){
                        player.sendMessage(Color(playernotfound + target.getDisplayName()));
                    } else {
                        if (!(target.isInvisible())){
                            target.setInvisible(true);
                            target.sendMessage(Color(vanishenabled));
                            player.sendMessage(Color(vanishenabledothers + target.getDisplayName()));
                            if (!(target.isFlying())){
                                target.setAllowFlight(true);
                                target.setFlying(true);
                            } else {
                                return true;
                            }
                        } else {
                            target.setInvisible(false);
                            target.sendMessage(Color(vanishdisabled));
                            player.sendMessage(Color(vanishdisabledothers + target.getDisplayName()));
                            if (target.isFlying()){
                                target.setAllowFlight(false);
                                target.setFlying(false);
                            } else {
                                return true;
                            }
                        }
                    }
                }
            }
        } else if (args.length >= 2){
            if (!(sender instanceof Player)){
                System.out.println(Color(prefix + invalidsyntax));
            } else {
                Player player = (Player) sender;
                if (!(player.hasPermission(vanishselfperm))){
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
