package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.EntidadeCurso;

public class EntidadeCursoDAO extends GenericDao<EntidadeCurso, Long> {

	public EntidadeCursoDAO() {
		super();
	}
	
	public List<EntidadeCurso> findAll() {
		return super.findAll();
	}

}
