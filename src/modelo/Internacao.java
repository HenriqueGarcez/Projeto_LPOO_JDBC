/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author henri
 */
public class Internacao {
    
    private int id;
    private String quarto;
    private String diag;
    private Paciente paciente;
    private Medicamento medicamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public String getDiag() {
        return diag;
    }

    public void setDiag(String diag) {
        this.diag = diag;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    
    public String toString() {
    
        return quarto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.quarto);
        hash = 61 * hash + Objects.hashCode(this.diag);
        hash = 61 * hash + Objects.hashCode(this.paciente);
        hash = 61 * hash + Objects.hashCode(this.medicamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Internacao other = (Internacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.quarto, other.quarto)) {
            return false;
        }
        if (!Objects.equals(this.diag, other.diag)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.medicamento, other.medicamento)) {
            return false;
        }
        return true;
    }
    
    
    
}
