package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloCarroceria;

public class MarcaModeloCarroceriaDAO extends GenericDao<MarcaModeloCarroceria, Long> {

	public MarcaModeloCarroceriaDAO() {
		super();
	}

	public List<MarcaModeloCarroceria> findAll() {
		return super.findAll();
	}

}
