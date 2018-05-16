package fr.zefire.hub.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerInventoryClickEvent implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (event.getCurrentItem().getType() == Material.COMPASS)
			event.setCancelled(true);
		if (event.getCurrentItem().getType() == Material.NAME_TAG)
			event.setCancelled(true);
		if (event.getCurrentItem().getType() == Material.SKULL_ITEM)
			event.setCancelled(true);
	}

}
