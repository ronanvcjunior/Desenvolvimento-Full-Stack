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

import br.com.ronan.semana04.enums.CategoriaQuarto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_quarto")
public class Quarto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quarto")
    private Integer idQuarto;

    @OneToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @Column(name = "categoria_quarto")
    private CategoriaQuarto categoriaQuarto;

    @Column(name = "qtd_leito")
    private Integer qtdLeito;

    @Column(name = "nr_quarto")
    private Integer nrQuarto;

    @Column(name = "preco_diaria")
    private Double prDiaria;

    public Quarto(Hotel hotel, CategoriaQuarto categoriaQuarto, Integer qtdLeito, Integer nrQuarto, Double prDiaria) {
        this.hotel = hotel;
        this.categoriaQuarto = categoriaQuarto;
        this.qtdLeito = qtdLeito;
        this.nrQuarto = nrQuarto;
        this.prDiaria = prDiaria;
    }

    @Override
    public String toString() {
        return "Quarto [idQuarto=" + idQuarto + ", idHotel=" + hotel.getIdHotel() + ", categoriaQuarto=" + categoriaQuarto
                + ", qtdLeito=" + qtdLeito + ", nrQuarto=" + nrQuarto + ", prDiaria=" + prDiaria + "]";
    }
}
