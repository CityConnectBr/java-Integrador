package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.MonitorDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Monitor;
import br.com.cityconnect.integrador_sa_transportes.service.MonitorService;

public class MonitorController extends MainController<Monitor, MonitorDAO, MonitorService> {

	public MonitorController() throws NumberFormatException {
		super(new MonitorService(), new MonitorDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
