package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.SerializedName;

import br.com.cityconnect.integrador_sa_transportes.util.Util;
import lombok.Data;

@Data
@Entity
@Table(name = "ponto")
public class Ponto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "Codigo")
	private String id;

	@Column(name = "descricao")
	private String descricao;

	@SerializedName(value = "data_criacao")
	@Column(name = "DataCriacao")
	private String dataCriacao;
	
	@SerializedName(value = "data_extincao")
	@Column(name = "DataExtincao")
	private String dataExtincao;

	@Column(name = "DDD")
	private String ddd;
	
	@Column(name = "Telefone")
	private String telefone;

	@SerializedName(value = "ocupacao_atual")
	@Column(name = "OcupacaoAtual")
	private String ocupacaoAtual;

	@Column(name = "Observacao")
	private String observacao;

	@SerializedName(value = "modalidade_transporte")
	@Column(name = "ModalidadeTransporte")
	private String modalidadeTransporte;
	
	@SerializedName(value = "modalidade_id")
	@Transient
	private Integer modalidade_id;	

	@SerializedName(value = "cep")
	@Column(name = "CEP")
	private String CEP;// CEP

	@Column(name = "Endereco")
	private String endereco;// Endereco

	@Column(name = "Numero")
	private String numero;// Numero

	@Column(name = "Complemento")
	private String complemento;// Complemento

	@Column(name = "Bairro")
	private String bairro;// Bairro

	@Column(name = "Municipio")
	@Transient
	private String municipio = "Santo André";// Municipio

	@SerializedName(value = "uf")
	@Transient
	private String UF = "SP";// UF
	
	public void prepare() {
		Util util = new Util();
		this.telefone = util.formatTelephone(this.ddd, this.telefone);
		this.modalidade_id = util.getModalidadeId(modalidadeTransporte);
	}

}
