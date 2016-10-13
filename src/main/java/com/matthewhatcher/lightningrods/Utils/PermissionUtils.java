package com.matthewhatcher.lightningrods.Utils;

import org.bukkit.entity.Player;

import com.matthewhatcher.lightningrods.Permissions.RodPermissions;

public class PermissionUtils 
{
	public static boolean canStrike(Player p) {
		return p.hasPermission(RodPermissions.LIGHTNING_USE);
	}
	
	public static boolean canBypassCooldown(Player p) {
		return p.hasPermission(RodPermissions.BYPASS_COOLDOWN);
	}
}
