package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.ObservacaoPermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.ObservacaoDoPermissionario;
import br.com.cityconnect.integrador_sa_transportes.service.OpservacaoDoPermissionarioService;

public class ObservacaoPermissionarioController extends MainController<ObservacaoDoPermissionario, ObservacaoPermissionarioDAO, OpservacaoDoPermissionarioService>{

	public ObservacaoPermissionarioController() throws NumberFormatException {
		super(new OpservacaoDoPermissionarioService(), new ObservacaoPermissionarioDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
