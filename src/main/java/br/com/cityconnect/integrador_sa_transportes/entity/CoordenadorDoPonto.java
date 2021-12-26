package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@Entity
@Table(name = "coordenadoresponto")
public class CoordenadorDoPonto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SerializedName(value = "ponto_id")
	@Column(name = "Ponto")
	private String id;
	
	@Id
	@SerializedName(value = "permissionario_id")
	@Column(name = "Coordenador")
	private String permissionario;

	@Id
	@SerializedName(value = "data_inicial")
	@Column(name = "DataInicial")
	private String dataInicial;

	@SerializedName(value = "data_termino")
	@Column(name = "DataTermino")
	private String dataTermino;

	@Column(name = "Observacoes")
	private String observacao;

}
