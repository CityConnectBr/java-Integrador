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
@Table(name = "solicitacoesdealteracao")
public class SolicitacaoDeAlteracao implements Serializable {

	private static final long serialVersionUID = 1934910641955849910L;

	@Id
	private Long id;

	@SerializedName(value = "referencia_id")
	@Column(name = "referencia_id")
	private String referenciaId;

	private Boolean sincronizado;

	private String status;

	private String campo1;

	private String campo2;

	private String campo3;

	private String campo4;

	private String campo5;

	private String campo6;

	private String campo7;

	private String campo8;

	private String campo9;

	private String campo10;

	private String campo11;

	private String campo12;

	private String campo13;

	private String campo14;

	private String campo15;

	private String campo16;

	private String campo17;

	private String campo18;

	private String campo19;

	private String campo20;

	@SerializedName(value = "tipo_solicitacao_id")
	@Column(name = "tipo_solicitacao_id")
	private String tipoSolicitacaoId;
	

}
