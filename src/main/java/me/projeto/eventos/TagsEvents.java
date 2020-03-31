package me.projeto.eventos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TagsEvents implements Listener, CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return true;
        Player p = (Player) s;
        if(c.getName().equalsIgnoreCase("tag")){
            if(args.length == 0){
                p.sendMessage("Use /tag <tag>");
                return true;
            }
            if(p.hasPermission("tag.dono")){
                if(args[0].equalsIgnoreCase("dono")){
                    p.sendMessage("Tag Alterata para dono");
                    p.setDisplayName("§l[dono] " + "§f" + p.getName());
                    p.setPlayerListName("§l[dono] " +"§f" + p.getName());
                }else{
                    p.sendMessage("Você não tem permissão");
                }
            }

        }



        return false;
    }
}
