package fr.zefire.hub.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(args.length == 0) {
				player.sendMessage("§cErreur de syntaxe: /broadcast <message>");
				return true;
			}
			
			StringBuilder builder = new StringBuilder("§c[§aBroadcast§c] §r" + args[0]);
			for (int i = 1; i < args.length; i++)
				builder.append(args[i]);
			player.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', builder.toString()));
		}else {
			if(args.length == 0) {
				System.out.println("§cErreur de syntaxe: /broadcast <message>");
				return true;
			}
			
			StringBuilder builder = new StringBuilder("§c[§aBroadcast§c] §r" + args[0]);
			for (int i = 1; i < args.length; i++)
				builder.append(args[i]);
			Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', builder.toString()));
		}
		
		return true;
		
	}

}
