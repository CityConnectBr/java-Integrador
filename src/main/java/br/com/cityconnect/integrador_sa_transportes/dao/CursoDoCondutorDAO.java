package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.CursoDoCondutor;

public class CursoDoCondutorDAO extends GenericDao<CursoDoCondutor, Long> {

	public CursoDoCondutorDAO() {
		super();
	}
	
	public List<CursoDoCondutor> findAll() {
		return super.findAll();
	}

}
