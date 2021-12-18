package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.PontoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Ponto;
import br.com.cityconnect.integrador_sa_transportes.service.PontoService;

public class PontoController extends MainController<Ponto, PontoDAO, PontoService>{

	public PontoController() throws NumberFormatException {
		super(new PontoService(), new PontoDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
