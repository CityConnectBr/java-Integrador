package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

import br.com.cityconnect.integrador_sa_transportes.util.Util;
import lombok.Data;

@Data
@Entity
@Table(name = "certidoes")
public class Certidao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Ano")
	private String ano;
	
	@Id
	@Column(name = "Numero")
	private String numero;
	
	@Column(name = "Data")
	private String data;
	
	@SerializedName(value = "permissionario_id")
	@Column(name = "Permissionario")
	private String permissionarioId;
	
	@Column(name = "Tipo")
	private String tipo;
	
	@SerializedName(value = "marca_modelo_veiculo_id")
	@Column(name = "MarcaModeloVeiculo")
	private String marcaModeloVeiculo;
	
	@Column(name = "Renavam")
	private String renavam;
	
	@Column(name = "Placa")
	private String placa;
	
	@SerializedName(value = "ano_fabricacao")
	@Column(name = "AnoFabricacao")
	private String anoFabricacao;
	
	@Column(name = "Chassis")
	private String chassi;
	
	@SerializedName(value = "combustivel_id")
	@Column(name = "Combustivel")
	private String combustivelId;
	
	@SerializedName(value = "cor_id")
	@Column(name = "Cor")
	private String corId;
	
	@Column(name = "Prefixo")
	private String prefixo;
	
	@SerializedName(value = "ponto_id")
	@Column(name = "Ponto")
	private String pontoId;
	
	@Column(name = "Observacao")
	private String observacao;
	
	public void prepare() {
		Util util = new Util();
		
	}

}
