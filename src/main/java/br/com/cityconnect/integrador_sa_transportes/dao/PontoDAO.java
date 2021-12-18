package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Ponto;

public class PontoDAO extends GenericDao<Ponto, String> {

	public PontoDAO() {
		super();
	}
	
	public List<Ponto> findAll() {
		return super.findAll();
	}

}
