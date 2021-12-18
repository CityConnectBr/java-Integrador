package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.ObservacaoDoPermissionario;

public class ObservacaoPermissionarioDAO extends GenericDao<ObservacaoDoPermissionario, Long> {

	public ObservacaoPermissionarioDAO() {
		super();
	}
	
	public List<ObservacaoDoPermissionario> findAll() {
		return super.findAll();
	}

}
