package fr.zefire.hub.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerBlockBreakPlaceEvent implements Listener {

	@EventHandler
	public void onPlayerBlockBreak(BlockBreakEvent event) {
		if(!event.getPlayer().hasPermission("hub.admin")) {
			event.setCancelled(true);
			event.getPlayer().sendMessage("§4Vous ne pouvez pas casser de blocs !");
		}
	}

	@EventHandler
	public void onPlayerBlockPlace(BlockPlaceEvent event) {
		if(!event.getPlayer().hasPermission("hub.admin")) {
			event.setCancelled(true);
			event.getPlayer().sendMessage("§4Vous ne pouvez pas placer de blocs !");
		}
	}
}
