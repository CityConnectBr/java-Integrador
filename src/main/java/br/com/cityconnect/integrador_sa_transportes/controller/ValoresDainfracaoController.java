package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.ValoresDaInfracaoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.ValoresDaInfracao;
import br.com.cityconnect.integrador_sa_transportes.service.ValoresDaInfracaoService;

public class ValoresDainfracaoController extends MainController<ValoresDaInfracao, ValoresDaInfracaoDAO, ValoresDaInfracaoService>{

	public ValoresDainfracaoController() throws NumberFormatException {
		super(new ValoresDaInfracaoService(), new ValoresDaInfracaoDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
