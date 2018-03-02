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
import modelo.Cidade;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author henri
 */
public class Paciente_DAO {
    
    Conexao conexao = new Conexao();
    Connection con = conexao.getConexao();

    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Paciente> buscar() {
        ArrayList<Paciente> listaPaciente = new ArrayList<>();
        try {
            String sql = "Select * from paciente, medico, cidade where pac_medico = med_id and pac_cidade = cid_id";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Paciente pac = new Paciente();
                pac.setId(rs.getInt("pac_id"));
                pac.setNome(rs.getString("pac_nome"));
                pac.setCPF(rs.getString("pac_cpf"));
        
                Medico med = new Medico();
                med.setId(rs.getInt("med_id"));
                med.setNome(rs.getString("med_nome"));
                med.setEspec(rs.getString("med_espec"));
                
                Cidade cid = new Cidade();
                cid.setId(rs.getInt("cid_id"));
                cid.setNome(rs.getString("cid_nome"));
                
                pac.setMedico(med);
                pac.setCidade(cid);
                
                listaPaciente.add(pac);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados de Pacientes");
        }
        return listaPaciente;
    }

    
    public ArrayList<Paciente> buscar(String nome){
        nome = nome.toLowerCase();
        ArrayList<Paciente> listaPaciente = new ArrayList<>();
        try {
            String sql = "Select * from paciente, medico, cidade where pac_medico = med_id and pac_cidade = cid_id and lower(pac_nome) like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Paciente pac = new Paciente();
                pac.setId(rs.getInt("pac_id"));
                pac.setNome(rs.getString("pac_nome"));
                pac.setCPF(rs.getString("pac_cpf"));
        
                Medico med = new Medico();
                med.setId(rs.getInt("med_id"));
                med.setNome(rs.getString("med_nome"));
                med.setEspec(rs.getString("med_espec"));
                
                Cidade cid = new Cidade();
                cid.setId(rs.getInt("cid_id"));
                cid.setNome(rs.getString("cid_nome"));
                
                pac.setMedico(med);
                pac.setCidade(cid);
                
                listaPaciente.add(pac);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados de Pacientes");
        }
        return listaPaciente;
    }
    
    public ArrayList<Paciente> buscar(Medico med, String nome) {
        ArrayList<Paciente> listaPaciente = new ArrayList<>();
        try {
            String sql = "Select * from paciente, medico, cidade where pac_medico = med_id and pac_cidade = cid_id and med_id = ? and lower(pac_nome) like ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, med.getId());
            ps.setString(2, "%"+nome+"%");
            rs = ps.executeQuery();

             while (rs.next()) {
                Paciente pac = new Paciente();
                pac.setId(rs.getInt("pac_id"));
                pac.setNome(rs.getString("pac_nome"));
                pac.setCPF(rs.getString("pac_cpf"));
                
                Cidade cid = new Cidade();
                cid.setId(rs.getInt("cid_id"));
                cid.setNome(rs.getString("cid_nome"));
                
                pac.setMedico(med);
                pac.setCidade(cid);
                
                listaPaciente.add(pac);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados de Pacientes");
        }
        return listaPaciente;
    }

    public void excluir(Paciente pac) {
        try {
            String sql = "delete from paciente where pac_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pac.getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao excluir paciente");
        }
    }
   
    
    public void inserir(Paciente pac){
        try {
            String sql = "insert into paciente (pac_nome, pac_cpf, pac_medico, pac_cidade) values (?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, pac.getNome());
            ps.setString(2, pac.getCPF());
            ps.setInt(3, pac.getMedico().getId());
            ps.setInt(4, pac.getCidade().getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir paciente\n"+e);
        }
    }
   
    public void editar(Paciente pac){
        try {
            String sql = "update paciente set pac_nome = ?, pac_cpf = ?, pac_medico = ?, pac_cidade = ? " + " where pac_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, pac.getNome());
            ps.setString(2, pac.getCPF());
            ps.setInt(3, pac.getMedico().getId());
            ps.setInt(4, pac.getCidade().getId());
            ps.setInt(5, pac.getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao editar paciente\n"+e);
        }
    }
}
