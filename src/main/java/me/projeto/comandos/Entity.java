package me.projeto.comandos;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.inventory.ItemStack;

public class Entity implements CommandExecutor {
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;
        if(c.getName().equalsIgnoreCase("entidades")){
            Wither whiter = (Wither) p.getWorld().spawnEntity(p.getLocation(), EntityType.WITHER);

            ItemStack item = new ItemStack(Material.DIAMOND,1);
            whiter.setCustomName("§1blue");
            whiter.setCustomNameVisible(true);
            whiter.getAttribute(Attribute.GENERIC_MAX_HEALTH);

            whiter.getEquipment().setItemInMainHand(item);
            whiter.getEquipment().setItemInMainHandDropChance(100);
        }
        return false;
    }

}
