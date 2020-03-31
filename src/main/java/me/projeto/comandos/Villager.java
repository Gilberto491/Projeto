package me.projeto.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Villager implements CommandExecutor {
    public boolean onCommand(CommandSender s, Command c, String label, String[] args){
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;
        if(c.getName().equalsIgnoreCase("villager")){
            spawnNPC(p);
        }
        return false;
    }

    private void spawnNPC(Player p){
        org.bukkit.entity.Villager villager = (org.bukkit.entity.Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
        villager.setCustomNameVisible(true);
        villager.setCustomName("§7Comprador");
        villager.setAI(false);
    }
}
