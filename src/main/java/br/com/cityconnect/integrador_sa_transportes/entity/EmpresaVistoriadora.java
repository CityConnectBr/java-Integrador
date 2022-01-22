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
@Table(name = "empresasvistoriadoras")
public class EmpresaVistoriadora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "Codigo")
	private Long id;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "Tipo")
	private String tipo;

	@Column(name = "DDD")
	private String ddd;

	@Column(name = "Telefone")
	private String telefone;

	@Column(name = "Email")
	private String email;

	@Column(name = "Cnpj")
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

	@SerializedName(value = "nome_delegado")
	@Column(name = "NomeDelegado")
	private String nomeDoDelegado;

	@SerializedName(value = "total_vistorias_dia")
	@Column(name = "TotalVistoriasDia")
	private String TotalVistoriasDia;

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
		this.telefone = util.limit(util.formatTelephone(this.ddd, this.telefone), 15);
	}
}
