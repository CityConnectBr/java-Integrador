package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.CursoDoPermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CursoDoPermissionario;
import br.com.cityconnect.integrador_sa_transportes.service.CursoDoPermissionarioService;

public class CursoDoPermissionarioController extends MainController<CursoDoPermissionario, CursoDoPermissionarioDAO, CursoDoPermissionarioService>{

	public CursoDoPermissionarioController() throws NumberFormatException {
		super(new CursoDoPermissionarioService(), new CursoDoPermissionarioDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
