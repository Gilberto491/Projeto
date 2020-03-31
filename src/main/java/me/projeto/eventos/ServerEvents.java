package me.projeto.eventos;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerEvents implements Listener {

    @EventHandler
    public void quandoPingar(ServerListPingEvent e){
        if(!Bukkit.hasWhitelist()) e.setMotd("§4SERVIDOR DO MITO DO PVP LOCALHOST\n§2VENHA SE DIVERTIR E §ePROVE QUE VOCê É O MELHOR!");
        else e.setMotd("§4O servidor está em manutenção!");
    }
}
