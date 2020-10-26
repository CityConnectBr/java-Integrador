package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.CondutoreAuxiliareDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;
import br.com.cityconnect.integrador_sa_transportes.service.CondutorAuxiliarService;

public class CondutorAuxiliarController extends MainController<CondutorAuxiliar, CondutoreAuxiliareDAO, CondutorAuxiliarService> {

	public CondutorAuxiliarController() throws NumberFormatException {
		super(new CondutorAuxiliarService(), new CondutoreAuxiliareDAO());
	}

}
