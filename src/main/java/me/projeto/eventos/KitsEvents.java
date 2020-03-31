package me.projeto.eventos;

import me.projeto.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitsEvents implements Listener {

    @EventHandler
    public void quandoAbrirMenu(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getItem() == null)return;

        if(e.getItem().getType() == Material.COMPASS){
            Inventory inv = Bukkit.createInventory(null,9*3,"MENU");
            //inv.addItem(new ItemStack(Material.DIAMOND_SWORD));
            ItemStack i= new Item(Material.BED,1).setNome("§7Spawn").getItemStack();
            ItemStack i2 = new Item(Material.DIAMOND_SWORD,1).setNome("§4[Arena PVP]").getItemStack();
            inv.setItem(12,i);
            inv.setItem(14,i2);
            p.openInventory(inv);
        }
    }

    @EventHandler
    public void quandoClicarMenu(InventoryClickEvent e){
        if(e.getWhoClicked() instanceof Player){
            Player p = (Player)e.getWhoClicked();

            if(e.getInventory().getTitle().equals("MENU")){

                if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
                    p.teleport(p.getWorld().getSpawnLocation());
                    p.sendMessage("§2Você foi teletransportado para a arena PVP");
                    p.closeInventory();
                    e.setCancelled(true);

                    //INICIO DOS SETS
                    ItemStack item = p.getInventory().getItem(0);
                    ItemStack elmo = new Item(Material.DIAMOND_HELMET,1,(short) 0)
                            .setEncanto(Enchantment.OXYGEN,3)
                            .setEncanto(Enchantment.DURABILITY,3)
                            .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL,4)
                            .setEncanto(Enchantment.THORNS,3)
                            .getItemStack();
                    if(item != null) p.getInventory().setHelmet(elmo); //setando elmo

                    ItemStack item2 = p.getInventory().getItem(0);
                    ItemStack peitoral = new Item(Material.DIAMOND_CHESTPLATE,1, (short) 0)
                            .setEncanto(Enchantment.OXYGEN,3)
                            .setEncanto(Enchantment.DURABILITY,3)
                            .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL,4)
                            .setEncanto(Enchantment.THORNS,3)
                            .getItemStack();
                    if(item2 != null) p.getInventory().setChestplate(peitoral);

                    ItemStack item3 = p.getInventory().getItem(0);
                    ItemStack calca = new Item(Material.DIAMOND_LEGGINGS,1, (short) 0)
                            .setEncanto(Enchantment.OXYGEN,3)
                            .setEncanto(Enchantment.DURABILITY,3)
                            .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL,4)
                            .setEncanto(Enchantment.THORNS,3)
                            .getItemStack();
                    if(item3 != null) p.getInventory().setLeggings(calca);

                    ItemStack item4 = p.getInventory().getItem(0);
                    ItemStack bota = new Item(Material.DIAMOND_BOOTS,1, (short) 0)
                            .setEncanto(Enchantment.OXYGEN,3)
                            .setEncanto(Enchantment.DURABILITY,3)
                            .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL,4)
                            .setEncanto(Enchantment.THORNS,3)
                            .getItemStack();
                    if(item4 != null) p.getInventory().setBoots(bota);

                    ItemStack item5 = p.getInventory().getItem(0);
                    ItemStack espada = new Item(Material.DIAMOND_SWORD,1, (short) 0)
                            .setNome("§dMatadora de Kenga")
                            .setEncanto(Enchantment.DURABILITY,3)
                            .setEncanto(Enchantment.DAMAGE_ALL,5)
                            .setEncanto(Enchantment.FIRE_ASPECT,2)
                            .setEncanto(Enchantment.KNOCKBACK,3)
                            .getItemStack();
                    if(item5 != null) p.getInventory().setItem(0, espada);

                    ItemStack item6 = p.getInventory().getItem(0);
                    ItemStack maca = new Item(Material.GOLDEN_APPLE,32, (short) 0)
                            .getItemStack();
                    if(item6 != null) p.getInventory().setItem(1,maca);

                    ItemStack item7 = p.getInventory().getItem(0);
                    ItemStack arco = new Item(Material.BOW,1, (short) 0)
                            .setEncanto(Enchantment.FIRE_ASPECT,2)
                            .setEncanto(Enchantment.KNOCKBACK,3)
                            .getItemStack();
                    if(item7 != null) p.getInventory().setItem(2,arco);


                    //FIM DOS SETS
                }
                if(e.getCurrentItem().getType() == Material.BED){
                    p.sendMessage("§4EM BREVE");
                    p.closeInventory();
                    e.setCancelled(true);
                }
            }
        }
    }
}
