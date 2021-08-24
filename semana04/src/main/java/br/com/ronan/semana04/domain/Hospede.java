package br.com.ronan.semana04.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_hospede")
public class Hospede implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospede")
    private Integer idHospede;

    @Column(name = "nm_hospede")
    private String nmHospede;

    @Column(name = "dt_nascimento")
    private java.sql.Date dtNascimento;
    
    private Integer cpf;

    public Hospede(String nmHospede, java.sql.Date dtNascimento, Integer cpf) {
        this.nmHospede = nmHospede;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return "Hospede [idHospede=" + idHospede + ", nmHospede=" + nmHospede + ", dtNascimento=" + dtNascimento + ", cpf=" + cpf + "]";
    }
}
