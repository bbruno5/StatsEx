package com.b5team.statsex;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;

class DefineStatistics {
	
	public static int getStatistic(OfflinePlayer player, String st) {
		
		try {
			
			List<String> types = Arrays.asList("DAMAGE_DEALT", "DAMAGE_TAKEN", "DEATHS", "MOB_KILLS", "PLAYER_KILLS", "FISH_CAUGHT", "ANIMALS_BRED", "LEAVE_GAME", "JUMP", "DROP", "PICKUP", "PLAY_ONE_TICK", "WALK_ONE_CM", "SWIM_ONE_CM", "FALL_ONE_CM", "SNEAK_TIME", "CLIMB_ONE_CM", "FLY_ONE_CM", "DIVE_ONE_CM", "MINECART_ONE_CM", "BOAT_ONE_CM", "PIG_ONE_CM", "HORSE_ONE_CM", "SPRINT_ONE_CM", "CROUCH_ONE_CM", "AVIATE_ONE_CM", "TIME_SINCE_DEATH", "TALKED_TO_VILLAGER", "TRADED_WITH_VILLAGER", "CAKE_SLICES_EATEN", "CAULDRON_FILLED", "CAULDRON_USED", "ARMOR_CLEANED", "BANNER_CLEANED", "BREWINGSTAND_INTERACTION", "BEACON_INTERACTION", "DROPPER_INSPECTED", "HOPPER_INSPECTED", "DISPENSER_INSPECTED", "NOTEBLOCK_PLAYED", "NOTEBLOCK_TUNED", "FLOWER_POTTED", "TRAPPED_CHEST_TRIGGERED", "ENDERCHEST_OPENED", "ITEM_ENCHANTED", "RECORD_PLAYED", "FURNACE_INTERACTION", "CRAFTING_TABLE_INTERACTION", "CHEST_OPENED", "SLEEP_IN_BED", "SHULKER_BOX_OPENED");
			
			if (st.toUpperCase().startsWith("KILL_ENTITY_")) {
				
				return player.getPlayer().getStatistic(Statistic.valueOf("KILL_ENTITY"), EntityType.valueOf(st.substring(12).toUpperCase()));
			} else if (st.toUpperCase().startsWith("ENTITY_KILLED_BY_")) {
				
				return player.getPlayer().getStatistic(Statistic.valueOf("ENTITY_KILLED_BY"), EntityType.valueOf(st.substring(17).toUpperCase()));
			} else if (st.toUpperCase().startsWith("MINE_BLOCK_")) {
				
				return player.getPlayer().getStatistic(Statistic.valueOf("MINE_BLOCK"), Material.getMaterial(st.substring(11).toUpperCase()));
			} else if (st.toUpperCase().startsWith("USE_ITEM_")) {
				
				return player.getPlayer().getStatistic(Statistic.valueOf("USE_ITEM"), Material.getMaterial(st.substring(9).toUpperCase()));
			} else if (st.toUpperCase().startsWith("BREAK_ITEM_")) {
				
				return player.getPlayer().getStatistic(Statistic.valueOf("BREAK_ITEM"), Material.getMaterial(st.substring(11).toUpperCase()));
			} else if (st.toUpperCase().startsWith("CRAFT_ITEM_")) {
				
				return player.getPlayer().getStatistic(Statistic.valueOf("CRAFT_ITEM"), Material.getMaterial(st.substring(11).toUpperCase()));
			} else {
				
				for (int i = 0; i < types.size(); i++) {
					
					if (st.equalsIgnoreCase(types.get(i))) {
						
						return player.getPlayer().getStatistic(Statistic.valueOf(types.get(i).toUpperCase()));
					}
					
					if (i == types.size() && !st.equalsIgnoreCase(types.get(i))) {
						
						Main.getMainLogger().log(Level.SEVERE, "[StatsEx] There's no Statistic with the given placeholder.");
					}
				}
			}
		} catch (IllegalArgumentException e) {
			
			Main.getMainLogger().log(Level.SEVERE, "[StatsEx] Doesn't have any entity, block or item with the given string.", e);
			player.getPlayer().sendMessage("§3§l[StatsEx] §fDoesn't have any entity, block or item with the given string.");
		}
		return 0;
	}
}
