package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.UpdateTimestamp;

import com.google.gson.annotations.SerializedName;

import br.com.cityconnect.integrador_sa_transportes.util.ScapeComparator;
import br.com.cityconnect.integrador_sa_transportes.util.Util;
import lombok.Data;

@Data
@Entity
@Table(name = "condutoresauxiliares")
public class CondutorAuxiliar implements Serializable {

	private static final long serialVersionUID = 1934910641955849910L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "CPF")
	private String id;

	@SerializedName(value = "cpf")
	@Transient
	private String CPF;
	
	@SerializedName(value = "id")
	@Transient
	private String idIntegracao;//originario da API
	
	@Column(name = "Nome")
	private String nome;// Nome
	
	@SerializedName(value = "rg")
	@Column(name = "RG")
	private String RG;// RG

	@SerializedName(value = "situacao")
	@Column(name = "Situacao")
	private String situacao;// I, A, C

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

	@SerializedName(value = "ddd")
	@Column(name = "DDD")
	private String DDD;// DDD

	@Column(name = "Telefone")
	private String telefone;// Telefone

	@Column(name = "Celular")
	private String celular;// Celular

	@Column(name = "Email")
	private String email;// Email

	@SerializedName(value = "cnh")
	@Column(name = "CNH")
	private String CNH;// CNH

	@SerializedName(value = "categoria_cnh")
	@Column(name = "CategoriaCNH")
	private String categoriaCNH;// CategoriaCNH
	
	@SerializedName(value = "vencimento_cnh")
	@Column(name = "VencimentoCNH")
	private String vencimentoCNH;// VencimentoCNH

	@SerializedName(value = "permissionario_id")
	@Column(name = "NumCadastroPermissionario")
	private Integer permissionarioId;// NumCadastroPermissionario

	@SerializedName(value = "validade_certidao_negativa")
	@Column(name = "ValidadeCertidaoNegativa")
	private String validadeCertidaoNegativa;

	@SerializedName(value = "emissao_primeiros_socorros")
	@Column(name = "EmissaoCursoPrimSocorros")
	private String emissaoCursoPrimSocorros;

	@SerializedName(value = "motivo_afastamento")
	@Column(name = "MotivoAfastamento")
	private String motivoAfastamento;

	@SerializedName(value = "atestado_de_saude")
	@Column(name = "AtestadoSaude")
	private String atestadoSaude;

	@SerializedName(value = "certidao_negativa")
	@Column(name = "CertidaoNegativa")
	private String certidaoNegativa;

	@SerializedName(value = "registro_ctps")
	@Column(name = "RegistroCTPS")
	private String registroCTPS;

	@SerializedName(value = "primeiros_socorros")
	@Column(name = "CursoPrimSocorros")
	private String cursoPrimSocorros;

	@SerializedName(value = "data_inicio_afastamento")
	@Column(name = "DataInicioAfastamento")
	private String dataInicioAfastamento;

	@SerializedName(value = "data_termino_afastamento")
	@Column(name = "DataTerminoAfastamento")
	private String dataTerminoAfastamento;

	@ScapeComparator
	@Column(name = "Foto")
	private Blob foto;
	
	@SerializedName(value = "foto_uid")
	@Column(name = "foto_uid")
	private String fotoUID;
	
	public void prepare() {
		Util util = new Util();
		this.telefone = util.formatTelephone(this.DDD, this.telefone);
		this.celular = util.formatTelephone(this.DDD, this.celular);
		this.RG = util.clearNumber(this.RG, 9);
		this.CPF = this.id;
	}

}
