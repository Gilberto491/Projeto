package me.projeto.comandos;

import me.projeto.utils.Item;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Kits implements CommandExecutor {

    private HashMap<Player, Long> kits = new HashMap<Player, Long>(); //HashMap do cooldown

    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if (!(s instanceof Player)) return false;
        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("kits")){

            //Sistema de cooldown

            if(kits.containsKey(p) && !(System.currentTimeMillis() >= kits.get(p))){ //cooldown
                p.sendMessage(("§7Aguarde " + "§4" + converter(p)/3600 +" §7hora(s) para digitar o comando novamente"));
                return false;
            }else kits.remove(p);

            kits.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(9000)); //10 segundos


            ItemStack capaceteVip = new Item(Material.DIAMOND_HELMET,1)
                   .setNome("&aKIT VIP")
                   .setEncanto(Enchantment.OXYGEN,3)
                   .setEncanto(Enchantment.DURABILITY,3)
                   .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL,4)
                   .setEncanto(Enchantment.THORNS,3)
                   .getItemStack();

            ItemStack peitoralVip = new Item(Material.DIAMOND_CHESTPLATE,1)
                    .setNome("&aKIT VIP")
                    .setEncanto(Enchantment.OXYGEN,3)
                    .setEncanto(Enchantment.DURABILITY,3)
                    .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL,4)
                    .setEncanto(Enchantment.THORNS,3)
                    .getItemStack();

            ItemStack calcaVip = new Item(Material.DIAMOND_LEGGINGS,1)
                    .setNome("&aKIT VIP")
                    .setEncanto(Enchantment.OXYGEN,3)
                    .setEncanto(Enchantment.DURABILITY,3)
                    .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL,4)
                    .setEncanto(Enchantment.THORNS,3)
                    .getItemStack();

            ItemStack botaVip = new Item(Material.DIAMOND_BOOTS,1)
                    .setNome("&aKIT VIP")
                    .setEncanto(Enchantment.OXYGEN,3)
                    .setEncanto(Enchantment.DURABILITY,3)
                    .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL,4)
                    .setEncanto(Enchantment.THORNS,3)
                    .getItemStack();

           ItemStack espada = new Item(Material.DIAMOND_SWORD,1)
                   .setNome("&aKIT VIP")
                   .setEncanto(Enchantment.DURABILITY,3)
                   .setEncanto(Enchantment.DAMAGE_ALL,5)
                   .setEncanto(Enchantment.FIRE_ASPECT,2)
                   .setEncanto(Enchantment.KNOCKBACK,3)
                   .getItemStack();

           ItemStack maca = new Item(Material.GOLDEN_APPLE,32)
                   .setNome("&aKIT VIP\"")
                   .getItemStack();

           p.getInventory().addItem(espada, capaceteVip, peitoralVip, calcaVip, botaVip, maca);

        }
        return false;
    }
    private Long converter(Player p){
        long tempo = System.currentTimeMillis() - kits.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(tempo) * - 1;
    }

}
