package me.projeto.manager;

import me.projeto.objetos.PlayerBlock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;
import static me.projeto.Projeto.*;

public class PlayerBlockManager {

    public static void insert(){

        PlayerBlock joao = new PlayerBlock("joao",5);
        PlayerBlock carlos = new PlayerBlock("carlos",20);

        List<PlayerBlock> list = Arrays.asList(joao, carlos);

        try{

            getMySQL().openConnection();
            Connection connection = getMySQL().getConnection();
            PreparedStatement ps = null;


            for(PlayerBlock pb: list){
                ps = connection.prepareStatement("INSERT INTO informacoes VALUES('"+ pb.getNome() +"','" + pb.getQuantidade() + "')");
                ps.execute();
            }
            ps.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            getMySQL().closeConnection();
        }
    }
}
