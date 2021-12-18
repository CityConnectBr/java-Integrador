package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.EmpresaVistoriadoraDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.EmpresaVistoriadora;
import br.com.cityconnect.integrador_sa_transportes.service.EmpresaVistoriadoraService;

public class EmpresaVistoriadoraController extends MainController<EmpresaVistoriadora, EmpresaVistoriadoraDAO, EmpresaVistoriadoraService>{

	public EmpresaVistoriadoraController() throws NumberFormatException {
		super(new EmpresaVistoriadoraService(), new EmpresaVistoriadoraDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
