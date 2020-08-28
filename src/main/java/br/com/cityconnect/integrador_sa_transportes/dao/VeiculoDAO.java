package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Veiculo;

public class VeiculoDAO extends GenericDao<Veiculo, Long> {

	public VeiculoDAO() {
		super();
	}
	
	public List<Veiculo> findAll() {
		return super.findAll();
	}

}
