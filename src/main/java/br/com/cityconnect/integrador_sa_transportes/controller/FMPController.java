package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.FMPDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.FMP;
import br.com.cityconnect.integrador_sa_transportes.service.FMPService;

public class FMPController extends MainController<FMP, FMPDAO, FMPService>{

	public FMPController() throws NumberFormatException {
		super(new FMPService(), new FMPDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
