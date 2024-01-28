package br.com.cityconnect.integrador_sa_transportes.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

import br.com.cityconnect.integrador_sa_transportes.annotations.ExcludeGson;
import br.com.cityconnect.integrador_sa_transportes.util.ScapeComparator;
import br.com.cityconnect.integrador_sa_transportes.util.Util;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "permissionarios")
public class Permissionario implements Serializable {

	private static final long serialVersionUID = 1934910641955849910L;

	@Id
	@SerializedName(value = "id_integracao")
	@Column(name = "NumeroCadastro")
	private Long id;// NumeroCadastro

	@SerializedName(value = "nome_razao_social")
	@Column(name = "Nome")
	private String nome;// Nome

	@Column(name = "Pessoa")
	private String tipo;// Pessoa: J/F

	@SerializedName(value = "situacao")
	@Column(name = "Situacao")
	private String situacao;// I, A, C
	
	//@Pattern(regexp = "\\d{11}", message = "Campo inválido")
	//@Size(min = 11, max = 11)
	@SerializedName(value = "cpf_cnpj")
	@Column(name = "CNPJ")
	private String CNPJ;// CNPJ

	@SerializedName(value = "rg")
	@Column(name = "RG")
	private String RG;// RG

	@SerializedName(value = "inscricao_municipal")
	@Column(name = "InscricaoMunicipal")
	private String inscricaoMunicipal;// InscricaoMunicipal

	//@Pattern(regexp = "\\d{8}", message = "Campo inválido")
	@SerializedName(value = "cep")
	@Column(name = "CEP")
	private String CEP;// CEP

	@Column(name = "Endereco")
	private String endereco;// Endereco

	@Column(name = "Numero")
	private String numero;// Numero

	@Column(name = "Complemento")
	private String complemento;// Complemento

	@Column(name = "Bairro")
	private String bairro;// Bairro

	@Column(name = "Municipio")
	private String municipio;// Municipio

	@SerializedName(value = "uf")
	@Column(name = "UF")
	private String UF;// UF

	@SerializedName(value = "ddd")
	@Column(name = "DDD")
	private String DDD;// DDD

	@Column(name = "Telefone")
	private String telefone;// Telefone

	@Column(name = "Celular")
	private String celular;// Celular

	@Column(name = "Recados")
	private String telefone2;// Recados

	@Column(name = "Email")
	private String email;// Email

	@SerializedName(value = "modalidade_transporte")
	@Column(name = "ModalidadeTransporte")
	private String modalidadeTransporte;// ModalidadeTransporte

	@SerializedName(value = "data_nascimento")
	@Column(name = "DataNascimento")
	private String dataNascimento;// DataNascimento

	@Column(name = "Naturalidade")
	private String naturalidade;// Naturalidade

	@Column(name = "Nacionalidade")
	private String nacionalidade;// Nacionalidade

	@SerializedName(value = "cnh")
	@Column(name = "CNH")
	private String CNH;// CNH

	@SerializedName(value = "categoria_cnh")
	@Column(name = "CategoriaCNH")
	private String categoriaCNH;// CategoriaCNH

	@SerializedName(value = "vencimento_cnh")
	@Column(name = "VencimentoCNH")
	private String vencimentoCNH;// VencimentoCNH

	@SerializedName(value = "estado_civil")
	@Column(name = "EstadoCivil")
	private String estadoCivil;
	
	@SerializedName(value = "data_emissao")
	@Column(name = "DataEmissaoAlvara")
	private String dataEmissaoAlvara;
	
	@SerializedName(value = "data_vencimento")
	@Column(name = "DataVencimentoAlvara")
	private String dataVencimentoAlvara;
	
	@SerializedName(value = "data_retorno")
	@Column(name = "DataRetorno")
	private String dataRetorno;

	@SerializedName(value = "observacao_retorno")
	@Column(name = "ObservacaoRetorno")
	private String observacaoRetorno;
	
	@Column(name = "Prefixo")
	private String prefixo;
	
