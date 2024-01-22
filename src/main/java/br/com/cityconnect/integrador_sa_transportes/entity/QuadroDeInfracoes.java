package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.SerializedName;

import br.com.cityconnect.integrador_sa_transportes.util.Util;
import lombok.Data;

@Data
@Entity
@Table(name = "quadroinfracao")
public class QuadroDeInfracoes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "Codigo")
	private String id;

	@Transient
	@SerializedName(value = "codigo")
	private String idIntegracao;

	@Column(name = "Descricao")
	private String descricao;

	@Column(name = "Acao")
	private String acao;

	@Column(name = "Reincidencia")
	private String reincidencia;

	@SerializedName(value = "modalidade")
	@Column(name = "ModalidadeTransporte")
	private String modalidadeTransporte;

	@SerializedName(value = "modalidade_id")
	@Transient
	private Integer modalidade_id;

	@SerializedName(value = "qtd_reincidencia")
	@Column(name = "QtdeReincidencia")
	private String qtdReincidencia;

	@SerializedName(value = "unidade_reincidencia")
	@Column(name = "UnidadeReincidencia")
	private String unidadeReincidencia;

	@SerializedName(value = "natureza_infracao_id")
	@Column(name = "Natureza")

	private String naturezaId;

	public void prepare() {
		Util util = new Util();
		this.modalidade_id = util.getModalidadeId(modalidadeTransporte);
		this.idIntegracao = this.id;
	}

}
