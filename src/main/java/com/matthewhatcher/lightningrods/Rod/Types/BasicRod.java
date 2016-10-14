package com.matthewhatcher.lightningrods.Rod.Types;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.matthewhatcher.lightningrods.LightningRods;
import com.matthewhatcher.lightningrods.Rod.LightningRod;
import com.matthewhatcher.lightningrods.Rod.RodCooler;

public class BasicRod extends LightningRod
{	
	public BasicRod(LightningRods plugin, Material conductor) {
		super(plugin, "Generic Lightning Rod", "generic", new RodCooler(5), conductor);
	}
	
	@Override
	public void onStrike(Player p) {
		World w = p.getWorld();
		List<Location> locations = LightningRods.getInstance().getRodManager().getLocations(p);
		
		for(Location location : locations) {
			w.strikeLightning(location);
			
			for(Entity entity : location.getWorld().getNearbyEntities(location, 2, 2, 2)) {
				if(entity instanceof Player) {
					Player player = (Player) entity;
					player.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 1));
				}
			}
		}
			
		super.onStrike(p);
	}
}
