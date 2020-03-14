package me.seaeclipse.premiumlockrc;

import me.seaeclipse.premiumlockrc.commands.LockCommand;
import me.seaeclipse.premiumlockrc.commands.PremiumCommand;
import me.seaeclipse.premiumlockrc.files.Config;
import me.seaeclipse.premiumlockrc.listeners.ConnectionListener;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * PremiumLock is a bungeecord plugin that
 * deals with "protecting" accounts chosen
 * by a admin, for set the connection to online mode.
 * This plugin was designed by various Italian servers
 *
 * @author Niketion
 */
public class PremiumLock extends Plugin {

    private static PremiumLock instance;
    public static PremiumLock getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        new LockCommand();
        new PremiumCommand();

        new ConnectionListener();

        Config.MAIN.getFileManager();
        Config.PREMIUM.getFileManager();
    }

    @Override
    public void onLoad() {
        for (String message : (":" + ChatColor.GREEN + "PremiumLock abilitato," +
                " made by " + getDescription().getAuthor() + " with love.:" + ChatColor.RESET).split(":")) {
            getProxy().getConsole().sendMessage(new TextComponent(message));
        }
    }
}
