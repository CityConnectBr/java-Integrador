package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.TalaoDoFiscal;

public class TalaoDoFiscalDAO extends GenericDao<TalaoDoFiscal, Long> {

	public TalaoDoFiscalDAO() {
		super();
	}
	
	public List<TalaoDoFiscal> findAll() {
		return super.findAll();
	}

}
