package com.b5team.statsex;

import org.bukkit.OfflinePlayer;

public class StatsExAPI {
	
	public static String getStatistic(String player, String st) {
		
		OfflinePlayer p = StatsExUtils.getOfflinePlayer(player);
		String response = Integer.toString(DefineStatistics.getStatistic(p, st));
		return response;
	}
}
