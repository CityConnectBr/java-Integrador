package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@Entity
@Table(name = "onibus")
public class Onibus implements Serializable {

	private static final long serialVersionUID = 1934910641955849910L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "CodRenavam")
	private String id;

	@SerializedName(value = "id")
	@Column(name = "id_integracao")
	private Long idIntegracao;
	
	@SerializedName(value = "placa")
	@Column(name = "Placa")
	private String placa;

	@SerializedName(value = "marca_modelo_carroceria_id")
	@Column(name = "CodMarcaModeloCarroceria")
	private Integer marcaModeloCarroceriaId;

	@SerializedName(value = "marca_modelo_chassi_id")
	@Column(name = "CodMarcaModeloChassis")
	private Integer marcaModeloChassiId;

	@Column(name = "Chassis")
	private String chassi;

	@SerializedName(value = "tipo_combustivel_id")
	@Column(name = "CodCombustivel")
	private Integer tipoCombustivelId;

	@SerializedName(value = "ano_fabricacao")
	@Column(name = "AnoFabricacao")
	private String anoFabricacao;

	@SerializedName(value = "ano_modelo")
	@Column(name = "AnoModelo")
	private String anoModelo;

	@SerializedName(value = "cor_id")
	@Column(name = "CodCor")
	private Integer corId;

	@Column(name = "Capacidade")
	private String capacidade;

	@Column(name = "Prefixo")
	private String prefixo;

	@Column(name = "versao", columnDefinition = "INT DEFAULT 0")
	private Integer versao;

	@UpdateTimestamp
	@Column(name = "data_hora_alteracao_integracao")
	private Date dataHoraAlteracaoIntegracao;

}
