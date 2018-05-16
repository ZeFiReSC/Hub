package fr.zefire.hub.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerSkullPlace implements Listener {

	@EventHandler
	public void onPlayerBlockPlace(BlockPlaceEvent event) {
		if (event.getItemInHand().getType() == Material.SKULL_ITEM)
			event.setCancelled(true);
	}
}
