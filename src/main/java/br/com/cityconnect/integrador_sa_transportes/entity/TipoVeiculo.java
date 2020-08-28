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
@Table(name = "tiposveiculos")
public class TipoVeiculo implements Serializable {

	private static final long serialVersionUID = 1934910641955849910L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "Codigo")
	private Integer id;

	@SerializedName(value = "id")
	@Column(name = "id_integracao")
	private Long idIntegracao;

	@Column(name = "Descricao")
	private String descricao;

	@SerializedName(value = "modalidade_transporte")
	@Column(name = "ModalidadeTransporte")
	private String modalidadeTransporte;

	@SerializedName(value = "idade_limite_ingresso")
	@Column(name = "IdadeLimiteIngresso")
	private Integer idadeLimiteIngresso;

	@SerializedName(value = "idade_limite_permanencia")
	@Column(name = "IdadeLimitePermanencia")
	private Integer idadeLimitePermanencia;

}
