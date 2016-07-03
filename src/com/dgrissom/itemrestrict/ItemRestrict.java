package com.dgrissom.itemrestrict;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemRestrict extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public static boolean hasCraftPermission(Player player, ItemStack item) {
        return player.hasPermission("itemrestrict.craft.*") || player.hasPermission("itemrestrict.*")
                || player.hasPermission("itemrestrict.craft." + item.getType().name().toLowerCase());
    }

    @EventHandler
    public void onCraftPrepare(PrepareItemCraftEvent evt) {
        if (!getConfig().getBoolean("show-result")) {
            Player player = (Player) evt.getInventory().getHolder();

            if (!hasCraftPermission(player, evt.getRecipe().getResult())) {
                player.sendMessage(ChatColor.RED + "You are not allowed to craft that!");
                evt.getInventory().setResult(null);
            }
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent evt) {
        if (getConfig().getBoolean("show-result")) {
            Player player = (Player) evt.getWhoClicked();

            if (!hasCraftPermission(player, evt.getCurrentItem())) {
                player.sendMessage(ChatColor.RED + "You are not allowed to craft that!");
                evt.setCancelled(true);
            }
        }
    }
}
