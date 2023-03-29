package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

import br.com.cityconnect.integrador_sa_transportes.util.Util;
import lombok.Data;

@Data
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "Codigo")
	private Long id;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "DDD")
	private String ddd;

	@Column(name = "Telefone")
	private String telefone;

	@Column(name = "Fax")
	private String fax;

	@SerializedName(value = "home_page")
	@Column(name = "HomePage")
	private String homePage;

	@Column(name = "Email")
	private String email;

	@Column(name = "CNPJ")
	private String cnpj;

	@SerializedName(value = "inscricao_estadual")
	@Column(name = "InscrEstadual")
	private String inscricaoEstadual;

	@SerializedName(value = "inscricao_municipal")
	@Column(name = "InscrMunicipal")
	private String inscricaoMunicipal;

	@SerializedName(value = "nome_do_diretor")
	@Column(name = "NomeDiretor")
	private String nomeDoDiretor;

	@SerializedName(value = "nome_do_gerente")
	@Column(name = "NomeGerente")
	private String nomeDoGerente;

	@SerializedName(value = "nome_do_encarregado_vistoriador")
	@Column(name = "NomeEncarregadoVistoriaMecanica")
	private String nomeDoEncarregadoVistoriador;

	@SerializedName(value = "portaria_diretor")
	@Column(name = "PortariaDiretor")
	private String portariaDiretor;

	@SerializedName(value = "data_nomeacao_diretor")
	@Column(name = "DataNomeacaoDiretor")
	private String dataNomecaoDiretor;

	@SerializedName(value = "decreto_municipal_taxi")
	@Column(name = "DecretoMunicipalTaxi")
	private String decretoMunicipalTaxi;

	@SerializedName(value = "decreto_municipal_escolar")
	@Column(name = "DecretoMunicipalEscolar")
	private String decretoMunicipalEscolar;

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

	@Column(name = "UF")
	private String uf;// uf

	@Column(name = "Municipio")
	private String municipio;// Municipio

	public void prepare() {
		Util util = new Util();
		this.telefone = util.formatTelephone(this.ddd, this.telefone);
		this.fax = util.formatTelephone(this.ddd, this.fax);
	}

}