	@SerializedName(value = "inss")
	@Column(name = "NumeroRegistroINSS")
	private String inss;
	
	@SerializedName(value = "entidade_associativa_id")
	@Column(name = "EntidadeAssociativa")
	private String entidadeAssociativa;
	
	@Column(name = "Ponto1")
	private String ponto1;
	
	@Column(name = "Ponto2")
	private String ponto2;
	
	@Column(name = "Ponto3")
	private String ponto3;
	
	@Column(name = "Ponto4")
	private String ponto4;
	
	@Column(name = "Ponto5")
	private String ponto5;
	
	@Column(name = "Ponto6")
	private String ponto6;
	
	@Column(name = "Ponto7")
	private String ponto7;
	
	@Column(name = "Ponto8")
	private String ponto8;
	
	@Column(name = "Ponto9")
	private String ponto9;
	
	/*@SerializedName(value = "entidade_associativa_id")
	@Column(name = "AbcRadioTaxi")
	private String abcRadioTaxi;*/
	
	@SerializedName(value = "alvara_de_funcionamento")
	@Column(name = "AlvaraFuncionamento")
	private String alvaraFuncionamento;
	
	@SerializedName(value = "atestado_de_saude")
	@Column(name = "AtestadoSaude")
	private String atestadoSaude;
	
	@SerializedName(value = "ciretran_autorizacao")
	@Column(name = "CIRETRANAutorizacao")
	private String ciretranAutorizacao;
	
	@SerializedName(value = "ciretran_vistoria")
	@Column(name = "CIRETRANVistoria")
	private String ciretranVistoria;
	
	@SerializedName(value = "crlv")
	@Column(name = "CRLV")
	private String crlv;
	
	@SerializedName(value = "certidao_negativa")
	@Column(name = "CertidaoNegativa")
	private String certidaoNegativa;
	
	@SerializedName(value = "certificado_pontuacao_cnh")
	@Column(name = "CertificadoPontuacaoCNH")
	private String certificadoPontuacao;
	
	/*@SerializedName(value = "entidade_associativa_id")
	@Column(name = "Classificacao")
	private String classificacao;*/
	
	@SerializedName(value = "comprovante_de_endereco")
	@Column(name = "ComprovanteEndereco")
	private String comprovanteEndereco;
	
	@SerializedName(value = "contrato_comodato")
	@Column(name = "ContratoComodato")
	private String contratoComodato;
	
	/*@SerializedName(value = "entidade_associativa_id")
	@Column(name = "CooperAbcTadioTaxi")
	private String cooperAbcTadioTaxi;*/
	
	@SerializedName(value = "curso_primeiro_socorros")
	@Column(name = "CursoPrimSocorros")
	private String cursoPrimSocorros;
	
	@SerializedName(value = "dpvat")
	@Column(name = "DPVAT")
	private String dpvat;
	
	@SerializedName(value = "inicio_atividades")
	@Column(name = "DataInicioAtividades")
	private String dataInicioAtividades;
	
	@SerializedName(value = "data_obito")
	@Column(name = "DataObito")
	private String dataObito;
	
	//@SerializedName(value = "entidade_associativa_id")
	@Column(name = "DataProcessoSeletivo")
	private String dataProcessoSeletivo;
	
	@SerializedName(value = "termino_atividades")
	@Column(name = "DataTerminoAtividades")
	private String dataTerminoAtividades;
	
	@SerializedName(value = "termino_atividades_motivo")
	@Column(name = "MotivoTerminoAtividades")
	private String motivoTerminoAtividades;
	
	@SerializedName(value = "data_transferencia")
	@Column(name = "DataTransferencia")
	private String dataTransferencia;
	
	/*@SerializedName(value = "entidade_associativa_id")
	@Column(name = "DataVencimentoManual")
	private String dataVencimentoManual;*/
	
	/*@SerializedName(value = "entidade_associativa_id")
	@Column(name = "DeclaracaoMonitor")
	private String declaracaoMonitor;*/
	
