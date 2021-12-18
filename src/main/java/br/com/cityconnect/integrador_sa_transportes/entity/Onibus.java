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
@Table(name = "onibus")
public class Onibus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SerializedName(value = "placa")
	@Column(name = "Placa")
	private String id;
	
	@SerializedName(value = "cod_renavam")
	@Column(name = "CodRenavam")
	private String codRenavam;

	@SerializedName(value = "marca_modelo_carroceria_id")
	@Column(name = "CodMarcaModeloCarroceria")
	private Integer marcaModeloVeiculoCarroceriaId;
	
	@SerializedName(value = "marca_modelo_chassi_id")
	@Column(name = "CodMarcaModeloChassis")
	private Integer marcaModeloVeiculoChassisId;
	
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
	
	@SerializedName(value = "prefixo")
	@Column(name = "Prefixo")
	private String prefixo;

	@SerializedName(value = "permissionario_id")
	@Column(name = "NumCadastroPermissionario")
	private Integer permissionarioId;

}
