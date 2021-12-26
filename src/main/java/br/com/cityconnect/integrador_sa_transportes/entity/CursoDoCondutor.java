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
@Table(name = "cursoscondutoresauxiliares")
public class CursoDoCondutor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id	
	@SerializedName(value = "condutor_id")
	@Column(name = "CondutorAuxiliar")
	private String condutor;

	@Id	
	@SerializedName(value = "tipo_do_curso_id")
	@Column(name = "TipoCurso")
	private String tipoCurso;

	@SerializedName(value = "data_emissao")
	@Column(name = "DataEmissaoCurso")
	private String dataEmissao;

}
