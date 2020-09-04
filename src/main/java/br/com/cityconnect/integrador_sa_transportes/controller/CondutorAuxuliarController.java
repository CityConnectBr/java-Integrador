package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.CondutoreAuxiliareDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;
import br.com.cityconnect.integrador_sa_transportes.service.CondutorAuxiliarService;

public class CondutorAuxuliarController extends MainController<CondutorAuxiliar, CondutoreAuxiliareDAO, CondutorAuxiliarService> {

	public CondutorAuxuliarController() {
		super(new CondutorAuxiliarService(), new CondutoreAuxiliareDAO());
	}

	@Override
	public void sinc() throws Exception {
		super.sincFull();
	}

}
