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
@Table(name = "veiculos")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1934910641955849910L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "Placa")
	private String id;
	
	@SerializedName(value = "cod_renavam")
	@Column(name = "CodRenavam")
	private String codRenavam;
	
	@SerializedName(value = "marca_modelo_veiculo_id")
	@Column(name = "CodMarcaModelo")
	private Integer marcaModeloVeiculoId;
	
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
	
	@SerializedName(value = "tipo_veiculo_id")
	@Column(name = "TipoVeiculo")
	private Integer tipoVeiculoId;
	
	@Column(name = "Capacidade")
	private String capacidade;
	
	@SerializedName(value = "tipo_capacidade")
	@Column(name = "TipoCapacidade")
	private String tipoCapacidade;
	
	@SerializedName(value = "observacao_capacidade")
	@Column(name = "ObservacaoCapacidade")
	private String observacaoCapacidade;
	
	@SerializedName(value = "anos_vida_util_veiculo")
	@Column(name = "AnosVidaUtilVeiculo")
	private Integer anosVidaUtilVeiculo;

	@SerializedName(value = "situacao")
	@Column(name = "Situacao")
	private String situacao;// I, A, C

	@SerializedName(value = "permissionario_id")
	@Column(name = "NumCadastroPermissionario")
	private Integer permissionarioId;

	@Column(name = "versao", columnDefinition = "INT DEFAULT 0")
	private Integer versao;

}
