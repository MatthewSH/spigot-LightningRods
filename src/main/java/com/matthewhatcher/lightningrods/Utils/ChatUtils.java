package com.matthewhatcher.lightningrods.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils 
{
	public static String PREFIX = ChatColor.LIGHT_PURPLE + "[" + ChatColor.GREEN + "Lightning Rods" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.YELLOW;
	public static String PREFIX_NOCOLOR = "[Lightning Rods] ";
	
	/**
	 * Send a player a message with the Lightning Rods prefix.
	 * @param player
	 * @param message
	 */
	public static void send(Player player, String message) {
		player.sendMessage(PREFIX + message);
	}
}
