package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.MarcaModeloCarroceriaDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloCarroceria;
import br.com.cityconnect.integrador_sa_transportes.service.MarcaModeloCarroceriaService;

public class MarcaModeloCarroceriaController extends MainController<MarcaModeloCarroceria, MarcaModeloCarroceriaDAO, MarcaModeloCarroceriaService>{

	public MarcaModeloCarroceriaController() {
		super(new MarcaModeloCarroceriaService(), new MarcaModeloCarroceriaDAO());
	}
	
	@Override
	public void sinc() throws Exception {
		super.sincHalf();
	}

}
