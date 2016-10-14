package com.matthewhatcher.lightningrods.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import com.matthewhatcher.lightningrods.LightningRods;
import com.matthewhatcher.lightningrods.Rod.LightningRod;

public class PlacementListener implements Listener
{
	public void register() {
		LightningRods.getInstance().getServer().getPluginManager().registerEvents(this, LightningRods.getInstance());
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		for(LightningRod rod : LightningRods.getInstance().getRodManager().getRods()) {
			if(e.getBlock().getType() == rod.getConductor()) {
				ItemStack conductor = e.getItemInHand();
				
				if(conductor.getItemMeta().getLore().size() > 0) {
					String name = conductor.getItemMeta().getLore().get(0);
					if(name.length() > 0) {
						for(LightningRod lr : LightningRods.getInstance().getRodManager().getRods()) {
							if(name.contains(lr.getName())) {
								LightningRods.getInstance().getRodManager().addLocation(e.getPlayer(), e.getBlock().getLocation());
								break;
							}
						}
					}
				}
			}
		}
		
		if (e.getBlock().getType() == Material.STONE_BUTTON) {
			ItemStack button = e.getItemInHand();
			
			if(button.getItemMeta().getLore().size() > 0) {
				String name = button.getItemMeta().getLore().get(0);
				if(name.length() > 0) {
					for(LightningRod rod : LightningRods.getInstance().getRodManager().getRods()) {
						if(name.contains(rod.getName())) {
							e.setCancelled(true);
							break;
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		for(LightningRod rod : LightningRods.getInstance().getRodManager().getRods()) {
			if(e.getBlock().getType() == rod.getConductor()) {
				LightningRods.getInstance().getRodManager().removeLocation(e.getPlayer(), e.getBlock().getLocation());
			}
		}
	}
}
