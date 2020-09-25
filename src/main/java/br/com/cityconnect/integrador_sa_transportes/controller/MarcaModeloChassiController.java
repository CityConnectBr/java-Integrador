package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.MarcaModeloChassiDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloChassi;
import br.com.cityconnect.integrador_sa_transportes.service.MarcaModeloChassiService;

public class MarcaModeloChassiController extends MainController<MarcaModeloChassi, MarcaModeloChassiDAO, MarcaModeloChassiService>{

	public MarcaModeloChassiController() {
		super(new MarcaModeloChassiService(), new MarcaModeloChassiDAO());
	}
	
	@Override
	public void sinc() throws Exception {
		super.sincOnlyRemote();
	}
	
}
