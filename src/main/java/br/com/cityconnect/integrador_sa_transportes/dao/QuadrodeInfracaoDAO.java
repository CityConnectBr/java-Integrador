package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.QuadroDeInfracoes;

public class QuadrodeInfracaoDAO extends GenericDao<QuadroDeInfracoes, String> {

	public QuadrodeInfracaoDAO() {
		super();
	}
	
	public List<QuadroDeInfracoes> findAll() {
		return super.findAll();
	}

}
