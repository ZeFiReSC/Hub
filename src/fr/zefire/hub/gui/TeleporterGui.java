package fr.zefire.hub.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeleporterGui implements Listener, CommandExecutor {
	public Inventory tp = Bukkit.createInventory(null, 9, "§cTéléportation");

	private void teleportGui() {
		tp.setItem(3, createGuiItem("§6§lSkyBlock", null, Material.GRASS));
		tp.setItem(5, createGuiItem("§6§lFaction", null, Material.DIAMOND_SWORD));
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (!(sender instanceof Player))
			return true;

		Player player = (Player) sender;
		openInventory(player);

		return true;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		List<Action> list = new ArrayList<>();
		list.add(Action.RIGHT_CLICK_AIR);
		list.add(Action.RIGHT_CLICK_BLOCK);
		list.add(Action.LEFT_CLICK_AIR);
		list.add(Action.LEFT_CLICK_BLOCK);

		if (event.getPlayer().getItemInHand().getType() == Material.COMPASS)
			if (list.contains(event.getAction()))
				openInventory(event.getPlayer());
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clickedItem = event.getCurrentItem();

		if (!event.getInventory().getName().equals(tp.getName()))
			return;
		if (!(event.getWhoClicked() instanceof Player))
			return;
		event.setCancelled(true);
		if (clickedItem == null)
			return;
		if (clickedItem.getType() == Material.GRASS) {
			player.sendMessage("§9Direction le SkyBlock");
			player.closeInventory();
		}
		if (clickedItem.getType() == Material.DIAMOND_SWORD) {
			player.sendMessage("§9Direction le Faction");
			player.closeInventory();
		}
	}

	private void openInventory(Player player) {
		teleportGui();
		player.openInventory(tp);
	}

	private ItemStack createGuiItem(String name, ArrayList<String> desc, Material mat) {
		ItemStack i = new ItemStack(mat, 1);
		ItemMeta iMeta = i.getItemMeta();
		iMeta.setDisplayName(name);
		iMeta.setLore(desc);
		i.setItemMeta(iMeta);
		return i;
	}

}
