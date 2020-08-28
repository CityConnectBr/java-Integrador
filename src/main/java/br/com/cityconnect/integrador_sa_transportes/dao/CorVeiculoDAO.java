package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.CorVeiculo;

public class CorVeiculoDAO extends GenericDao<CorVeiculo, Long> {

	public CorVeiculoDAO() {
		super();
	}
	
	public List<CorVeiculo> findAll() {
		return super.findAll();
	}

}
