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
@Table(name = "observacoespermissionarios")
public class ObservacaoDoPermissionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Titulo")
	private String titulo;

	@Id
	@SerializedName(value = "permissionario_id")
	@Column(name = "Permissionario")
	private String permissionarioId;

	@Column(name = "Observacao")
	private String observacao;

	@Id
	@Column(name = "Data")
	private String data;

}
