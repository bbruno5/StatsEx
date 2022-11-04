package com.b5team.statsex;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.OfflinePlayer;

class StatsExUtils {
	
	static OfflinePlayer getOfflinePlayer(String player) {
		
		List<OfflinePlayer> oplayers = Arrays.asList(Main.getInstance().getServer().getOfflinePlayers());
		
		for (int i = 0; i < oplayers.size(); i++) {
			
			if (player.equals(oplayers.get(i).getName())) {
				
				return oplayers.get(i);
			}
			
			if (i == oplayers.size() && !player.equals(oplayers.get(i).getName())) {
				
				Main.getMainLogger().log(Level.WARNING, "[StatsEx] Parsed player doesn't exists.");
			}
		}
		return null;
	}
}
