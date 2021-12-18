package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@Entity
@Table(name = "entidadescurso")
public class EntidadeCurso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "Codigo")
	private Long id;

	@Column(name = "Descricao")
	private String descricao;

	@SerializedName(value = "base_legal")
	@Column(name = "BseLegal")
	private String baseLegal;

}
