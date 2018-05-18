package fr.zefire.hub.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.zefire.hub.Main;

public class SpawnCommand implements CommandExecutor {
	
	FileConfiguration config = Main.getInstance().getConfig();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (!(sender instanceof Player))
			return true;
		
		Player player = (Player) sender;
		
		if(args.length == 0) {
			double x = config.getDouble("location.spawn.x");
			double y = config.getDouble("location.spawn.y");
			double z = config.getDouble("location.spawn.z");
			float yaw = (float) config.getDouble("location.spawn.yaw");
			float pitch = (float) config.getDouble("location.spawn.pitch");
			World world = Bukkit.getWorld(config.getString("location.spawn.world"));

			player.teleport(new Location(world, x, y, z, yaw, pitch));
			player.sendMessage("§bVous avez été téléporté au spawn.");
			
		}else if(args.length == 1 && args[0].equalsIgnoreCase("set")) {
			if(!player.hasPermission("hub.commands.spawnset"))
				return true;
			
			double x = player.getLocation().getX();
			double y = player.getLocation().getY();
			double z = player.getLocation().getZ();
			float yaw = player.getLocation().getYaw();
			float pitch = player.getLocation().getPitch();
			String world = player.getWorld().getName();

			config.set("location.spawn.x", x);
			config.set("location.spawn.y", y);
			config.set("location.spawn.z", z);
			config.set("location.spawn.yaw", yaw);
			config.set("location.spawn.pitch", pitch);
			config.set("location.spawn.world", world);
			Main.getInstance().saveConfig();
			player.sendMessage("§bVous avez enregistré des nouvelles coordonnées pour le spawn");
			
		}else {
			player.sendMessage("§cErreur de syntaxe: /spawn <set>");
		}
		
		return true;
	}

}
