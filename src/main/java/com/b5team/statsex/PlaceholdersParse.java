package com.b5team.statsex;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.clip.placeholderapi.external.EZPlaceholderHook;

class PlaceholdersParse extends EZPlaceholderHook {
	
	public PlaceholdersParse(Plugin plugin) {
		
		super(plugin, "statsex");
	}
	
	@Override
	public String onPlaceholderRequest(Player player, String st) {
		
		if (!st.equals("")) {
			
			String response = Integer.toString(DefineStatistics.getStatistic(StatsExUtils.getOfflinePlayer(player.getName()), st));
			return response;
		}
		return null;
	}
}
