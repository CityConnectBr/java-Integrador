package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import lombok.Data;

@Data
@Entity
@Table(name = "historicodesincronizacao")
public class HistoricoDeSincronizacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;

	private String tabela;

	private String id_relacionado;

	private String acao;
	
	private Boolean sincronizado;
	
	@Column(name = "data_hora_sincronizacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dataHoraSincronizacao;

	@Column(name = "created_at")
	private String dataHoraCreatedAt;

	@Column(name = "updated_at")
	private String dataHoraUpdatedAt;

}