package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;

public class CondutoreAuxiliareDAO extends GenericDao<CondutorAuxiliar, Long> {

	public CondutoreAuxiliareDAO() {
		super();
	}
	
	public List<CondutorAuxiliar> findAll() {
		return super.findAll();
	}

}
