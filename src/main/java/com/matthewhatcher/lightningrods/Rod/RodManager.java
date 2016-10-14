package com.matthewhatcher.lightningrods.Rod;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RodManager 
{
	private HashMap<String, ArrayList<Location>> rodLocations;
	private ArrayList<LightningRod> rods;
	
	public RodManager() {
		this.rodLocations = new HashMap<String, ArrayList<Location>>();
		this.rods = new ArrayList<LightningRod>();
	}
	
	/**
	 * Register a rod.
	 * @param rod
	 * @return
	 */
	public boolean register(LightningRod rod) {
		return this.rods.add(rod);
	}
	
	/**
	 * Remove a rod from the registry.
	 * @param rod
	 * @return
	 */
	public boolean unregister(LightningRod rod) {
		return this.rods.remove(rod);
	}
	
	/**
	 * Add a rod location to the registry.
	 * @param p
	 * @param location
	 */
	public void addLocation(Player p, Location location) {
		if(this.rodLocations.containsKey(p.getName())) {
			ArrayList<Location> currentLocations = this.rodLocations.get(p.getName());
			currentLocations.add(location);
			
			this.rodLocations.replace(p.getName(), currentLocations);
		} else {
			ArrayList<Location> currentLocations = new ArrayList<Location>();
			currentLocations.add(location);
			
			this.rodLocations.put(p.getName(), currentLocations);
		}
	}
	
	/**
	 * Remove a rod location from the registry.
	 * @param p
	 * @param location
	 */
	public void removeLocation(Player p, Location location) {
		if(this.rodLocations.containsKey(p.getName())) {
			ArrayList<Location> currentLocations = this.rodLocations.get(p.getName());
			currentLocations.remove(location);
			
			this.rodLocations.replace(p.getName(), currentLocations);
		}
	}
	
	/**
	 * Get all locations of a rod belonging to a player.
	 * @param p
	 * @return
	 */
	public ArrayList<Location> getLocations(Player p) {
		if(this.rodLocations.containsKey(p.getName()))
			return this.rodLocations.get(p.getName());
		else 
			return null;
	}
	
	/**
	 * Get a rod by a local name.
	 * @param localName
	 * @return
	 */
	public LightningRod getByLocalName(String localName) {
		for(LightningRod rod : this.rods) {
			if(rod.getLocalName().equals(localName)) 
				return rod;
		}
		
		return null;
	}
	
	/**
	 * Get a rod by the rod name.
	 * @param name
	 * @return
	 */
	public LightningRod getByName(String name) {
		for(LightningRod rod : this.rods) {
			if(rod.getName().equals(name))
				return rod;
		}
		
		return null;
	}
	
	/**
	 * Get all rods in the registry.
	 * @return
	 */
	public ArrayList<LightningRod> getRods() {
		return this.rods;
	}
}
