package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String dataHoraSincronizacao;

	@Column(name = "created_at")
	private String dataHoraCreatedAt;

	@Column(name = "updated_at")
	private String dataHoraUpdatedAt;

}