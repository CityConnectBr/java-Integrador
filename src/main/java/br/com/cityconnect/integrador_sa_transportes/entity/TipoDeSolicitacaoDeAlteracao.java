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

}
