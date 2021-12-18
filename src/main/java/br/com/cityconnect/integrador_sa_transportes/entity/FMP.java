package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@Entity
@Table(name = "fmp")
public class FMP implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SerializedName(value = "nao_usado")
	@Column(name = "Codigo")
	private Long id;

	@Column(name = "Descricao")
	private String descricao;

	@SerializedName(value = "data_inicial")
	@Column(name = "DataInicial")
	private String dataInicial;

	@SerializedName(value = "data_final")
	@Column(name = "DataFinal")
	private String dataFinal;

	@Column(name = "Valor")
	private String valor;

	@SerializedName(value = "moeda_id")
	@Column(name = "CodMoeda")
	private String moedaId;

}
