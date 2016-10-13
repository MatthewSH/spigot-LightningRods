package com.matthewhatcher.lightningrods.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.matthewhatcher.lightningrods.LightningRods;
import com.matthewhatcher.lightningrods.Permissions.RodAdminPermissions;
import com.matthewhatcher.lightningrods.Rod.LightningRod;
import com.matthewhatcher.lightningrods.Utils.ChatUtils;

public class AdminCommands implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("lrlist") && sender.hasPermission(RodAdminPermissions.COMMAND_LIST)) {
			ChatUtils.send((Player)sender, "Available lightning rods:");
			for(LightningRod rod : LightningRods.getInstance().getRodManager().getRods()) {
				sender.sendMessage(ChatColor.AQUA + "- " + ChatColor.YELLOW + rod.getLocalName());
			}
			
			return true;
		} else if(label.equalsIgnoreCase("lradd") && sender.hasPermission(RodAdminPermissions.COMMAND_GIVE)) {
			if(args.length < 1) {
				ChatUtils.send((Player)sender, "Please include a rod name when running the give command.");
				return true;
			}
			
			LightningRods.getInstance().getAPI().giveRod((Player)sender, args[0], 4);
			
			return true;
		}
		
		return false;
	}

}
