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
@Table(name = "cursospermissionarios")
public class CursoDoPermissionario implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@SerializedName(value = "nao_usado")
	@Column(name = "permissionario_id")
	private Long id;
	
	@SerializedName(value = "permissionario_id")
	@Column(name = "Permissionario")
	private String permissionario;

	@SerializedName(value = "tipo_do_curso_id")
	@Column(name = "TipoCurso")
	private String tipoCurso;

	@SerializedName(value = "data_emissao")
	@Column(name = "DataEmissaoCurso")
	private String dataEmissao;

}
