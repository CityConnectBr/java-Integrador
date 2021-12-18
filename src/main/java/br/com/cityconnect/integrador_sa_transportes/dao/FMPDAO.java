package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.FMP;

public class FMPDAO extends GenericDao<FMP, Long> {

	public FMPDAO() {
		super();
	}
	
	public List<FMP> findAll() {
		return super.findAll();
	}

}
