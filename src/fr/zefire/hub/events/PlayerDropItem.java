package fr.zefire.hub.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItem implements Listener {

	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent event) {
		if(event.getItemDrop().getItemStack().getType() == Material.COMPASS)
			event.setCancelled(true);
		if(event.getItemDrop().getItemStack().getType() == Material.NAME_TAG)
			event.setCancelled(true);
		if(event.getItemDrop().getItemStack().getType() == Material.SKULL_ITEM)
			event.setCancelled(true);
	}
}
