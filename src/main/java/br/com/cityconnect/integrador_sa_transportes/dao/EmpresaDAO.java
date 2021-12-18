package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Empresa;

public class EmpresaDAO extends GenericDao<Empresa, Long> {

	public EmpresaDAO() {
		super();
	}
	
	public List<Empresa> findAll() {
		return super.findAll();
	}

}
