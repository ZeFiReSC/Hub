package fr.zefire.hub;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.zefire.hub.commands.BroadcastCommand;
import fr.zefire.hub.commands.GamemodeCommand;
import fr.zefire.hub.commands.HelpCommand;
import fr.zefire.hub.commands.SpawnCommand;
import fr.zefire.hub.events.PlayerBlockBreakPlaceEvent;
import fr.zefire.hub.events.PlayerConnection;
import fr.zefire.hub.events.PlayerDamageEvent;
import fr.zefire.hub.events.PlayerDropItem;
import fr.zefire.hub.events.PlayerFoodLevelChangeEvent;
import fr.zefire.hub.events.PlayerInteract;
import fr.zefire.hub.events.PlayerInventoryClickEvent;
import fr.zefire.hub.events.PlayerProperty;
import fr.zefire.hub.events.PlayerSkullPlace;
import fr.zefire.hub.events.ServerPing;
import fr.zefire.hub.gui.TeleporterGui;

public class Main extends JavaPlugin {
	static Main instance;

	@Override
	public void onEnable() {
		instance = this;
		System.out.println("Activation");

		registerCommands();
		registerEvents();
		createConfig();
	}

	@Override
	public void onDisable() {
		System.out.println("Desactivated");
	}

	private void registerCommands() {
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("help").setExecutor(new HelpCommand());
		getCommand("gm").setExecutor(new GamemodeCommand());
		getCommand("broadcast").setExecutor(new BroadcastCommand());
		getCommand("menu").setExecutor(new TeleporterGui());
	}

	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerConnection(), this);
		pm.registerEvents(new PlayerProperty(), this);
		pm.registerEvents(new TeleporterGui(), this);
		pm.registerEvents(new PlayerInteract(), this);
		pm.registerEvents(new PlayerInventoryClickEvent(), this);
		pm.registerEvents(new PlayerDropItem(), this);
		pm.registerEvents(new PlayerSkullPlace(), this);
		pm.registerEvents(new PlayerDamageEvent(), this);
		pm.registerEvents(new PlayerFoodLevelChangeEvent(), this);
		pm.registerEvents(new PlayerBlockBreakPlaceEvent(), this);
		pm.registerEvents(new ServerPing(), this);
	}

	private void createConfig() {
		try {
			if (!getDataFolder().exists()) {
				getDataFolder().mkdirs();
			}
			File file = new File(getDataFolder(), "config.yml");
			if (!file.exists()) {
				System.out.println("Config.yml not found, creating !");
				saveDefaultConfig();
			} else {
				System.out.println("Config.yml found, loading!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	public static Main getInstance() {
		return instance;
	}

}
