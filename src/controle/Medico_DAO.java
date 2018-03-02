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
import modelo.Medico;

/**
 *
 * @author henri
 */
public class Medico_DAO {

    Conexao conexao = new Conexao();
    Connection con = conexao.getConexao();

    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Medico> buscar() {
        ArrayList<Medico> listaMedico = new ArrayList<>();
        try {
            String sql = "Select * from medico";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Medico med = new Medico();
                med.setId(rs.getInt("med_id"));
                med.setNome(rs.getString("med_nome"));
                med.setEspec(rs.getString("med_espec"));
                listaMedico.add(med);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados de Médicos");
        }
        return listaMedico;
    }
    
    public ArrayList<Medico> buscar(String nome) {
        ArrayList<Medico> listaMedico = new ArrayList<>();
        try {
            String sql = "Select * from medico where lower(med_nome) like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Medico med = new Medico();
                med.setId(rs.getInt("med_id"));
                med.setNome(rs.getString("med_nome"));
                med.setEspec(rs.getString("med_espec"));
                listaMedico.add(med);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados de Médicos");
        }
        return listaMedico;
    }

    public void excluir(Medico med) {
        try {
            String sql = "delete from medico where med_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, med.getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao excluir Médico\n"+e);
        }
    }
   
    
    public void inserir(Medico med){
        try {
            String sql = "insert into medico (med_nome, med_espec) values (?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, med.getNome());
            ps.setString(2, med.getEspec());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir Médico\n"+e);
        }
    }
   
    public void editar(Medico med){
        try {
            String sql = "update medico set med_nome = ?, "
                    + "med_espec = ?"
                    + " where med_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, med.getNome());
            ps.setString(2, med.getEspec());
            ps.setInt(3, med.getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao editar Médico\n"+e);
        }
    }
}
