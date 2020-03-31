package me.projeto;

import me.projeto.comandos.Ajuda;
import me.projeto.comandos.Entity;
import me.projeto.comandos.Kits;
import me.projeto.comandos.Villager;
import me.projeto.eventos.*;
import me.projeto.manager.PlayerBlockManager;
import me.projeto.utils.MYSQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Projeto extends JavaPlugin {

    private static MYSQL mysql;

    @Override
    public void onEnable() {
        carregarConfig();
        registrarEventos();
        registrarComandos();
        mysql = new MYSQL("root","","localhost",3306,"aula");
        PlayerBlockManager.insert();
    }
    private void carregarConfig(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }
    private void registrarEventos(){
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(),this);
        Bukkit.getPluginManager().registerEvents(new ServerEvents(),this);
        Bukkit.getPluginManager().registerEvents(new PotionEvents(), this);
        Bukkit.getPluginManager().registerEvents(new TagsEvents(),this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick(),this);
        Bukkit.getPluginManager().registerEvents(new KitsEvents(),this);
        Bukkit.getPluginManager().registerEvents(new NpcEvents(),this);
    }
    private void registrarComandos(){
        getCommand("ajuda").setExecutor(new Ajuda());
        getCommand("kits").setExecutor(new Kits());
        getCommand("tag").setExecutor(new TagsEvents());
        getCommand("entidades").setExecutor(new Entity());
        getCommand("villager").setExecutor(new Villager());
    }

    @Override
    public void onDisable() {

    }

    public static MYSQL getMySQL(){
        return mysql;
    }

}



