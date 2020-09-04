package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloVeiculo;

public class MarcaModeloVeiculoDAO extends GenericDao<MarcaModeloVeiculo, Long> {

	public MarcaModeloVeiculoDAO() {
		super();
	}
	
	public List<MarcaModeloVeiculo> findAll() {
		return super.findAll();
	}

}
