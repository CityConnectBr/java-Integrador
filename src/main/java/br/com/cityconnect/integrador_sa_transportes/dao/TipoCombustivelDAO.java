package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.TipoCombustivel;

public class TipoCombustivelDAO extends GenericDao<TipoCombustivel, Long> {

	public TipoCombustivelDAO() {
		super();
	}
	
	public List<TipoCombustivel> findAll() {
		return super.findAll();
	}

}
