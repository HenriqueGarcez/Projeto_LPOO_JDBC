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
import modelo.Internacao;
import modelo.Medicamento;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author henri
 */
public class Internacao_DAO {
    Conexao conexao = new Conexao();
    Connection con = conexao.getConexao();

    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Internacao> buscar() {
        ArrayList<Internacao> listaInternacao = new ArrayList<>();
        try {
            String sql = "Select * from internacao, paciente, medicamento, cidade, medico where int_medicamento = meds_id and int_paciente = pac_id and pac_medico = med_id and pac_cidade = cid_id";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Internacao inte = new Internacao();
                inte.setId(rs.getInt("int_id"));
                inte.setQuarto(rs.getString("int_quarto"));
                inte.setDiag(rs.getString("int_diag"));
                
                Medicamento meds = new Medicamento();
                meds.setId(rs.getInt("meds_id"));
                meds.setNome(rs.getString("meds_nome"));
                meds.setQnt(rs.getString("meds_qnt"));
                
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
                
                inte.setMedicamento(meds);
                inte.setPaciente(pac);
                
                listaInternacao.add(inte);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados de Internações");
        }
        return listaInternacao;
    }

    
    public ArrayList<Internacao> buscar(String quarto){
        quarto = quarto.toLowerCase();
        ArrayList<Internacao> listaInternacao = new ArrayList<>();
        try {
            String sql = "Select * from internacao, paciente, medicamento, cidade, medico where int_medicamento = meds_id and int_paciente = pac_id and pac_medico = med_id and pac_cidade = cid_id and lower(int_quarto) like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+quarto+"%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Internacao inte = new Internacao();
                inte.setId(rs.getInt("int_id"));
                inte.setQuarto(rs.getString("int_quarto"));
                inte.setDiag(rs.getString("int_diag"));
                
                Medicamento meds = new Medicamento();
                meds.setId(rs.getInt("meds_id"));
                meds.setNome(rs.getString("meds_nome"));
                meds.setQnt(rs.getString("meds_qnt"));
                
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
                
                inte.setMedicamento(meds);
                inte.setPaciente(pac);
                
                listaInternacao.add(inte);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados de Internações");
        }
        return listaInternacao;
    }
    
    public ArrayList<Internacao> buscar(Paciente pac, String quarto) {
        ArrayList<Internacao> listaInternacao = new ArrayList<>();
        try {
            String sql = "Select * from internacao, paciente, medicamento, cidade, medico where int_medicamento = meds_id and int_paciente = pac_id and pac_medico = med_id and pac_cidade = cid_id and pac_id = ? and lower(int_quarto) like ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pac.getId());
            ps.setString(2, "%"+quarto+"%");
            rs = ps.executeQuery();

             while (rs.next()) {
                Internacao inte = new Internacao();
                inte.setId(rs.getInt("int_id"));
                inte.setQuarto(rs.getString("int_quarto"));
                inte.setDiag(rs.getString("int_diag"));
                
                Medicamento meds = new Medicamento();
                meds.setId(rs.getInt("meds_id"));
                meds.setNome(rs.getString("meds_nome"));
                meds.setQnt(rs.getString("meds_qnt"));
        
                Medico med = new Medico();
                med.setId(rs.getInt("med_id"));
                med.setNome(rs.getString("med_nome"));
                med.setEspec(rs.getString("med_espec"));
                
                Cidade cid = new Cidade();
                cid.setId(rs.getInt("cid_id"));
                cid.setNome(rs.getString("cid_nome"));
                
              //  pac.setMedico(med);
              //  pac.setCidade(cid);
                
                inte.setMedicamento(meds);
                inte.setPaciente(pac);
                
                listaInternacao.add(inte);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados de Internações");
        }
        return listaInternacao;
    }

    public void excluir(Internacao inte) {
        try {
            String sql = "delete from internacao where int_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, inte.getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao excluir internação");
        }
    }
   
    
    public void inserir(Internacao inte){
        try {
            String sql = "insert into internacao (int_quarto, int_diag, int_paciente, int_medicamento) values (?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, inte.getQuarto());
            ps.setString(2, inte.getDiag());
            ps.setInt(3, inte.getPaciente().getId());
            ps.setInt(4, inte.getMedicamento().getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir internacao\n"+e);
        }
    }
   
    public void editar(Internacao inte){
        try {
            String sql = "update internacao set int_quarto = ?, int_diag = ?, int_paciente = ?, int_medicamento = ? " + " where int_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, inte.getQuarto());
            ps.setString(2, inte.getDiag());
            ps.setInt(3, inte.getPaciente().getId());
            ps.setInt(4, inte.getMedicamento().getId());
            ps.setInt(5, inte.getId());
            ps.executeUpdate();
            
            ps.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao editar internacao\n"+e);
        }
    }
}
