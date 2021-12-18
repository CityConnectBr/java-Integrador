package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Vistoriador;

public class VistoriadorDAO extends GenericDao<Vistoriador, Long> {

	public VistoriadorDAO() {
		super();
	}
	
	public List<Vistoriador> findAll() {
		return super.findAll();
	}

}
