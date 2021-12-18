package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.CoordenadorDePontoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CoordenadorDoPonto;
import br.com.cityconnect.integrador_sa_transportes.service.CoordenadorDoPontoService;

public class CoordenadorDePontoController extends MainController<CoordenadorDoPonto, CoordenadorDePontoDAO, CoordenadorDoPontoService>{

	public CoordenadorDePontoController() throws NumberFormatException {
		super(new CoordenadorDoPontoService(), new CoordenadorDePontoDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