	@SerializedName(value = "curso_primeiro_socorros_emissao")
	@Column(name = "EmissaoCursoPrimSocorros")
	private String emissaoCursoPrimSocorros;
	
	@SerializedName(value = "grau_de_paretesco_inventariante")
	@Column(name = "GrauParentesco")
	private String grauParentesco;
	
	@SerializedName(value = "ipva")
	@Column(name = "IPVA")
	private String ipva;
	
	@SerializedName(value = "inscricao_do_cadastro_mobiliario")
	@Column(name = "InscrCadMobiliario")
	private String inscrCadMobiliario;
	
	@SerializedName(value = "laudo_vistoria_com_aprovacao_da_sa_trans")
	@Column(name = "LaudoVistoria")
	private String laudoVistoria;
	
	/*@SerializedName(value = "entidade_associativa_id")
	@Column(name = "MaxxiTadioTaxi")
	private String maxxiTadioTaxi;*/
	
	@SerializedName(value = "nome_inventariante")
	@Column(name = "NomeInventariante")
	private String nomeInventariante;
	
	@SerializedName(value = "certidao_de_obito")
	@Column(name = "NumCertidaoObito")
	private String numCertidaoObito;
	
	@SerializedName(value = "numero_do_cadastro_mobiliario")
	@Column(name = "NumInscrCadMobiliario")
	private String numInscrCadMobiliario;
	
	@SerializedName(value = "numero_do_processo_do_inventario")
	@Column(name = "NumProcesso")
	private String numProcesso;
	
	@SerializedName(value = "numero_do_processo")
	@Column(name = "NumProcessoSeletivo")
	private String numProcessoSeletivo;
	
	@SerializedName(value = "taximetro_tacografo_numero")
	@Column(name = "NumTaximetro")
	private String numTaximetro;
	
	@SerializedName(value = "parecer_do_juiz_sobre_inventario")
	@Column(name = "ParecerJuiz")
	private String parecerJuiz;
	
	/*@SerializedName(value = "entidade_associativa_id")
	@Column(name = "Placa")
	private String placa;*/
	
	@SerializedName(value = "procurador_responsavel")
	@Column(name = "ProcuradorResponsavel")
	private String procuradorResponsavel;
	
	@SerializedName(value = "relacao_dos_alunos_transportados")
	@Column(name = "RelacaoAlunos")
	private String relacaoAlunos;
	
	@SerializedName(value = "responsavel")
	@Column(name = "Responsavel")
	private String responsavel;
	
	@SerializedName(value = "selo_gnv")
	@Column(name = "SeloGNV")
	private String seloGNV;
	
	@SerializedName(value = "taximetro_tacografo")
	@Column(name = "Taximetro")
	private String taximetro;
	
	@SerializedName(value = "taximetro_tacografo_afericao")
	@Column(name = "DataAfericaoTaximetro")
	private String dataAfericaoTaximetro;
	
	/*@SerializedName(value = "entidade_associativa_id")
	@Column(name = "UltimoAnoAlvara")
	private String ultimoAnoAlvara;*/
	
	@SerializedName(value = "validade_certidao_negativa")
	@Column(name = "ValidadeCertidaoNegativa")
	private String validadeCertidaoNegativa;
	
	@SerializedName(value = "contrato_comodato_validade")
	@Column(name = "ValidadeContratoComodato")
	private String validadeContratoComodato;
	
	@SerializedName(value = "selo_gnv_validade")
	@Column(name = "ValidadeSeloGNV")
	private String validadeSeloGNV;
	
	@ScapeComparator
	@Column(name = "Foto")
	@ExcludeGson
	private Blob foto;
	
	/*@SerializedName(value = "foto_uid")
	@Column(name = "foto_uid")
	private String fotoUID;*/
	
	public void prepare() {
		Util util = new Util();
		this.telefone = util.formatTelephone(this.DDD, this.telefone);
		this.telefone2 = util.formatTelephone(this.DDD, this.telefone2);
		this.celular = util.formatTelephone(this.DDD, this.celular);
		this.RG = util.clearNumber(this.RG, 9);
	}

}
