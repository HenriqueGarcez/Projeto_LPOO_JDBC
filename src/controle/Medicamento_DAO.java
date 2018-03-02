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
import java.util.ArrayList;
import modelo.Medicamento;

/**
 *
 * @author henri
 */
public class Medicamento_DAO {
    
    Conexao conexao = new Conexao();
    Connection con = conexao.getConexao();

    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Medicamento> buscar() {
        ArrayList<Medicamento> listaMedicamento = new ArrayList<>();
        try {
            String sql = "Select * from medicamento";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Medicamento medi = new Medicamento();
                medi.setId(rs.getInt("meds_id"));
                medi.setNome(rs.getString("meds_nome"));
                medi.setQnt(rs.getString("meds_qnt"));
                listaMedicamento.add(medi);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados de Médicos");
        }
        return listaMedicamento;
    }
    
    public ArrayList<Medicamento> buscar(String nome) {
        ArrayList<Medicamento> listaMedicamento = new ArrayList<>();
        try {
            String sql = "Select * from medicamento where lower(meds_nome) like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Medicamento medi = new Medicamento();
                medi.setId(rs.getInt("meds_id"));
                medi.setNome(rs.getString("meds_nome"));
                medi.setQnt(rs.getString("meds_qnt"));
                listaMedicamento.add(medi);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados de Médicamentos");
        }
        return listaMedicamento;
    }

    public void excluir(Medicamento medi) {
        try {
            String sql = "delete from medicamento where meds_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, medi.getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao excluir Medicamento");
        }
    }
   
    
    public void inserir(Medicamento medi){
        try {
            String sql = "insert into medicamento (meds_nome, meds_qnt) values (?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, medi.getNome());
            ps.setString(2, medi.getQnt());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir Medicamento\n"+e);
        }
    }
   
    public void editar(Medicamento medi){
        try {
            String sql = "update medicamento set meds_nome = ?, "
                    + "meds_qnt = ?"
                    + " where meds_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, medi.getNome());
            ps.setString(2, medi.getQnt());
            ps.setInt(3, medi.getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao editar Medicamento\n"+e);
        }
    }
    
}
