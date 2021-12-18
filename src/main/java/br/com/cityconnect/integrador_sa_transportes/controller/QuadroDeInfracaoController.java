package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.QuadrodeInfracaoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.QuadroDeInfracoes;
import br.com.cityconnect.integrador_sa_transportes.service.QuadroDeInfracoesService;

public class QuadroDeInfracaoController extends MainController<QuadroDeInfracoes, QuadrodeInfracaoDAO, QuadroDeInfracoesService>{

	public QuadroDeInfracaoController() throws NumberFormatException {
		super(new QuadroDeInfracoesService(), new QuadrodeInfracaoDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
