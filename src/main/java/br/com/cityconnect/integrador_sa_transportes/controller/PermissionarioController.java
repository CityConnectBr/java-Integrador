package br.com.cityconnect.integrador_sa_transportes.controller;

import java.io.IOException;

import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;
import br.com.cityconnect.integrador_sa_transportes.service.PermissionarioService;

public class PermissionarioController extends MainController<Permissionario, PermissionarioDAO, PermissionarioService> {

	public PermissionarioController() throws NumberFormatException {
		super(new PermissionarioService(), new PermissionarioDAO());
	}

	@Override
	public void sinc() throws Exception {
		super.sincFull();
	}

}
