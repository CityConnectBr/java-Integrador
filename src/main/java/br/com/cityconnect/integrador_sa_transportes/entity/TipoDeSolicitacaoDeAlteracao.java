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
@Table(name = "tipossolicitacaodealteracao")
public class TipoDeSolicitacaoDeAlteracao implements Serializable {

	private static final long serialVersionUID = 1934910641955849910L;

	@Id
	private Long id;

	@Column
	private String nome;
	
	@SerializedName(value = "desc_campo1")
	@Column(name = "desc_campo1")
	private String descCampo1;
	
	@SerializedName(value = "desc_campo2")
	@Column(name = "desc_campo2")
	private String descCampo2;
	
	@SerializedName(value = "desc_campo3")
	@Column(name = "desc_campo3")
	private String descCampo3;
	
	@SerializedName(value = "desc_campo4")
	@Column(name = "desc_campo4")
	private String descCampo4;
	
	@SerializedName(value = "desc_campo5")
	@Column(name = "desc_campo5")
	private String descCampo5;
	
	@SerializedName(value = "desc_campo6")
	@Column(name = "desc_campo6")
	private String descCampo6;
	
	@SerializedName(value = "desc_campo7")
	@Column(name = "desc_campo7")
	private String descCampo7;
	
	@SerializedName(value = "desc_campo8")
	@Column(name = "desc_campo8")
	private String descCampo8;
	
	@SerializedName(value = "desc_campo9")
	@Column(name = "desc_campo9")
	private String descCampo9;
	
	@SerializedName(value = "desc_campo10")
	@Column(name = "desc_campo10")
	private String descCampo10;
	
	@SerializedName(value = "desc_campo11")
	@Column(name = "desc_campo11")
	private String descCampo11;
	
	@SerializedName(value = "desc_campo12")
	@Column(name = "desc_campo12")
	private String descCampo12;
	
	@SerializedName(value = "desc_campo13")
	@Column(name = "desc_campo13")
	private String descCampo13;
	
	@SerializedName(value = "desc_campo14")
	@Column(name = "desc_campo14")
	private String descCampo14;
	
	@SerializedName(value = "desc_campo15")
	@Column(name = "desc_campo15")
	private String descCampo15;
	
	@SerializedName(value = "desc_campo16")
	@Column(name = "desc_campo16")
	private String descCampo16;
	
	@SerializedName(value = "desc_campo17")
	@Column(name = "desc_campo17")
	private String descCampo17;
	
	@SerializedName(value = "desc_campo18")
	@Column(name = "desc_campo18")
	private String descCampo18;
	
	@SerializedName(value = "desc_campo19")
	@Column(name = "desc_campo19")
	private String descCampo19;
	
	@SerializedName(value = "desc_campo20")
	@Column(name = "desc_campo20")
	private String descCampo20;
	
	@SerializedName(value = "desc_campo21")
	@Column(name = "desc_campo21")
	private String descCampo21;
	
	@SerializedName(value = "desc_campo22")
	@Column(name = "desc_campo22")
	private String descCampo22;
	
	@SerializedName(value = "desc_campo23")
	@Column(name = "desc_campo23")
	private String descCampo23;
	
	@SerializedName(value = "desc_campo24")
	@Column(name = "desc_campo24")
	private String descCampo24;
	
	@SerializedName(value = "desc_campo25")
	@Column(name = "desc_campo25")
	private String descCampo25;
	
	@SerializedName(value = "nome_campo1")
	@Column(name = "nome_campo1")
	private String nomeCampo1;
	
	@SerializedName(value = "nome_campo2")
	@Column(name = "nome_campo2")
	private String nomeCampo2;
	
	@SerializedName(value = "nome_campo3")
	@Column(name = "nome_campo3")
	private String nomeCampo3;
	
	@SerializedName(value = "nome_campo4")
	@Column(name = "nome_campo4")
	private String nomeCampo4;
	
	@SerializedName(value = "nome_campo5")
	@Column(name = "nome_campo5")
	private String nomeCampo5;
	
	@SerializedName(value = "nome_campo6")
	@Column(name = "nome_campo6")
	private String nomeCampo6;
	
	@SerializedName(value = "nome_campo7")
	@Column(name = "nome_campo7")
	private String nomeCampo7;
	
	@SerializedName(value = "nome_campo8")
	@Column(name = "nome_campo8")
	private String nomeCampo8;
	
	@SerializedName(value = "nome_campo9")
	@Column(name = "nome_campo9")
	private String nomeCampo9;
	
	@SerializedName(value = "nome_campo10")
	@Column(name = "nome_campo10")
	private String nomeCampo10;
	
	@SerializedName(value = "nome_campo11")
	@Column(name = "nome_campo11")
	private String nomeCampo11;
	
	@SerializedName(value = "nome_campo12")
	@Column(name = "nome_campo12")
	private String nomeCampo12;
	
	@SerializedName(value = "nome_campo13")
	@Column(name = "nome_campo13")
	private String nomeCampo13;
	
	@SerializedName(value = "nome_campo14")
	@Column(name = "nome_campo14")
	private String nomeCampo14;
	
	@SerializedName(value = "nome_campo15")
	@Column(name = "nome_campo15")
	private String nomeCampo15;
	
	@SerializedName(value = "nome_campo16")
	@Column(name = "nome_campo16")
	private String nomeCampo16;
	
	@SerializedName(value = "nome_campo17")
	@Column(name = "nome_campo17")
	private String nomeCampo17;
	
	@SerializedName(value = "nome_campo18")
	@Column(name = "nome_campo18")
	private String nomeCampo18;
	
	@SerializedName(value = "nome_campo19")
	@Column(name = "nome_campo19")
	private String nomeCampo19;
	
	@SerializedName(value = "nome_campo20")
	@Column(name = "nome_campo20")
	private String nomeCampo20;
	
	@SerializedName(value = "nome_campo21")
	@Column(name = "nome_campo21")
	private String nomeCampo21;
	
	@SerializedName(value = "nome_campo22")
	@Column(name = "nome_campo22")
	private String nomeCampo22;
	
	@SerializedName(value = "nome_campo23")
	@Column(name = "nome_campo23")
	private String nomeCampo23;
	
	@SerializedName(value = "nome_campo24")
	@Column(name = "nome_campo24")
	private String nomeCampo24;
	
	@SerializedName(value = "nome_campo25")
	@Column(name = "nome_campo25")
	private String nomeCampo25;
	
	@SerializedName(value = "desc_arquivo1")
	@Column(name = "desc_arquivo1")
	private String descArquivo1;
	
	@SerializedName(value = "desc_arquivo2")
	@Column(name = "desc_arquivo2")
	private String descArquivo2;
	
	@SerializedName(value = "desc_arquivo3")
	@Column(name = "desc_arquivo3")
	private String descArquivo3;
	
	@SerializedName(value = "desc_arquivo4")
	@Column(name = "desc_arquivo4")
	private String descArquivo4;

}
