package fr.zefire.hub.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.zefire.hub.Main;

public class HelpCommand implements CommandExecutor {

	FileConfiguration config = Main.getInstance().getConfig();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(!(sender instanceof Player))
			return true;
		
		Player player = (Player) sender;
		
		if(config.getBoolean("custom-help")) {
		    for(String helpmessage : config.getStringList("help")) {
		        player.sendMessage(ChatColor.translateAlternateColorCodes('&', helpmessage));
		    }
		}else {
			player.sendMessage("§cL'affichage custom de l'aide n'est pas activée.");
			Bukkit.dispatchCommand(player, "bukkit:help");
		}
		
		
		
		return true;
	}

}
