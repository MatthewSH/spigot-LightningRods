package com.matthewhatcher.lightningrods.Rod;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class RodCooler 
{
	private HashMap<String, Long> players;
	private int cooldownTime;
	
	public RodCooler(int time) {
		this.players = new HashMap<String, Long>();
		this.cooldownTime = time;
	}
	
	/**
	 * Start cooling a player.
	 * @param p
	 */
	public void startCooling(Player p) {
		this.players.put(p.getName(), System.currentTimeMillis());
	}
	
	/**
	 * Get the remaining cooldown time for a player.
	 * @param p
	 * @return
	 */
	public long getRemainingTime(Player p) {
		return ((this.players.get(p.getName()) / 1000) + this.cooldownTime) - (System.currentTimeMillis() / 1000);
	}
	
	/**
	 * Remove a player from cooldown.
	 * @param p
	 */
	public void removePlayer(Player p) {
		if(this.players.containsKey(p.getName()))
			this.players.remove(p.getName());
	}
	
	/**
	 * Check if a player is cooling or not.
	 * @param p
	 * @return
	 */
	public boolean isCooling(Player p) {
		if(!this.players.containsKey(p.getName()))
			return false;
		
		return this.getRemainingTime(p) > 0;
	}
	
	public int getCooldownTime() {
		return this.cooldownTime;
	}
}
