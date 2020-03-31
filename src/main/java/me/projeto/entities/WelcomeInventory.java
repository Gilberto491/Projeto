package me.projeto.entities;

/*import me.projeto.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WelcomeInventory {
    private Inventory inventory;

    public WelcomeInventory(){
        inventory = Bukkit.createInventory(null,9 * 3,"Bem vindo ao servidor!");
        insertItens();
    }

    private void insertItens(){
        ItemStack i= new Item(Material.DIAMOND,1).setNome("§7Spawn").getItemStack();
        ItemStack i2 = new Item(Material.IRON_SWORD,1).setNome("§4[Em Breve]").getItemStack();

        inventory.setItem(12,i);
        inventory.setItem(14,i2);
    }

    public Inventory getInventory() {
        return inventory;
    }
}*/

import me.projeto.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class WelcomeInventory {

    private Inventory inventory;

    public WelcomeInventory() {
        inventory = Bukkit.createInventory(null, 9 * 2, "VenderGay");
        insertItens();
    }

    private void insertItens() {
        ItemStack i = new Item(Material.DIAMOND, 1)
                .setLore(Arrays.asList("§aVender", "§aPara", "§aDeepWeb")).getItemStack();
        ItemStack i1 = new Item(Material.GOLD_AXE, 1).getItemStack();
        inventory.setItem(0, i);
        inventory.setItem(1, i1);
    }

    public Inventory getInventory() {
        return inventory;
    }

}

