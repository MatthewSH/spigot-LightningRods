package com.matthewhatcher.lightningrods;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import com.matthewhatcher.lightningrods.API.LightningAPI;
import com.matthewhatcher.lightningrods.Commands.AdminCommands;
import com.matthewhatcher.lightningrods.Listeners.PlacementListener;
import com.matthewhatcher.lightningrods.Listeners.StrikeListener;
import com.matthewhatcher.lightningrods.Rod.RodManager;
import com.matthewhatcher.lightningrods.Rod.Types.BasicRod;

public class LightningRods extends JavaPlugin
{
	public RodManager rodManager;
	private StrikeListener strikeListener;
	private PlacementListener placementListener;
	private LightningAPI api;
	
	private static LightningRods instance;
	
	public static LightningRods getInstance() {
		return instance;
	}
	
	public RodManager getRodManager() {
		return rodManager;
	}
	
	public LightningAPI getAPI() {
		return this.api;
	}
	
	@Override
	public void onEnable() {
		LightningRods.instance = this;
		
		this.rodManager = new RodManager();
		this.rodManager.register(new BasicRod(getInstance(), Material.IRON_FENCE));
		
		this.strikeListener = new StrikeListener();
		this.strikeListener.register();
		
		this.placementListener = new PlacementListener();
		this.placementListener.register();
		
		this.api = new LightningAPI();
		
		this.getCommand("lrlist").setExecutor(new AdminCommands());
		this.getCommand("lradd").setExecutor(new AdminCommands());
		
		super.onEnable();
	}
}
