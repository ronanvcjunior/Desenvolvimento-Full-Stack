package br.com.ronan.semana04.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_hospedagem")
public class Hospedagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospedagem")
    private Integer idHospedagem;

    @OneToOne
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;

    @OneToOne
    @JoinColumn(name = "id_hospede")
    private Hospede hospede;

    @Column(name = "dt_checkin")
    private java.sql.Date dtCheckin;

    @Column(name = "dt_checkout")
    private java.sql.Date dtCheckout;

    public Hospedagem(Quarto quarto, Hospede hospede, java.sql.Date dtCheckin, java.sql.Date dtCheckout) {
        this.quarto = quarto;
        this.hospede = hospede;
        this.dtCheckin = dtCheckin;
        this.dtCheckout = dtCheckout;
    }

    @Override
    public String toString() {
        return "Hospedagem [idHospedagem=" + idHospedagem + ", quartoId=" + quarto.getIdQuarto() + ", hospedeId=" + hospede.getIdHospede()
                + ", dtCheckin=" + dtCheckin + ", dtCheckout=" + dtCheckout + "]";
    }
}
