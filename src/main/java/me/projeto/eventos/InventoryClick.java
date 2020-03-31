package me.projeto.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

    @EventHandler
    public void quenadoClicar(InventoryClickEvent e){
        if(!e.getInventory().getName().equalsIgnoreCase("Bem vindo ao servidor!")) return;

        ItemStack i = e.getCurrentItem();
        e.setCancelled(true);
        Player p = (Player) e.getWhoClicked();


        if(i.getType() == Material.DIAMOND){ /*verificação por tipo*/
            p.closeInventory();
            p.sendMessage("você está clicando num diamante");
        }
        if(i.getType() == Material.IRON_SWORD){
            p.closeInventory();
            p.sendMessage("você está clicando em um capacete de ferro");
        }

    }
    @EventHandler
    public void quandoAbrirGui(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getItem() == null){
            return;
        }
        if(e.getItem().getType() == Material.COMPASS){
            Inventory inv = Bukkit.createInventory(null,9*3,"MENU");
            inv.addItem(new ItemStack(Material.DIAMOND));
            p.openInventory(inv);
        }
    }
    @EventHandler
    public void quandoClicarNaGui(InventoryClickEvent e){
        if(e.getWhoClicked() instanceof Player){
            Player p = (Player)e.getWhoClicked();
            if(e.getInventory().getTitle().equals("MENU")){
                if(e.getCurrentItem().getType() == Material.DIAMOND){
                    p.teleport(p.getWorld().getSpawnLocation());
                    p.sendMessage("Você foi teletransportado para o spawn");
                    p.closeInventory();
                    e.setCancelled(true);
                }
            }
        }
    }
}
