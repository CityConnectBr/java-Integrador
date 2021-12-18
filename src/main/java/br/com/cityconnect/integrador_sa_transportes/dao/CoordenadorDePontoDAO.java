package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.CoordenadorDoPonto;

public class CoordenadorDePontoDAO extends GenericDao<CoordenadorDoPonto, String> {

	public CoordenadorDePontoDAO() {
		super();
	}
	
	public List<CoordenadorDoPonto> findAll() {
		return super.findAll();
	}

}
