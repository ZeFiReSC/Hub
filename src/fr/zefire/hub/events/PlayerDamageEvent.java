package fr.zefire.hub.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageEvent implements Listener {

	@EventHandler
	public void onPlayerDamaged(EntityDamageEvent event) {
		if(event.getEntity() instanceof Player)
			event.setCancelled(true);
	}
}
