package com.matthewhatcher.lightningrods.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class BlockUtils 
{
	/**
	 * Get the nearby players of a location.
	 * @param location
	 * @param distance
	 * @return
	 */
	public static List<Player> getNearbyPlayers(Location location, int distance) {
		int dSquared = distance*distance;
		List<Player> list = new ArrayList<Player>();
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(p.getLocation().distanceSquared(location) < dSquared) {
				list.add(p);
			}
		}
		
		return list;
	}
	
}
