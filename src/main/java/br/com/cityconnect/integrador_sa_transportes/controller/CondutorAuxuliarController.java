package br.com.cityconnect.integrador_sa_transportes.controller;

import java.io.IOException;

import br.com.cityconnect.integrador_sa_transportes.dao.CondutoreAuxiliareDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;
import br.com.cityconnect.integrador_sa_transportes.service.CondutorAuxiliarService;

public class CondutorAuxuliarController extends MainController<CondutorAuxiliar, CondutoreAuxiliareDAO, CondutorAuxiliarService> {

	public CondutorAuxuliarController() throws NumberFormatException {
		super(new CondutorAuxiliarService(), new CondutoreAuxiliareDAO());
	}

	@Override
	public void sinc() throws Exception {
		super.sincFull();
	}

}
