package dev.meeseeks.plugins.mgbcore;

import dev.meeseeks.plugins.mgbcore.commands.fly;
import dev.meeseeks.plugins.mgbcore.commands.god;
import dev.meeseeks.plugins.mgbcore.commands.vanish;
import dev.meeseeks.plugins.mgbcore.events.onjoinmessage;
import dev.meeseeks.plugins.mgbcore.events.onleavemessage;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mgbcore extends JavaPlugin {

    public static Mgbcore plugin;
    public static String noperms,flyenabled,flydisabled,playernotfound,flyenabledothers,flydisabledothers,joinmessage,leavemessage,invalidsyntax,onlyplayercommand,prefix,flyselfperm,flyothersperm,godselfperm,godothersperm,godenabled,goddisabled,godenabledothers,goddisabledothers,vanishenabled,vanishdisabled,vanishenabledothers,vanishdisabledothers,vanishselfperm,vanishothersperm,speedselfperm,speedothersperm;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new onjoinmessage(), this);
        getServer().getPluginManager().registerEvents(new onleavemessage(), this);
        getCommand("fly").setExecutor(new fly());
        getCommand("god").setExecutor(new god());
        getCommand("vanish").setExecutor(new vanish());
        getLogger().info("MGBCore has been enabled");













        //Public strings
        speedselfperm = getConfig().getString("Permissions.speed-self-perm");
        speedothersperm = getConfig().getString("Permissions.speed-others-perm");
        vanishothersperm = getConfig().getString("Permissions.vanish-others-perm");
        vanishselfperm = getConfig().getString("Permissions.vanish-self-perm");
        vanishdisabledothers = getConfig().getString("Messages.vanish-disabled-others");
        vanishenabledothers = getConfig().getString("Messages.vanish-enabled-others");
        vanishdisabled = getConfig().getString("Messages.vanish-disabled-self");
        vanishenabled = getConfig().getString("Messages.vanish-enabled-self");
        godenabled = getConfig().getString("Messages.god-enabled-self");
        goddisabled = getConfig().getString("Messages.god-disabled-self");
        godenabledothers = getConfig().getString("Messages.god-enabled-others");
        goddisabledothers = getConfig().getString("Messages.god-disabled-others");
        godselfperm = getConfig().getString("Permissions.god-self");
        godothersperm = getConfig().getString("Permissions.god-others");
        flyselfperm = getConfig().getString("Permissions.fly-self");
        flyothersperm = getConfig().getString("Permissions.fly-others");
        prefix = getConfig().getString("Messages.prefix");
        onlyplayercommand = getConfig().getString("Messages.only-player-command-message");
        invalidsyntax = getConfig().getString("Messages.invalid-syntax");
        leavemessage = getConfig().getString("Messages.on-leave-message");
        joinmessage = getConfig().getString("Messages.on-join-message");
        noperms = getConfig().getString("Messages.no-perms-message");
        playernotfound = getConfig().getString("Messages.no-perms-message");
        flyenabled = getConfig().getString("Messages.fly-enabled-message");
        flydisabled = getConfig().getString("Messages.fly-disabled-message");
        flyenabledothers = getConfig().getString("Messages.flight-enabled-for-others-message");
        flydisabledothers = getConfig().getString("Messages.flight-disabled-for-others-message");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("MGBCore has been disabled");
    }
}
