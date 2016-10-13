package com.matthewhatcher.lightningrods.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.matthewhatcher.lightningrods.LightningRods;
import com.matthewhatcher.lightningrods.Rod.LightningRod;

public class StrikeListener implements Listener
{
	public void register() {
		LightningRods.getInstance().getServer().getPluginManager().registerEvents(this, LightningRods.getInstance());
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if(e.getPlayer().getInventory().getItemInMainHand() != null)
				if(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.STONE_BUTTON)
					e.setCancelled(true);
		} else if(e.getAction() == Action.LEFT_CLICK_AIR) {
			if(e.getPlayer().getInventory().getItemInMainHand() != null) {
				if(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.STONE_BUTTON) {
					ItemStack button = e.getPlayer().getInventory().getItemInMainHand();
					
					if(button.getItemMeta().getLore().size() > 0) {
						String name = button.getItemMeta().getLore().get(0);
						if(name.length() > 0) {
							for(LightningRod rod : LightningRods.getInstance().getRodManager().getRods()) {
								if(name.contains(rod.getName())) {
									rod.strike(e.getPlayer());
									return;
								}
							}
						}
					}
					
					e.setCancelled(true);
				}
			}
		}
	}
}
