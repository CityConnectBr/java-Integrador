package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.OnibusDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Onibus;
import br.com.cityconnect.integrador_sa_transportes.service.OnibusService;

public class OnibusController extends MainController<Onibus, OnibusDAO, OnibusService> {

	public OnibusController() throws NumberFormatException {
		super(new OnibusService(), new OnibusDAO());
	}

}
