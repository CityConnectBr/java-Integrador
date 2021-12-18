package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.EmpresaVistoriadora;

public class EmpresaVistoriadoraDAO extends GenericDao<EmpresaVistoriadora, Long> {

	public EmpresaVistoriadoraDAO() {
		super();
	}
	
	public List<EmpresaVistoriadora> findAll() {
		return super.findAll();
	}

}
