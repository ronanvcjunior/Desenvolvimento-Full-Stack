package br.com.ronan.semana03.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ronan.semana03.enums.CategoriaQuarto;

@Entity
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

    public Quarto () {}

    public Quarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
        
    }

    public Quarto(Hotel hotel, CategoriaQuarto categoriaQuarto, Integer qtdLeito, Integer nrQuarto, Double prDiaria) {
        this.hotel = hotel;
        this.categoriaQuarto = categoriaQuarto;
        this.qtdLeito = qtdLeito;
        this.nrQuarto = nrQuarto;
        this.prDiaria = prDiaria;
    }

    public Quarto(Integer idQuarto, Hotel hotel, CategoriaQuarto categoriaQuarto, Integer qtdLeito, Integer nrQuarto, Double prDiaria) {
        this.idQuarto = idQuarto;
        this.hotel = hotel;
        this.categoriaQuarto = categoriaQuarto;
        this.qtdLeito = qtdLeito;
        this.nrQuarto = nrQuarto;
        this.prDiaria = prDiaria;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public CategoriaQuarto getCategoriaQuarto() {
        return categoriaQuarto;
    }

    public void setCategoriaQuarto(CategoriaQuarto categoriaQuarto) {
        this.categoriaQuarto = categoriaQuarto;
    }

    public Integer getQtdLeito() {
        return qtdLeito;
    }

    public void setQtdLeito(Integer qtdLeito) {
        this.qtdLeito = qtdLeito;
    }

    public Integer getNrQuarto() {
        return nrQuarto;
    }

    public void setNrQuarto(Integer nrQuarto) {
        this.nrQuarto = nrQuarto;
    }

    public Double getPrDiaria() {
        return prDiaria;
    }

    public void setPrDiaria(Double prDiaria) {
        this.prDiaria = prDiaria;
    }

    @Override
    public String toString() {
        return "Quarto [idQuarto=" + idQuarto + ", idHotel=" + hotel.getIdHotel() + ", categoriaQuarto=" + categoriaQuarto
                + ", qtdLeito=" + qtdLeito + ", nrQuarto=" + nrQuarto + ", prDiaria=" + prDiaria + "]";
    }
}
