package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.CursoDoPermissionario;

public class CursoDoPermissionarioDAO extends GenericDao<CursoDoPermissionario, Long> {

	public CursoDoPermissionarioDAO() {
		super();
	}
	
	public List<CursoDoPermissionario> findAll() {
		return super.findAll();
	}

}
