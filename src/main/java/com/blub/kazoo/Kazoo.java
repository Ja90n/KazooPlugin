package com.blub.kazoo;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kazoo extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            Player p = event.getPlayer();
            try {
                if (p.getPlayer().getInventory().getItemInMainHand().getType() == Material.GOLDEN_HOE) {
                    if (p.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Kazoo")){
                        for (Player player : Bukkit.getOnlinePlayers())
                        {
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_COW_BELL, 1 ,1);
                        }
                    } else if (p.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Cod")){
                        for (Player player : Bukkit.getOnlinePlayers())
                        {
                            player.playSound(player.getLocation(), Sound.ENTITY_COD_DEATH, 1 ,1);
                        }
                    } else if (p.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Creeper")) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.playSound(player.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1, 0);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
