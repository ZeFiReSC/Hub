package fr.zefire.hub.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(!(sender instanceof Player))
			return true;
		
		Player player = (Player) sender;
		
		if(args.length == 0) {
			player.sendMessage("§cErreur de syntaxe: /gm <0|1|2|3>");
			
		}else if(args.length == 1){
			switch (args[0]) {
			case "0":
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage("§bVous venez de changer votre gamemode.");
				break;
			case "1":
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage("§bVous venez de changer votre gamemode.");
				break;
			case "2":
				player.setGameMode(GameMode.ADVENTURE);
				player.sendMessage("§bVous venez de changer votre gamemode.");
				break;
			case "3":
				player.setGameMode(GameMode.SPECTATOR);
				player.sendMessage("§bVous venez de changer votre gamemode.");
				break;
			default:
				player.sendMessage("§cLa valeur que vous avez entré n'est pas valide.");
				break;
			}
			
		}else if(args.length == 2) {
			Player target = Bukkit.getPlayer(args[1]);
			
			switch (args[0]) {
			case "0":
				target.setGameMode(GameMode.SURVIVAL);
				target.sendMessage("§bVotre gamemode a été modifié.");
				player.sendMessage("§bVous avez changé le gamemode de §6" + target.getDisplayName() + ".");
				break;
			case "1":
				target.setGameMode(GameMode.CREATIVE);
				target.sendMessage("§bVotre gamemode a été modifié.");
				player.sendMessage("§bVous avez changé le gamemode de §6" + target.getDisplayName() + ".");
				break;
			case "2":
				target.setGameMode(GameMode.ADVENTURE);
				target.sendMessage("§bVotre gamemode a été modifié.");
				player.sendMessage("§bVous avez changé le gamemode de §6" + target.getDisplayName() + ".");
				break;
			case "3":
				target.setGameMode(GameMode.SPECTATOR);
				target.sendMessage("§bVotre gamemode a été modifié.");
				player.sendMessage("§bVous avez changé le gamemode de §6" + target.getDisplayName() + ".");
				break;
			default:
				player.sendMessage("§cLa valeur que vous avez entré n'est pas valide.");
				break;
			}
			
		}else {
			player.sendMessage("§cErreur de syntaxe: /gm <0|1|2|3>");
			
		}
		
		
		
		
		
		return true;
	}

}
