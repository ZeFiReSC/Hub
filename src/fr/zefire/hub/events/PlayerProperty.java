package fr.zefire.hub.events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import fr.zefire.hub.Main;

public class PlayerProperty implements Listener {
	
	FileConfiguration config = Main.getInstance().getConfig();
	
	@EventHandler
	public void onPlayerDamaged(EntityDamageEvent event) {
		if(!(config.getBoolean("enable-fall-damage"))) {
			if(event.getEntity() instanceof Player) {
				if(event.getCause() == DamageCause.FALL) {
					event.setCancelled(true);
				}
			}
		}
	}

}
