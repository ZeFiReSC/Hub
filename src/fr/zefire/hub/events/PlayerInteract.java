package fr.zefire.hub.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		List<Action> list = new ArrayList<>();
		list.add(Action.RIGHT_CLICK_AIR);
		list.add(Action.RIGHT_CLICK_BLOCK);
		list.add(Action.LEFT_CLICK_AIR);
		list.add(Action.LEFT_CLICK_BLOCK);

		if (event.getPlayer().getItemInHand().getType() == Material.NAME_TAG) {
			if (list.contains(event.getAction())) {
				List<String> msg = new ArrayList<>();
				msg.add("");
				msg.add("§dSite : www.site.com");
				msg.add("§dTeamSpeak : ts.teamspeak.com");
				msg.add("");

				for (String s : msg) {
					event.getPlayer().sendMessage(s);
				}
			}
		}
		
		if (event.getPlayer().getItemInHand().getType() == Material.SKULL_ITEM) {
			if (list.contains(event.getAction())) {
				List<String> msg = new ArrayList<>();
				msg.add("");
				msg.add("§3Nombre de sauts: " + event.getPlayer().getStatistic(Statistic.JUMP));
				msg.add("§3Nombre de pas: " + event.getPlayer().getStatistic(Statistic.WALK_ONE_CM));
				msg.add("§3Temps de jeu: " + event.getPlayer().getStatistic(Statistic.PLAY_ONE_TICK));
				msg.add("");

				for (String s : msg) {
					event.getPlayer().sendMessage(s);
				}
			}
		}
	}

}
