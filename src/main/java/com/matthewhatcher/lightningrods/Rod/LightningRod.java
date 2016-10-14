package com.matthewhatcher.lightningrods.Rod;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.matthewhatcher.lightningrods.LightningRods;
import com.matthewhatcher.lightningrods.Utils.ChatUtils;
import com.matthewhatcher.lightningrods.Utils.PermissionUtils;

public class LightningRod 
{
	private LightningRods plugin;
	private String name, localName;
	private RodCooler cooler;
	private Material conductor;
	
	public LightningRod(LightningRods plugin, String name, String localName, RodCooler cooler, Material conductor) {
		this.cooler = cooler;
		this.conductor = conductor;
		this.name = name;
		this.localName = localName;
		this.plugin = plugin;
	}
	
	protected LightningRods getPlugin() {
		return this.plugin;
	}
	
	public void strike(Player p) {
		if(PermissionUtils.canStrike(p)) {
			if(this.getRodCooler() != null) {
				if(!PermissionUtils.canBypassCooldown(p)) {
					if(this.getRodCooler().isCooling(p)) {
						p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_BURP, 1F, 1);
						ChatUtils.send(p, "Please wait " + this.getRodCooler().getRemainingTime(p) + " seconds before using this again.");
						return;
					}
					
					this.getRodCooler().startCooling(p);
				}
			}
			
			onStrike(p);
		}
	}

	public String getName()
	{
		return this.name;
	}
	
	public String getLocalName()
	{
		return this.localName;
	}
	
	public RodCooler getRodCooler()
	{
		return this.cooler;
	}
	
	public Material getConductor() {
		return this.conductor;
	}
	
	public void onStrike(Player p) {}
}
