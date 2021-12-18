package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Municipio;

public class MunicipioDAO extends GenericDao<Municipio, Long> {

	public MunicipioDAO() {
		super();
	}
	
	public List<Municipio> findAll() {
		return super.findAll();
	}

}
