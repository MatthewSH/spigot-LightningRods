package com.matthewhatcher.lightningrods.API;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.matthewhatcher.lightningrods.LightningRods;
import com.matthewhatcher.lightningrods.Rod.LightningRod;
import com.matthewhatcher.lightningrods.Utils.ChatUtils;

public class LightningAPI 
{
	/**
	 * Give a player a lightning rod.
	 * @param player The player to give the rod.
	 * @param rod The rod to give, must extend LightningRod.
	 * @param amount The amount of lightning rods to give.
	 */
	public void giveRod(Player player, LightningRod rod, int amount) {
		if(amount <= 0 || amount > 64)
			return;
		
		LightningRod lr = LightningRods.getInstance().getRodManager().getByLocalName(rod.getLocalName());
		
		if(lr != null) {
			ItemStack button = new ItemStack(Material.STONE_BUTTON, 1);
			ItemStack rods = new ItemStack(rod.getConductor(), amount);
			ItemMeta buttonMeta = button.getItemMeta();
			ItemMeta rodMeta = rods.getItemMeta();
			
			buttonMeta.setDisplayName(ChatColor.YELLOW + rod.getName());
			rodMeta.setDisplayName(ChatColor.RED + rod.getName());
			
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GREEN + rod.getName());
			
			if(rod.getRodCooler() != null) {
				lore.add(ChatColor.DARK_GREEN + "" + rod.getRodCooler().getCooldownTime() + " second cooldown");
			}
			
			buttonMeta.setLore(lore);
			rodMeta.setLore(lore);
			
			button.setItemMeta(buttonMeta);
			rods.setItemMeta(rodMeta);
			
			if(player.getInventory().firstEmpty() >= 0) {
				player.getInventory().addItem(button);
				player.getInventory().addItem(rods);
			} else {
				ChatUtils.send(player, "The is no space in the inventory for the power of Zeus.");
			}
		}
	}
	
	/**
	 * Give a player a lightning rod.
	 * @param player The player to give the rod.
	 * @param rodName The local name of the rod to give.
	 * @param amount The amount of lightning rods to give.
	 */
	public void giveRod(Player player, String rodName, int amount) {
		if(amount <= 0 || amount > 64)
			return;
		
		LightningRod rod = LightningRods.getInstance().getRodManager().getByLocalName(rodName);
		
		if(rod != null) {
			ItemStack button = new ItemStack(Material.STONE_BUTTON, 1);
			ItemStack rods = new ItemStack(rod.getConductor(), amount);
			ItemMeta buttonMeta = button.getItemMeta();
			ItemMeta rodMeta = rods.getItemMeta();
			
			buttonMeta.setDisplayName(ChatColor.YELLOW + rod.getName());
			rodMeta.setDisplayName(ChatColor.RED + rod.getName());
			
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GREEN + rod.getName());
			
			if(rod.getRodCooler() != null) {
				lore.add(ChatColor.DARK_GREEN + "" + rod.getRodCooler().getCooldownTime() + " second cooldown");
			}
			
			buttonMeta.setLore(lore);
			rodMeta.setLore(lore);
			
			button.setItemMeta(buttonMeta);
			rods.setItemMeta(rodMeta);
			
			if(player.getInventory().firstEmpty() >= 0) {
				player.getInventory().addItem(button);
				player.getInventory().addItem(rods);
			} else {
				ChatUtils.send(player, "The is no space in the inventory for the power of Zeus.");
			}
		}
	}
	
	/**
	 * Register a lightning rod with the rod manager.
	 * @param rod
	 */
	public void registerRod(LightningRod rod) {
		LightningRods.getInstance().getRodManager().register(rod);
	}
	
	/**
	 * Remove a lightning rod from a rod manager.
	 * @param rod
	 */
	public void unregisterRod(LightningRod rod) {
		LightningRods.getInstance().getRodManager().unregister(rod);
	}
}
