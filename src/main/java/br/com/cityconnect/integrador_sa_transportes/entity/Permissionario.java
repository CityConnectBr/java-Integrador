package br.com.cityconnect.integrador_sa_transportes.entity;

import lombok.Data;

@Data
public class Permissionario {
	
	private Long id;//NumeroCadastro	
	private String nome;//Nome
	private String tipo;//Pessoa: J/F
	private String CNPJ;//CNPJ
	private String RG;//RG
	private String inscricaoMunicipal;//InscricaoMunicipal
	private String CEP;//CEP
	private String endereco;//Endereco
	private String numero;//Numero
	private String complemento;//Complemento
	private String bairro;//Bairro
	private String municipio;//Municipio
	private String UF;//UF
	private String DDD;//DDD
	private String telefone;//Telefone
	private String celular;//Celular
	private String telefone2;//Recados
	private String email;//Email
	private String modalidadeTransporte;//ModalidadeTransporte
	private String dataNascimento;//DataNascimento
	private String naturalidade;//Naturalidade
	private String nacionalidade;//Nacionalidade
	private String CNH;//CNH
	private String categoriaCNH;//CategoriaCNH
	private String vencimentoCNH;//VencimentoCNH
	

}
