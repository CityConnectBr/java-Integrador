package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.EmpresaDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Empresa;
import br.com.cityconnect.integrador_sa_transportes.service.EmpresaService;

public class EmpresaController extends MainController<Empresa, EmpresaDAO, EmpresaService>{

	public EmpresaController() throws NumberFormatException {
		super(new EmpresaService(), new EmpresaDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
