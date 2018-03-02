/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cidade;

/**
 *
 * @author Henrique-Conti
 */
public class Cidade_DAO {

    Conexao conexao = new Conexao();
    Connection con = conexao.getConexao();

    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Cidade> buscar() {
        ArrayList<Cidade> listaCidade = new ArrayList<>();
        try {
            String sql = "Select * from cidade";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cidade cid = new Cidade();
                cid.setId(rs.getInt("cid_id"));
                cid.setNome(rs.getString("cid_nome"));
        //                      
                listaCidade.add(cid);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados de Cidades");
        }
        return listaCidade;
    }

    
    public ArrayList<Cidade> buscar(String nome){
        nome = nome.toLowerCase();
        ArrayList<Cidade> listaCidade = new ArrayList<>();
        try {
            String sql = "Select * from cidade where lower(cid_nome) like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Cidade cid = new Cidade();
                cid.setId(rs.getInt("cid_id"));
                cid.setNome(rs.getString("cid_nome"));
                listaCidade.add(cid);
            }

            rs.close();
            ps.close();
            con.close();
            
        }catch (Exception e) {
            System.out.println("Erro ao buscar dados de Cidades");
        }
        
        return listaCidade;
    }
    


    public void excluir(Cidade cid) {
        try {
            String sql = "delete from cidade where cid_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, cid.getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao excluir cidade");
        }
    }
   
    
    public void inserir(Cidade cid){
        try {
            String sql = "insert into cidade (cid_nome) values (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, cid.getNome());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir cidade\n"+e);
        }
    }
   
    public void editar(Cidade cid){
        try {
            String sql = "update cidade set cid_nome = ?" + " where cid_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cid.getNome());
            ps.setInt(2, cid.getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao editar cidade\n"+e);
        }
    }
}

