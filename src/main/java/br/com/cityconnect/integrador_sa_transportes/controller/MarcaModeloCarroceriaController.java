package br.com.cityconnect.integrador_sa_transportes.controller;

import java.io.IOException;

import br.com.cityconnect.integrador_sa_transportes.dao.MarcaModeloCarroceriaDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloCarroceria;
import br.com.cityconnect.integrador_sa_transportes.service.MarcaModeloCarroceriaService;

public class MarcaModeloCarroceriaController extends MainController<MarcaModeloCarroceria, MarcaModeloCarroceriaDAO, MarcaModeloCarroceriaService>{

	public MarcaModeloCarroceriaController() throws NumberFormatException {
		super(new MarcaModeloCarroceriaService(), new MarcaModeloCarroceriaDAO());
	}
	
	@Override
	public void sinc() throws Exception {
		super.sincOnlyRemote();
	}

}
