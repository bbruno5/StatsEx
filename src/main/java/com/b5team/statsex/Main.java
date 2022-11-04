package com.b5team.statsex;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bstats.bukkit.Metrics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	private static Logger logger;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		logger = this.getLogger();
		
		if (this.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
			
			new PlaceholdersParse(plugin).hook();
			logger.info("[StatsEx] PlaceholderAPI hook!");
		} else {
			
			logger.info("[StatsEx] PlaceholderAPI not found. You'll not be able to get placeholders.");
		}
		
		Metrics metrics = new Metrics(this);
		
		if (metrics.getPluginData() != null) {
			
			logger.info("[StatsEx] Metrics enabled!");
		}
	}
	
	@Override
	public void onDisable() {
		
		logger.info("StatsEx is now disabled.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender,
			Command cmd,
			String label,
			String[] args) {
		
		if (!this.isEnabled()) {
            logger.log(Level.SEVERE, "StatsEx is disabled. You'll no longer capable to get statistics.");
        } else if (cmd.getName().equalsIgnoreCase("statsex") || cmd.getName().equalsIgnoreCase("stats") || cmd.getName().equalsIgnoreCase("se")) {
        	
        	String arg[] = args;
        	if (arg.length > 0) {
        		
        		if (arg.length > 1) {
        			
        			String response = Integer.toString(DefineStatistics.getStatistic(StatsExUtils.getOfflinePlayer(arg[0]), arg[1]));
        			sender.sendMessage(response);
        		} else {
        			
        			sender.sendMessage("§3§l[StatsEx] §fYou must specify the desired statistic variable.");
        		}
        	} else {
        		
        		String[] message = new String[8];
        		message[0] = "§e§l---------- [StatsEx] Help Page ----------";
        		message[1] = " ";
        		message[2] = "§eAliases: se, stats";
        		message[3] = " ";
        		message[4] = "§e§l/statsex §7- Shows this help message";
        		message[5] = "§e§l/statsex <player> <statistic> §7- Returns the specified player's statistic";
        		message[6] = " ";
        		message[7] = "§e§l----------------------------------------";
        		sender.sendMessage(message);
        	}
        }
		return false;
	}
	
	protected static Main getInstance() {
		return plugin;
	}
	
	protected static Logger getMainLogger() {
		return logger;
	}
}
