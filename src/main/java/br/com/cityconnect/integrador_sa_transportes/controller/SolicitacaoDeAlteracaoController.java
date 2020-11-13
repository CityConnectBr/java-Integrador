package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.SolicitacaoDeAlteracaoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.SolicitacaoDeAlteracao;
import br.com.cityconnect.integrador_sa_transportes.service.SolicitacaoDeAlteracapService;

public class SolicitacaoDeAlteracaoController extends MainController<SolicitacaoDeAlteracao, SolicitacaoDeAlteracaoDAO, SolicitacaoDeAlteracapService> {

	public SolicitacaoDeAlteracaoController() throws NumberFormatException {
		super(new SolicitacaoDeAlteracapService(), new SolicitacaoDeAlteracaoDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}
