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
	
	public void startCooling(Player p) {
		this.players.put(p.getName(), System.currentTimeMillis());
	}
	
	public long getRemainingTime(Player p) {
		return ((this.players.get(p.getName()) / 1000) + this.cooldownTime) - (System.currentTimeMillis() / 1000);
	}
	
	public void removePlayer(Player p) {
		if(this.players.containsKey(p.getName()))
			this.players.remove(p.getName());
	}
	
	public boolean isCooling(Player p) {
		if(!this.players.containsKey(p.getName()))
			return false;
		
		return this.getRemainingTime(p) > 0;
	}
	
	public int getCooldownTime() {
		return this.cooldownTime;
	}
}
