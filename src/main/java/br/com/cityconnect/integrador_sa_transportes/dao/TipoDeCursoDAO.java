package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.TipoDeCurso;

public class TipoDeCursoDAO extends GenericDao<TipoDeCurso, Long> {

	public TipoDeCursoDAO() {
		super();
	}
	
	public List<TipoDeCurso> findAll() {
		return super.findAll();
	}

}
