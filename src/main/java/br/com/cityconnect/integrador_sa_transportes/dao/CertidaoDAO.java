package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Certidao;

public class CertidaoDAO extends GenericDao<Certidao, String> {

	public CertidaoDAO() {
		super();
	}
	
	public List<Certidao> findAll() {
		return super.findAll();
	}
	
	public Certidao saveReturningEntity(Certidao entity)  {
    	return super.saveReturningEntity(entity);
    }

}
