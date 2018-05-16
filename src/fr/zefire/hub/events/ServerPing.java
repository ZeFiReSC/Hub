package fr.zefire.hub.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerPing implements Listener {

	
	@EventHandler
	public void onServerPing(ServerListPingEvent event) {
		event.setMaxPlayers(150);
		event.setMotd("§6§l< Le Serveur de le développement >");
	}
}
