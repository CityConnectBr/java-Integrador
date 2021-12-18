package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.ValoresDaInfracao;

public class ValoresDaInfracaoDAO extends GenericDao<ValoresDaInfracao, Long> {

	public ValoresDaInfracaoDAO() {
		super();
	}
	
	public List<ValoresDaInfracao> findAll() {
		return super.findAll();
	}

}
