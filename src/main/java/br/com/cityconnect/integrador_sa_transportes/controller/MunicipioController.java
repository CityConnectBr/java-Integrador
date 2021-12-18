package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.MunicipioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Municipio;
import br.com.cityconnect.integrador_sa_transportes.service.MunicipipService;

public class MunicipioController extends MainController<Municipio, MunicipioDAO, MunicipipService>{

	public MunicipioController() throws NumberFormatException {
		super(new MunicipipService(), new MunicipioDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
