package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Monitor;

public class MonitorDAO extends GenericDao<Monitor, Long> {

	public MonitorDAO() {
		super();
	}
	
	public List<Monitor> findAll() {
		return super.findAll();
	}
	
	public Monitor saveReturningEntity(Monitor entity)  {
    	return super.saveReturningEntity(entity);
    }

}
