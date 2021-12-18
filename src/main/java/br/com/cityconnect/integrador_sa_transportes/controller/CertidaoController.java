package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.CertidaoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Certidao;
import br.com.cityconnect.integrador_sa_transportes.service.CertidaoService;

public class CertidaoController extends MainController<Certidao, CertidaoDAO, CertidaoService>{

	public CertidaoController() throws NumberFormatException {
		super(new CertidaoService(), new CertidaoDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
