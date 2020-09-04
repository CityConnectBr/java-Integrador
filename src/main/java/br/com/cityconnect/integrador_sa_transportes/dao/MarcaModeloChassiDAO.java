package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloChassi;

public class MarcaModeloChassiDAO extends GenericDao<MarcaModeloChassi, Long> {

	public MarcaModeloChassiDAO() {
		super();
	}

	public List<MarcaModeloChassi> findAll() {
		return super.findAll();
	}

}
