package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.AgenteFiscalizacao;

public class MarcaModeloVeiculoDAO extends GenericDao<AgenteFiscalizacao, Long> {

	public MarcaModeloVeiculoDAO() {
		super();
	}
	
	public List<AgenteFiscalizacao> findAll() {
		return super.findAll();
	}

}
