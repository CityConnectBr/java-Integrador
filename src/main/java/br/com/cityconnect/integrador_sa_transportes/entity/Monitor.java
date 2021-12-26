package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.SerializedName;

import br.com.cityconnect.integrador_sa_transportes.util.ScapeComparator;
import br.com.cityconnect.integrador_sa_transportes.util.Util;
import lombok.Data;

@Data
@Entity
@Table(name = "monitores")
public class Monitor implements Serializable {

	private static final long serialVersionUID = -5871614660370049931L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "RG")
	private String id;// NumeroCadastro
	
	@SerializedName(value = "rg")
	@Transient
	private String RG;
	
	@SerializedName(value = "id")
	@Transient
	private String idIntegracao;//originario da API
	
	@Column(name = "Nome")
	private String nome;// Nome
	
	@SerializedName(value = "cpf")
	@Column(name = "CPF")
	private String CPF;// CPF

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
	private String municipio;// Municipio

	@SerializedName(value = "uf")
	@Column(name = "UF")
	private String UF;// UF

	@Column(name = "Telefone")
	private String telefone;// Telefone (SEM DDD)

	@Column(name = "Email")
	private String email;// Email

	@SerializedName(value = "data_nascimento")
	@Column(name = "DataNascimento")
	private String dataNascimento;// DataNascimento

	@SerializedName(value = "permissionario_id")
	@Column(name = "NumCadastroPermissionario")
	private Integer permissionarioId;// NumCadastroPermissionario

	@SerializedName(value = "curso_de_primeiro_socorros")
	@Column(name = "CursoPrimSocorros")
	private String cursoPrimSocorros;

	@SerializedName(value = "emissao_curso_de_primeiro_socorros")
	@Column(name = "EmissaoCursoPrimSocorros")
	private String emissaoCursoPrimSocorros;

	@SerializedName(value = "certidao_negativa")
	@Column(name = "CertidaoNegativa")
	private String certidaoNegativa;

	@SerializedName(value = "validade_da_certidao_negativa")
	@Column(name = "ValidadeCertidaoNegativa")
	private String validadeCertidaoNegativa;
	
	@ScapeComparator
	@Column(name = "Foto")
	private Blob foto;
	
	@SerializedName(value = "foto_uid")
	@Column(name = "foto_uid")
	private String fotoUID;
	
	public void prepare() {
		Util util = new Util();
		this.telefone = util.formatTelephone(null, this.telefone);
		this.RG = util.clearNumber(this.RG, 9);
	}

}
