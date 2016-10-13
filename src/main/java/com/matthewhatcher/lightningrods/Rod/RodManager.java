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
	
	public boolean register(LightningRod rod) {
		return this.rods.add(rod);
	}
	
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
	
	public ArrayList<Location> getLocations(Player p) {
		/*ArrayList<Location> locations = new ArrayList<Location>();
		
		for(String key : this.rodLocations.keySet()) {
			if(key == p.getName()) {
				locations.add(this.rodLocations.get(key));
			}
		}
		
		return locations;*/
		
		if(this.rodLocations.containsKey(p.getName()))
			return this.rodLocations.get(p.getName());
		else 
			return null;
	}
	
	public LightningRod getByLocalName(String localName) {
		for(LightningRod rod : this.rods) {
			if(rod.getLocalName().equals(localName)) 
				return rod;
		}
		
		return null;
	}
	
	public LightningRod getByName(String name) {
		for(LightningRod rod : this.rods) {
			if(rod.getName().equals(name))
				return rod;
		}
		
		return null;
	}
	
	public ArrayList<LightningRod> getRods() {
		return this.rods;
	}
}
