package me.projeto.utils;

import java.sql.*;

public class MYSQL {

    private Connection connection;

    private final String user;
    private final String pass;
    private final String host;
    private final int port;
    private final String db;
    private int query;

    public MYSQL(String user, String pass, String host, int port, String db) {
        this.user = user;
        this.pass = pass;
        this.host = host;
        this.port = port;
        this.db = db;
        this.query = 0;
        loadDB();
    }

    public void openConnection() {
        try {
            query++;
            if ((connection != null) && (!connection.isClosed()))
                return;
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false", user, pass);
        } catch (SQLException e) {
            query--;
            e.getStackTrace();
            System.out.println(
                    "Ocorreu um erro ao abrir a conexão!");
        }
    }

    public void closeConnection() {
        query--;
        if (query <= 0) {
            try {
                if (connection != null && !connection.isClosed())
                    connection.close();
            } catch (Exception e) {
                System.out.println(
                        "Houve um erro ao fechar a conexão!");
            }
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    private void loadDB() {
        openConnection();
        criarTabelas();
        closeConnection();
    }

    private void criarTabela(String tabela, String colunas) {
        try {
            if ((connection != null) && (!connection.isClosed())) {
                Statement stm = connection.createStatement();
                stm.executeUpdate("CREATE TABLE IF NOT EXISTS " + tabela + " (" + colunas + ");");
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao salvar o MYSQL!");
        }
    }

    private void criarTabelas() {
        criarTabela("informacoes","nome varchar(16), blocos int");
        criarTabela("PlayerGeneral", "nome varchar(16), kills smallint, mortes smallint, level smallint, classe varchar(32), raca varchar(32), reino varchar(20), cargo varchar(16), rank varchar(20), tempo int, ultima varchar(32), pedido varchar(32), desbugar varchar(32)");
        criarTabela("Backpacks", "id varchar(6), backpack tinytext, contents longtext");
        criarTabela("ReinoTop", "nome varchar(16), invasoes smallint, invadido smallint");
    }

}