package fr.zefire.hub.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerConnection implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage("§8[§2§l+§8] §b" + player.getName());
		itemJoin(player);
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		event.setQuitMessage("§8[§4§l-§8] §b" + player.getName());
	}

	private void itemJoin(Player player) {
		ItemStack teleporter = new ItemStack(Material.COMPASS);
        ItemMeta tp = teleporter.getItemMeta();
        tp.setDisplayName("§cTéléportation");
        teleporter.setItemMeta(tp);
		ItemStack link = new ItemStack(Material.NAME_TAG);
        ItemMeta linkMeta = link.getItemMeta();
        linkMeta.setDisplayName("§eLiens Utiles");
        link.setItemMeta(linkMeta);
		ItemStack profile = getHead(player);
		
		player.getInventory().clear();
		player.getInventory().setItem(0, teleporter);
		player.getInventory().setItem(4, link);
		player.getInventory().setItem(8, profile);
	}
	
	private ItemStack getHead(Player player) {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skull = (SkullMeta) item.getItemMeta();
        skull.setDisplayName("§6Profile de " + player.getName());
        skull.setOwner(player.getName());
        item.setItemMeta(skull);
        return item;
    }
}
