package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.TipoVeiculo;

public class TipoVeiculoDAO extends GenericDao<TipoVeiculo, Long> {

	public TipoVeiculoDAO() {
		super();
	}
	
	public List<TipoVeiculo> findAll() {
		return super.findAll();
	}
	

}
