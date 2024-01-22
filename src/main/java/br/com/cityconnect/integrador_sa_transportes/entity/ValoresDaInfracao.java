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
@Table(name = "valoresinfracao")
public class ValoresDaInfracao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SerializedName(value = "outro_valor")//nao sera importado
	@Column(name = "Codigo")
	private Long id;

	@SerializedName(value = "modalidade_transporte")
	@Column(name = "ModalidadeTransporte")
	private String modalidadeTransporte;
	
	@SerializedName(value = "modalidade_id")
	@Transient
	private Integer modalidade_id;	

	@Column(name = "Qtde")
	private Integer quantidade;

	@Transient
	private String descricao;

	@SerializedName(value = "natureza_infracao_id")
	@Column(name = "natureza")
	private String naturezaId;

	@SerializedName(value = "moeda_id")
	@Column(name = "TipoMoeda")
	private String moedaId;
	
	public void prepare() {
		Util util = new Util();
		descricao = modalidadeTransporte;
		this.modalidade_id = util.getModalidadeId(modalidadeTransporte);
	}

}
