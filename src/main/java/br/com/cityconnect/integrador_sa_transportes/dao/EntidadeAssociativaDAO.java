package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.EntidadeAssociativa;

public class EntidadeAssociativaDAO extends GenericDao<EntidadeAssociativa, Long> {

	public EntidadeAssociativaDAO() {
		super();
	}
	
	public List<EntidadeAssociativa> findAll() {
		return super.findAll();
	}

}
