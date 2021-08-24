package br.com.ronan.semana04.domain;

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
@Table(name="tb_hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_hotel")
	private Integer idHotel;
	
	@Column(name="nome_hotel")
	private String nmHotel;
	
	private String endereco;

	@Column(name="quantidade_estrelas")
	private Integer qtdEstrelas;

	public Hotel(String nmHotel, String endereco, Integer qtdEstrelas) {
		super();
		this.nmHotel = nmHotel;
		this.endereco = endereco;
		this.qtdEstrelas = qtdEstrelas;
	}

	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nmHotel=" + nmHotel + ", endereco=" + endereco + ", qtdEstrelas="
				+ qtdEstrelas + "]";
	}
	
}
