package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@Entity
@Table(name = "solicitacoesdealteracao")
public class SolicitacaoDeAlteracao implements Serializable {

	private static final long serialVersionUID = 1934910641955849910L;

	@Id
	private Long id;//recebi mesmo ID do Obj vindo da API

	@SerializedName(value = "referencia_remota_id")
	@Column(name = "referencia_id")
	private String referenciaId;

	//private Boolean sincronizado;

	private Boolean sincronizadoComAPI = Boolean.FALSE;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dataHoraSincronizadoComAPI;

	private String status;// A-ACEITO,R-RECUSADO,C-CANCELADO,NULL-AGUARDANDO

	@SerializedName(value = "motivo_recusado")
	@Column(name = "motivo_recusado")
	private String motivoRecusado;

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

	private String campo21;

	private String campo22;

	private String campo23;

	private String campo24;

	private String campo25;

	@SerializedName(value = "arquivo1_uid")
	@Column(name = "arquivo1_uid")
	private String arquivo1UID;

	@SerializedName(value = "arquivo2_uid")
	@Column(name = "arquivo2_uid")
	private String arquivo2UID;

	@SerializedName(value = "arquivo3_uid")
	@Column(name = "arquivo3_uid")
	private String arquivo3UID;

	@SerializedName(value = "arquivo4_uid")
	@Column(name = "arquivo4_uid")
	private String arquivo4UID;


	@SerializedName(value = "tipo_solicitacao_id")
	@Column(name = "tipo_solicitacao_id")
	private String tipoSolicitacaoId;

}
