package me.projeto.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Ajuda implements CommandExecutor {

    private HashMap<Player, Long> ajuda = new HashMap<Player, Long>(); //HashMap do cooldown

    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
    if (!(s instanceof Player)) return false;
    Player p = (Player) s;

    if(c.getName().equalsIgnoreCase("ajuda")){


        if(ajuda.containsKey(p) && !(System.currentTimeMillis() >= ajuda.get(p))){ //cooldown
            p.sendMessage(("§7Aguarde " + "§4" + converter(p) +" §7segundos para digitar o comando novamente"));
            return false;
        }else ajuda.remove(p);

        ajuda.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10)); //10 segundos

        if(args.length == 0){
            p.sendMessage("");
            p.sendMessage("Digite /ajuda 1 - para o servidor");
            p.sendMessage("Digite /ajuda 2 - para o youtube");
            return true;
        }

        if(args.length == 1){
            if(args[0].equalsIgnoreCase("1")){
            p.sendMessage("Nosso servidor está na versão 1.8");
            return true;
         }

         if(args[0].equalsIgnoreCase("2")){
            p.sendMessage("youtube: marquinhos.pvp");
            return true;
         }
     }
}
        return false;
    }
    private Long converter(Player p){
        long tempo = System.currentTimeMillis() - ajuda.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(tempo) * - 1;
    }
}
