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
@Table(name = "agentesfiscalizacao")
public class AgenteFiscalizacao implements Serializable {

	private static final long serialVersionUID = 1934910641955849910L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "Codigo")
	private Long id;// Codigo

	@Column(name = "Nome")
	private String nome;// Nome

	@SerializedName(value = "cpf")
	@Column(name = "CPF")
	private String CPF;
	
	@Column(name = "Endereco")
	private String endereco;// Endereco

	@Column(name = "Numero")
	private String numero;// Numero

	@Column(name = "Complemento")
	private String complemento;// Complemento

	@Column(name = "Bairro")
	private String bairro;// Bairro

	@Column(name = "Municipio")
	private String municipio;// Municipio

	//@Pattern(regexp = "\\d{8}", message = "Campo inválido")
	@SerializedName(value = "cep")
	@Column(name = "CEP")
	private String CEP;// CEP
	
	@SerializedName(value = "uf")
	@Column(name = "UF")
	private String UF;// UF

	@SerializedName(value = "ddd")
	@Column(name = "DDD")
	private String DDD;// DDD

	@Column(name = "Telefone")
	private String telefone;// Telefone

	@Column(name = "Email")
	private String email;// Email

	@Column(name = "Cargo")
	private String cargo;// Celular

	public void prepare() {
		Util util = new Util();
		this.telefone = util.formatTelephone(this.DDD, this.telefone);
	}
}
