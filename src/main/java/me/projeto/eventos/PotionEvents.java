package me.projeto.eventos;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class PotionEvents implements Listener {

    @EventHandler
    public void quandoColocarUmBloco(BlockPlaceEvent e){
        Block drop = e.getBlock();
        Player p = e.getPlayer();

        if(drop.getType() != Material.DIAMOND_BLOCK) return;

        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,20*100,2,false,true));


    }
}
