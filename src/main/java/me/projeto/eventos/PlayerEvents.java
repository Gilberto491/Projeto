package me.projeto.eventos;

import me.projeto.entities.WelcomeInventory;
import me.projeto.utils.Item;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.awt.*;

public class PlayerEvents implements Listener {

    @EventHandler
    public void quandoQuebrarBloco(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if(b.getType() != Material.DIAMOND_BLOCK) return;

        p.sendMessage("§bVocê achou um bloco de Diamante que incrivel :)");


        ItemStack mao = p.getInventory().getItemInMainHand();
        if(mao.getType() == Material.APPLE){
            p.sendMessage("se alimente bem");
        }


        ItemStack item = p.getInventory().getItem(0);
        ItemStack elmo = new Item(Material.IRON_HELMET,1,(short) 0)
                .setNome("Elmo Supremo")
                .getItemStack();
        if(item != null) p.getInventory().setHelmet(elmo); //setando elmo

        if(item != null && item.getType() == Material.DIAMOND) p.sendMessage("Eu sou adivinha e você têm um diamante no inventário");
    }

    @EventHandler
    public void quandoEntrarServidor(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.sendMessage((" §2Olá, seja bem vindo ao nosso servidor :)"));

        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new net.md_5.bungee.api.chat.TextComponent("§eSeja Bem Vindo " + p.getName())); //ActionBar

    }

    @EventHandler
    public void quandoChamarComando(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        if(e.getMessage().equalsIgnoreCase("/youtube")) {
            p.openInventory(new WelcomeInventory().getInventory());
            p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_HURT, 10, 10); //SOUNDS
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void Chat(AsyncPlayerChatEvent e){
        e.setFormat(e.getPlayer().getPlayerListName()+ "§f " + e.getMessage());
    }
}
