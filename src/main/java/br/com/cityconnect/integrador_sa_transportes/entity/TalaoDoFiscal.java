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
@Table(name = "talao")
public class TalaoDoFiscal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SerializedName(value = "numero")
	@Column(name = "Numero")
	private Long id;

	@SerializedName(value = "tipo_documento")
	@Column(name = "TipoDocumento")
	private String tipoDocumento;

	@SerializedName(value = "serie_documento")
	@Column(name = "SerieDocumeto")
	private String serie;

	@SerializedName(value = "numero_primeira_folha")
	@Column(name = "NumeroPrimeiraFolha")
	private String numeroPrimeiraFolha;

	@SerializedName(value = "numero_ultima_folha")
	@Column(name = "NumeroUltimaFolha")
	private String numeroUltimaFolha;


	@SerializedName(value = "data_recebimento")
	@Column(name = "DataRecebimento")
	private String dataRecebimento;


	@SerializedName(value = "fiscal_id")
	@Column(name = "CodAgente")
	private String fiscalId;

}
