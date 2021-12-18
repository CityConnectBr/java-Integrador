package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.TalaoDoFiscalDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.TalaoDoFiscal;
import br.com.cityconnect.integrador_sa_transportes.service.TalaoDoFiscalService;

public class TalaoDoFiscalController extends MainController<TalaoDoFiscal, TalaoDoFiscalDAO, TalaoDoFiscalService>{

	public TalaoDoFiscalController() throws NumberFormatException {
		super(new TalaoDoFiscalService(), new TalaoDoFiscalDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
