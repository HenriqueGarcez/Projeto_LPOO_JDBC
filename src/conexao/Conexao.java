/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vanessa-NB
 */
public class Conexao {

    public Conexao() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar driver");
        }
    }

    public Connection getConexao() {
        String url = "jdbc:postgresql://localhost:5432/LPOO_Hospital";
        String login = "postgres";
        String senha = "x84782718";

        try {
            Connection con = DriverManager.getConnection(url, login, senha);
            return con;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco");
            return null;
        }

    }
}
