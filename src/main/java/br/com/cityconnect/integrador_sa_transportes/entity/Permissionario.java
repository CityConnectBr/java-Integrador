package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.UpdateTimestamp;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@Entity
@Table(name = "permissionarios")
public class Permissionario implements Serializable {

	private static final long serialVersionUID = 1934910641955849910L;

	@Id
	@SerializedName(value = "id_permissionario_integracao")
	@Column(name = "NumeroCadastro")
	private Long id;// NumeroCadastro

	@SerializedName(value = "id")
	@Column(name = "id_integracao")
	private Long idIntegracao;

	@Column(name = "Nome")
	private String nome;// Nome

	@Column(name = "Pessoa")
	private String tipo;// Pessoa: J/F

	//@Pattern(regexp = "\\d{11}", message = "Campo inválido")
	//@Size(min = 11, max = 11)
	@Column(name = "CNPJ")
	private String CNPJ;// CNPJ

	@Column(name = "RG")
	private String RG;// RG

	@SerializedName(value = "inscricao_municipal")
	@Column(name = "InscricaoMunicipal")
	private String inscricaoMunicipal;// InscricaoMunicipal

	//@Pattern(regexp = "\\d{8}", message = "Campo inválido")
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
	private String municipio;// Municipio

	@Column(name = "UF")
	private String UF;// UF

	@Column(name = "DDD")
	private String DDD;// DDD

	@Column(name = "Telefone")
	private String telefone;// Telefone

	@Column(name = "Celular")
	private String celular;// Celular

	@Column(name = "Recados")
	private String telefone2;// Recados

	@Column(name = "Email")
	private String email;// Email

	@SerializedName(value = "modalidade_transporte")
	@Column(name = "ModalidadeTransporte")
	private String modalidadeTransporte;// ModalidadeTransporte

	@SerializedName(value = "data_nascimento")
	@Column(name = "DataNascimento")
	private String dataNascimento;// DataNascimento

	@Column(name = "Naturalidade")
	private String naturalidade;// Naturalidade

	@Column(name = "Nacionalidade")
	private String nacionalidade;// Nacionalidade

	@Column(name = "CNH")
	private String CNH;// CNH

	@SerializedName(value = "categoria_CNH")
	@Column(name = "CategoriaCNH")
	private String categoriaCNH;// CategoriaCNH

	@SerializedName(value = "vencimento_CNH")
	@Column(name = "VencimentoCNH")
	private String vencimentoCNH;// VencimentoCNH

	@Column(name = "versao", columnDefinition = "INT DEFAULT 0")
	private Integer versao;

	@UpdateTimestamp
	@Column(name = "data_hora_alteracao_integracao")
	private Date dataHoraAlteracaoIntegracao;

}
