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
@Table(name = "marcasmodelosveiculos")
public class TipoCombustivel implements Serializable {

	private static final long serialVersionUID = 1934910641955849910L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "CODIGO")
	private Integer id;

	@SerializedName(value = "id")
	@Column(name = "id_integracao")
	private Long idIntegracao;

	@Column(name = "DESCRICAO")
	private String descricao;

}
