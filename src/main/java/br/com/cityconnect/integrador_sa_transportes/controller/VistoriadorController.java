package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.VistoriadorDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Vistoriador;
import br.com.cityconnect.integrador_sa_transportes.service.VistoriadorService;

public class VistoriadorController extends MainController<Vistoriador, VistoriadorDAO, VistoriadorService>{

	public VistoriadorController() throws NumberFormatException {
		super(new VistoriadorService(), new VistoriadorDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
