package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Onibus;

public class OnibusDAO extends GenericDao<Onibus, Long> {

	public OnibusDAO() {
		super();
	}
	
	public List<Onibus> findAll() {
		return super.findAll();
	}

}
